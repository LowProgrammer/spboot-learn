package com.java.learn.NewIO;

import java.io.*;

/**
 * @author feifei
 * @Classname NewIODemo
 * @Description TODO
 * @Date 2019/8/21 15:43
 * @Created by 陈群飞
 */
public class NewIODemo {
    public static void main(String[] args) {
        try {
            BufferedReader in=new BufferedReader(new FileReader(args[0]));

            String s,s2=new String();
            while ((s=in.readLine())!=null){
                s2+=s+"\n";
            }

            in.close();

            BufferedReader stdin=new BufferedReader( new InputStreamReader(System.in));
            System.out.println("enter a line:");
            System.out.println(stdin.readLine());

            StringReader in2=new StringReader(s2);
            int c;
            while ((c=in2.read())!=-1){
                System.out.println((char) c);
            }

            try{
                DataInputStream in3=new DataInputStream(new StringBufferInputStream(s2));
                while(true){
                    System.out.print((char) in3.readByte());
                }
            }catch (EOFException e){
                System.out.println("end of stream");
            }

            try{
                LineNumberReader li=new LineNumberReader(new StringReader(s2));
                BufferedReader in4=new BufferedReader(li);
                PrintWriter out1=new PrintWriter(new BufferedWriter(new FileWriter("IODemo.out")));
                while ((s=in4.readLine())!=null){
                    out1.println("Line "+li.getLineNumber()+s);
                }
                out1.close();
            }catch (EOFException e){
                System.out.println("end of stream");
            }

            try{
                DataOutputStream out2=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
                out2.writeDouble(3.1415926);
                out2.writeBytes("that was pi");
                out2.close();
                DataInputStream in5=new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
                BufferedReader in5br=new BufferedReader(new InputStreamReader(in5));
                System.out.println(in5.readDouble());
                System.out.println(in5br.readLine());
            }catch (EOFException e){
                System.out.println("end of stream");
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found"+args[1]);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO exception");
            e.printStackTrace();
        }
    }
}
