package com.java.learn.compress;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * @author feifei
 * @Classname ZipCompress
 * @Description TODO zip多文件压缩
 * @Date 2019/8/21 17:12
 * @Created by 陈群飞
 */
public class ZipCompress {
    public static void main(String[] args){
        //args= new String[]{"D:\\project\\work\\demo-grpc\\java-prac\\test.txt", "D:\\project\\work\\demo-grpc\\java-prac\\Data.txt","D:\\project\\work\\demo-grpc\\java-prac\\IODemo.out"};
        try{
            FileOutputStream f=new FileOutputStream("test.zip");
            CheckedOutputStream csum=new CheckedOutputStream(f,new Adler32());

            ZipOutputStream out=new ZipOutputStream(new BufferedOutputStream(csum));
            out.setComment("a test of java Zipping");
            for (int i = 0; i < args.length; i++) {
                System.out.println("writing file "+args[i]);
                BufferedReader in=new BufferedReader(new FileReader(args[i]));
                out.putNextEntry(new ZipEntry(args[i]));
                int c;
                while((c=in.read())!=-1){
                    out.write(c);
                }
                in.close();
            }
            out.close();
            System.out.println("checksum:"+csum.getChecksum().getValue());
            System.out.println("reading file");
            FileInputStream fi=new FileInputStream("test.zip");
            CheckedInputStream csumi=new CheckedInputStream(fi,new Adler32());

            ZipInputStream in2=new ZipInputStream(new BufferedInputStream(csumi));
            ZipEntry ze;
            System.out.println("checksum:"+csumi.getChecksum().getValue());
            while((ze=in2.getNextEntry())!=null){
                System.out.println("reading file"+ze);
                int x;
                while((x=in2.read())!=-1){
                    System.out.write(x);
                }
            }
            in2.close();


            ZipFile zf=new ZipFile("test.zip");
            Enumeration e=zf.entries();
            while(e.hasMoreElements()){
                ZipEntry ze2=(ZipEntry) e.nextElement();
                System.out.println("File: "+ze2);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
