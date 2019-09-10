package com.java.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author feifei
 * @Classname JabberServer
 * @Description TODO
 * @Date 2019/9/5 16:28
 * @Created by 陈群飞
 */
public class JabberServer {
    public static final int PORT=8080;

    public static void main(String[] args) throws IOException {
        ServerSocket s=new ServerSocket(PORT);
        System.out.println("start:"+s);
        try {
            Socket socket = s.accept();
            try {


                System.out.println("accept" + socket);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

                while (true) {
                    String str = in.readLine();
                    if (str.equals("end")) {
                        break;
                    }
                    System.out.println("echo:" + str);
                    out.println(str);
                }
            } finally {
                System.out.println("closing");
                socket.close();
            }
        }finally {
            s.close();
        }

    }
}
