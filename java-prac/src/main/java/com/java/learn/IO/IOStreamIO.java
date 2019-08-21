package com.java.learn.IO;

import java.io.*;

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
                System.out.print((char) c);
            }

            try{
                DataInputStream in3=new DataInputStream(new StringBufferInputStream(s2));
                while (true){
                    System.out.println((char) in3.readByte());
                }
            }catch (EOFException e){
                System.out.println("end of stream encountered");
            }


            try{
                LineNumberInputStream li=new LineNumberInputStream(new StringBufferInputStream(s2));
                DataInputStream in4=new DataInputStream(li);
                PrintStream out1=new PrintStream(new BufferedOutputStream(new FileOutputStream("IODemo.out")));

                while((s=in4.readLine())!=null){
                    out1.println("line "+li.getLineNumber()+s);
                }
                out1.close();
            }catch (EOFException e){
                System.out.println("end of stream encountered");
            }

            try{
                DataOutputStream out2=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
                out2.writeBytes("Here is the value of pi:\n");
                out2.writeDouble(3.14159);
                out2.close();

                DataInputStream in5=new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
                System.out.println(in5.readLine());
                System.out.println(in5.readDouble());

            }catch (EOFException e){
                System.out.println("end of stream encountered");
            }

            RandomAccessFile rf=new RandomAccessFile("rtest.dat","rw");
            for (int i = 0; i < 10; i++) {
                rf.writeDouble(i*1.414);
            }
            rf.close();

            rf=new RandomAccessFile("rtest.dat","rw");
            rf.seek(5*8);
            rf.writeDouble(47.0001);
            rf.close();

            rf=new RandomAccessFile("rtest.dat","r");
            for (int i = 0; i < 10; i++) {
                System.out.println(
                        "value "+i+":"+rf.readDouble()
                );
            }
            rf.close();

            InFile in6=new InFile(args[0]);
            String s3=new String();
            System.out.println("First line in file:"+in6.readLine());
            in6.close();

            PrintFile out3=new PrintFile("Data2.txt");
            out3.print("test of printFile");
            out3.close();

            OutFile out4=new OutFile("Data3.txt");
            out4.writeBytes("test of outdatafile\n\r");
            out4.writeChars("test of outofdatafile\n\r");
        }catch (FileNotFoundException e){
            System.out.println("file not found"+args[0]);
        }catch (IOException e){
            System.out.println("IO ex");
        }
    }
}
