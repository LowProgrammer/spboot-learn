package com.java.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author feifei
 * @Classname ChatterServer
 * @Description TODO
 * @Date 2019/9/5 18:56
 * @Created by 陈群飞
 */
public class ChatterServer {
    static final int INPORT=1711;
    private byte[] buf=new byte[1000];
    private DatagramPacket dp=new DatagramPacket(buf,buf.length);
    private DatagramSocket socket;
    public ChatterServer(){
        try{
            socket=new DatagramSocket(INPORT);
            System.out.println("server started");
            while (true){
                socket.receive(dp);
                String rcvd=Dgram.toString(dp)+" from address"+dp.getAddress()+", port : "+dp.getPort();
                System.out.println(rcvd);
                String echoString="echoed:"+rcvd;
                DatagramPacket echo=Dgram.toDatagram(echoString,dp.getAddress(),dp.getPort());
                socket.send(echo);
            }
        }catch (SocketException e)
        {
            System.err.println("can't open socket");
            System.exit(1);
        }catch (IOException e){
            System.err.println("communication error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatterServer();
    }
}
