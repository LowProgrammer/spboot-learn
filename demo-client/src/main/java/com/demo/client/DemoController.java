package com.demo.client;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname DemoController
 * @Description TODO
 * @Date 2019/6/22 16:36
 * @Created by ChenS
 */
@RestController
public class DemoController {
    @Autowired
    private ClientService service;

    @RequestMapping("/hello")
    public String helloworld(String name) {
        return service.getMessage(name);
    }

    @RequestMapping("/stream")
    public String streamHelloworld(String name) {
        return service.getStreamMessage(name);
    }

    @RequestMapping("/Sxxx")
    public String getSxxx(String searchKey,

                          @RequestParam(value = "searchType", required = false) String searchType) {
        String res = "";

        CloseableHttpClient client = HttpClientBuilder.create().build();

        URI uri = null;
        try {
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("searchKey", searchKey));
            params.add(new BasicNameValuePair("key", "89620de4ef904adfbdc4e225b7b200e9"));
            uri = new URIBuilder().setScheme("http").setHost("api.qichacha.com")
                    .setPort(80).setPath("/CourtV4/SearchShiXin")
                    .setParameters(params)
                    .build();
            //uri = new URI("http://api.qichacha.com/CourtV4/SearchShiXin");

        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpGet httpGet = new HttpGet(uri);

        HttpResponse response = null;
        try {
            String key = "89620de4ef904adfbdc4e225b7b200e9";
            String secretKey = "51E902FC3433E1FE30BC05C5DE5C69D5";
            Date date = new Date();
            String timeScan = String.valueOf(date.getTime() / 1000);
            System.out.println(timeScan);
            httpGet.setHeader("Token", MD5(key + timeScan + secretKey));
            httpGet.setHeader("Timespan", timeScan);

            RequestConfig config = RequestConfig.custom()

                    .build();
            httpGet.setConfig(config);

            response = client.execute(httpGet);

            res = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
