package com.java.learn.compress;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author feifei
 * @Classname GZIPcompress
 * @Description TODO gz格式压缩
 * @Date 2019/8/21 17:02
 * @Created by 陈群飞
 */
public class GZIPcompress {
    public static void main(String[] args) {
        try{
            BufferedReader in=new BufferedReader(new FileReader("D:\\project\\work\\demo-grpc\\java-prac\\test.txt"));

            BufferedOutputStream out=new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));

            System.out.println("writing file");
            int c;
            while((c=in.read())!=-1){
                out.write(c);
            }
            in.close();
            out.close();
            System.out.println("reading file ");
            BufferedReader in2=new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
            String s;
            while((s=in2.readLine())!=null){
                System.out.println(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
