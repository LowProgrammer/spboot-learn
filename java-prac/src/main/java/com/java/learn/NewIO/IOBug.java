package com.java.learn.NewIO;

import java.io.*;

/**
 * @author feifei
 * @Classname IOBug
 * @Description TODO
 * @Date 2019/8/21 16:32
 * @Created by 陈群飞
 */
public class IOBug {
    public static void main(String[] args) throws Exception {
        DataOutputStream out=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));

        out.writeDouble(3.14159);
        out.writeBytes("this is the value of pi\n");
        out.writeBytes("this is pi/2:\n");
        out.writeDouble(3.14159/2);
        out.close();
        DataInputStream in=new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
        BufferedReader inbr=new BufferedReader(new InputStreamReader(in));

        System.out.println(in.readDouble());
        System.out.println(inbr.readLine());
        System.out.println(inbr.readLine());
        System.out.println(in.readDouble());
    }
}
