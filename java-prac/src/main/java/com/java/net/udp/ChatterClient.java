package com.java.net.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author feifei
 * @Classname ChatterClient
 * @Description TODO
 * @Date 2019/9/6 14:39
 * @Created by 陈群飞
 */
public class ChatterClient extends Thread {

    private DatagramSocket s;
    private InetAddress hostAdderss;
    private byte[] buf=new byte[1000];
    private DatagramPacket dp=new DatagramPacket(buf,buf.length);
    private int id;

    public ChatterClient(int identifier){
        id=identifier;
        try {
            s=new DatagramSocket();
            hostAdderss=InetAddress.getByName("localhost");

        } catch (UnknownHostException e) {
            System.err.println("cannot find host");
            System.exit(1);
            e.printStackTrace();
        } catch (SocketException e) {
            System.err.println("cannot open socket");
            e.printStackTrace();
        }
        System.out.println("starting.....");
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i < 25; i++) {
                String outMessage="client #"+id+",message #"+i;
                s.send(Dgram.toDatagram(outMessage,hostAdderss,ChatterServer.INPORT));
                s.receive(dp);

                String rcvd="client #"+id+",rcvd from"+dp.getAddress()+","+dp.getPort()+":"+Dgram.toString(dp);
                System.out.println(rcvd);
            }
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ChatterClient(i).start();
        }
    }
}
