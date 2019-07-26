package com.demo.service;

import com.demo.mapper.ImageMapper;
import com.demo.model.Image;
import com.demo.utils.PaseHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Classname GetSourceService
 * @Description TODO
 * @Date 2019/6/25 14:24
 * @Created by ChenS
 */
@Service
public class GetSourceService {

    @Autowired
    private ImageMapper mapper;


    public String getRequstContent(String requestUrl) {
        String res = "";
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(requestUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //connection.setRequestProperty();


            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                InputStreamReader streamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(streamReader);

                String str;
                while ((str = reader.readLine()) != null) {
                    buffer.append(str);
                }
                reader.close();
                streamReader.close();
                inputStream.close();

                Image image = new Image();
                image.setName("fei");
                image.setUrl("www.baidu.com");
                addSource(image);
            }
        } catch (Exception e) {
            System.out.println(123465789);
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public String getPostContent(String path, String post) {
        URL url = null;
        try {
            url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("connection", "keep-alive");
            httpURLConnection.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
            httpURLConnection.setRequestProperty("User-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
            httpURLConnection.setRequestMethod("POST");// Post请求
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // POST需设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数(post请求的参数一般可以从浏览器里查请求的时候看到参数是哪些)
            printWriter.write(post);//post的参数 形式为xx=xx&yy=yy

            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while ((len = bis.read(arr)) != -1) {
                bos.write(arr, 0, len);
                bos.flush();
            }
            bos.close();
            //如果是json数据可以这样解析然后返回JsonObject类型的对象
//          JsonParser parse =new JsonParser();
//          JsonObject res2 = (JsonObject)parse.parse(bos.toString("utf-8"));
            PaseHtml.parseGetImage(bos.toString());
            return bos.toString("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean addSource(Image im) {
        try {
            mapper.insert(im);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    private void keepSource() {

    }
}
