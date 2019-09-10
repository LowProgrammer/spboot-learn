package com.java.net.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author feifei
 * @Classname JabberClient
 * @Description TODO
 * @Date 2019/9/5 16:44
 * @Created by 陈群飞
 */
public class JabberClient {
    public static void main(String[] args) throws IOException {
        InetAddress address=InetAddress.getByName(null);

        System.out.println("addr="+address);
        Socket socket=new Socket(address,JabberServer.PORT);

        try{
            System.out.println("socket="+socket);
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);

            for (int i = 0; i < 10; i++) {
                out.println("howdy"+i);
                String str=in.readLine();
                System.out.println(str);
            }
            out.println("end");
        }finally {
            System.out.println("closing");
            socket.close();
        }
    }
}
