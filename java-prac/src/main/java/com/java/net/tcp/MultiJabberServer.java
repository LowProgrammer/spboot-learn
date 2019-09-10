package com.java.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author feifei
 * @Classname ServerOneJabber
 * @Description TODO
 * @Date 2019/9/5 17:13
 * @Created by 陈群飞
 */
class ServerOneJabber extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerOneJabber(Socket s) throws IOException {
        socket=s;
        in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
        start();
    }

    @Override
    public void run() {
        try{
            while (true){
                String str=in.readLine();
                if (str.equals("end")){
                    break;
                }
                System.out.println("echo:"+str);
                out.println(str);
            }
            System.out.println("closing");
        }catch (IOException e){

        }finally {
            try{
                socket.close();
                System.out.println("123145678921qwerttyuio");
            }catch (IOException e){

            }
        }
    }
}

public class MultiJabberServer{
    static  final int PORT=8080;

    public static void main(String[] args) throws IOException {
        ServerSocket s=new ServerSocket(PORT);
        System.out.println("server started");
        try{
            while (true){
                Socket socket=s.accept();
                try{
                    new ServerOneJabber(socket);
                }catch (IOException e){
                    socket.close();
                }
            }
        }finally {
            s.close();
        }
    }
}
