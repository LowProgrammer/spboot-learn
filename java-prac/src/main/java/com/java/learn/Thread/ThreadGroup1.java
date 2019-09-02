package com.java.learn.Thread;

/**
 * @author feifei
 * @Classname ThreadGroup
 * @Description TODO
 * @Date 2019/9/2 16:48
 * @Created by 陈群飞
 */
public class ThreadGroup1 {
    public static void main(String[] args) {
        java.lang.ThreadGroup sys=Thread.currentThread().getThreadGroup();
        sys.list();

        System.out.println();
        sys.setMaxPriority(Thread.MAX_PRIORITY-1);
        Thread curr=Thread.currentThread();
        curr.setPriority(curr.getPriority()+1);
        sys.list();

        System.out.println();
        ThreadGroup g1=new ThreadGroup("g1");
        g1.setMaxPriority(Thread.MAX_PRIORITY);
        Thread t=new Thread(g1,"A");
        t.setPriority(Thread.MAX_PRIORITY);
        g1.list();

        System.out.println();
        g1.setMaxPriority(Thread.MAX_PRIORITY-2);
        g1.setMaxPriority(Thread.MAX_PRIORITY);
        g1.list();

        System.out.println();
        t=new Thread(g1,"B");
        t.setPriority(Thread.MAX_PRIORITY);
        g1.list();

        g1.setMaxPriority(Thread.MAX_PRIORITY+2);
        t=new Thread(g1,"C");
        g1.list();
        t.setPriority(t.getPriority()-1);
        g1.list();

        ThreadGroup g2=new ThreadGroup(g1,"g2");
        g2.list();
        g2.setMaxPriority(Thread.MAX_PRIORITY);
        g2.list();
        for (int i = 0; i < 5; i++) {
            new Thread(g2,Integer.toString(i));
        }
        sys.list();

        System.out.println("Starting all threads");
        Thread[] all=new Thread[sys.activeCount()];
        sys.enumerate(all);
        for (int i = 0; i < all.length; i++) {
            if(!all[i].isAlive()){
                all[i].start();
            }
        }
        System.out.println("All threads started");
        sys.suspend();
        System.out.println("suspended");
        sys.stop();
        System.out.println("stopped");
    }
}
