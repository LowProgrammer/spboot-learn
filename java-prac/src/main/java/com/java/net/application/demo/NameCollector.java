package com.java.net.application.demo;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author feifei
 * @Classname NameCollector
 * @Description TODO
 * @Date 2019/9/6 17:28
 * @Created by 陈群飞
 */
public class NameCollector {
    final static int COLLECTOR_PORT=8080;
    final static int BUFFER_SIZE=1000;
    byte[] buf=new byte[BUFFER_SIZE];

    DatagramPacket dp=new DatagramPacket(buf,buf.length);
    DatagramSocket socket;
    Process listmgr;
    PrintStream nameList;
    DataInputStream addResult;

    public NameCollector(){
        try {
            listmgr=Runtime.getRuntime().exec("listmgr.exe");
            nameList=new PrintStream(new BufferedOutputStream(listmgr.getOutputStream()));
            addResult=new DataInputStream(new BufferedInputStream(listmgr.getInputStream()));
        }catch (IOException e){
            System.err.println("cannot start listmgr.exe");
            System.exit(1);
        }

        try {
            socket=new DatagramSocket(COLLECTOR_PORT);
            System.out.println("nameCollector server started");
            while (true){
                socket.receive(dp);
                String rcvd=new String(dp.getData(),0,0,dp.getLength());

                nameList.println(rcvd.trim());
                nameList.flush();
                byte[] resultBuf=new byte[BUFFER_SIZE];
                int byteCount=addResult.read(resultBuf);
                if (byteCount!=-1){
                    String result=new String(resultBuf,0).trim();
                    InetAddress senderAddrss=dp.getAddress();
                    int senderPort=dp.getPort();
                    byte[] echoBuf=new byte[BUFFER_SIZE];
                    result.getBytes(0,byteCount,echoBuf,0);
                    DatagramPacket echo=new DatagramPacket(echoBuf,echoBuf.length,senderAddrss,senderPort);
                }else{
                    System.out.println("unexpected lack of result from .exe");
                }
            }
        }catch (SocketException e){
            System.err.println("cannot open socket");
            System.exit(1);
        }catch (IOException e){
            System.err.println("communication error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new NameCollector();
    }
}
