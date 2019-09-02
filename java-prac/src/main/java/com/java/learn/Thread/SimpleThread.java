package com.java.learn.Thread;

/**
 * @author feifei
 * @Classname SimpleThread
 * @Description TODO
 * @Date 2019/8/28 17:34
 * @Created by 陈群飞
 */
public class SimpleThread extends Thread {
    private int countDown=10;
    private int threadNumber;
    private static int threadCount=0;

    public SimpleThread(){
        threadNumber=++threadCount;
        System.out.println("making thread"+threadNumber);
    }

    @Override
    public void run() {
        while (true){
            System.out.println("Thread"+
                    threadNumber+"("+countDown+")");
            try {
                if (threadNumber==2) {
                    System.out.println("sleep .......");
                    sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (--countDown==0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread().start();

        }
        System.out.println("All thread start");
    }
}
