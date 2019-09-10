package com.java.net.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author feifei
 * @Classname MultiJabberClient
 * @Description TODO
 * @Date 2019/9/5 17:51
 * @Created by 陈群飞
 */
class JabberClientThread extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private static int counter=0;
    private int id=counter++;
    private static  int threadcount=0;

    public static int threadCount(){
        return threadcount;
    }

    public JabberClientThread(InetAddress address){
        System.out.println("making client"+id);
        threadcount++;

        try{
            socket=new Socket(address,MultiJabberClient.PORT);
        }catch (IOException e){

        }

        try{
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            start();
        }catch (IOException e){
            try{
                socket.close();
            }catch (IOException e1){

            }
        }
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i < 25; i++) {
                out.println("client "+id+":"+i);
                String str=in.readLine();
                System.out.println(str);
            }
            out.println("end");

        }catch (IOException e){}
        finally {
            try {
                socket.close();
            }catch (IOException e){}
            threadcount--;
        }
    }
}
public class MultiJabberClient {
    static final int MAX_THREADS=120;

    public static final int PORT=8080;
    public static void main(String[] args) throws InterruptedException, UnknownHostException {
        InetAddress address=InetAddress.getByName(null);
        while (true){
            if (JabberClientThread.threadCount()<MAX_THREADS){
                new JabberClientThread(address);
            }
            Thread.sleep(100);
        }
    }
}
