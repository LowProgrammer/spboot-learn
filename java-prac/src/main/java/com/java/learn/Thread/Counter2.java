package com.java.learn.Thread;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author feifei
 * @Classname Counter2
 * @Description TODO
 * @Date 2019/8/28 18:00
 * @Created by 陈群飞
 */
class SeparateSubTask extends Thread{
    private int count=0;
    private Counter2 c2;
    public boolean runFlag=true;

    public SeparateSubTask(Counter2 c2){
        this.c2=c2;
        start();
    }
    public void invertFlag(){
        runFlag=!runFlag;
    }

    @Override
    public void run() {
        while (true){
            try{
                sleep(100);
            }catch (InterruptedException e){

            }
            if (runFlag){
                c2.t.setText(Integer.toString(count++));
            }
        }
    }
}
public class Counter2 extends Applet {
    TextField t=new TextField(10);
    private SeparateSubTask sp=null;
    private Button
        onOff=new Button("Toggle"),
        start=new Button("start");
    @Override
    public void init(){
        add(t);
        start.addActionListener(new StartL());
        add(start);
        onOff.addActionListener(new OnOffL());
        add(onOff);
    }
    class StartL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (sp==null){
                sp=new SeparateSubTask(Counter2.this);
            }
        }
    }
    class OnOffL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (sp!=null){
                sp.invertFlag();
            }
        }
    }

    public static void main(String[] args) {
        Counter2 applet=new Counter2();
        Frame frame=new Frame("Counter");
        frame.addWindowListener(new
                                        WindowAdapter() {
                                            @Override
                                            public void windowClosing(WindowEvent e) {
                                                System.exit(0);
                                            }
                                        }
        );
        frame.add(applet,BorderLayout.CENTER);
        frame.setSize(300,200);
        applet.init();
        applet.start();
        frame.setVisible(true);
    }
}
