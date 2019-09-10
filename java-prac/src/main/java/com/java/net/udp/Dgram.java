package com.java.net.udp;

import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 * @author feifei
 * @Classname Dgram
 * @Description TODO
 * @Date 2019/9/5 18:49
 * @Created by 陈群飞
 */
public class Dgram {
    public static DatagramPacket toDatagram(String s, InetAddress address,int destPort){
        byte[] buf=new byte[s.length()+1];
        s.getBytes(0,s.length(),buf,0);

        byte[] bytes=s.getBytes();
        return new DatagramPacket(buf,buf.length,address,destPort);
    }


    public static String toString(DatagramPacket packet) {

        return new String(packet.getData(),0,packet.getLength());
    }


}
