package com.java.learn.Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author feifei
 * @Classname Daemon
 * @Description TODO
 * @Date 2019/8/29 18:05
 * @Created by 陈群飞
 */
class Daemon extends Thread {
    private static final int SIZE=10;
    private Thread[] t=new Thread[SIZE];

    public Daemon(){
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < SIZE; i++) {
            t[i]=new DaemonSpawn(i);
        }
        for (int i = 0; i < SIZE; i++) {
            System.out.println(t[i].isDaemon());
        }
        while (true){
            yield();
        }
    }
}
class DaemonSpawn extends Thread{
    //public static int num=0;
    public DaemonSpawn(int i){
        System.out.println("DaemonSpawn"+i+" started");
        start();
    }

    @Override
    public void run() {
        while (true){
            ///System.out.println("计数"+num++);
            yield();
        }
    }
}

public class Daemons{
    public static void main(String[] args) {
        Thread d=new Daemon();
        System.out.println("d.isDaemon()"+d.isDaemon());

        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("waiting for cr");
        try{
            stdin.readLine();
        }catch (IOException e){

        }
    }
}