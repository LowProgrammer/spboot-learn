package com.java.learn.IO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author feifei
 * @Classname Echo
 * @Description TODO 从控制台读取再读出信息
 * @Date 2019/8/21 14:03
 * @Created by 陈群飞
 */
public class Echo {
    public static void main(String[] args) {
        DataInputStream in=new DataInputStream(new BufferedInputStream(System.in));
        String s;
        try {
            while ((s = in.readLine()).length() != 0) {
                System.out.println(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
