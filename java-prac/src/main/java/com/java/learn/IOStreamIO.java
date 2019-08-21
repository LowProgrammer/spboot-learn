package com.java.learn;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.StringBufferInputStream;

/**
 * @author feifei
 * @Classname IOStreamIO
 * @Description TODO
 * @Date 2019/8/20 17:25
 * @Created by 陈群飞
 */
public class IOStreamIO {
    public static void main(String[] args) {
        try{
            DataInputStream in=
                    new DataInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(args[0])));
            String s,s2=new String();
            while((s=in.readLine())!=null){
                s2+=s+"\n";
            }
            in.close();

            StringBufferInputStream in2=new StringBufferInputStream(s2);
            int c;
            while((c=in2.read())!=-1){
                System.out.println((char) c);
            }
        }catch (Exception e){

        }
    }
}
