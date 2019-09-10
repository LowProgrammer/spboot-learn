package com.java.net.application.demo;

import java.applet.Applet;
import java.awt.*;
import java.net.*;

/**
 * @author feifei
 * @Classname NameSender
 * @Description TODO
 * @Date 2019/9/9 9:43
 * @Created by 陈群飞
 */
public class NameSender extends Applet implements Runnable {
    private Thread p1=null;
    private Button send=new Button("add email address to mailing list");
    private TextField t=new TextField("type your email address heere",40);
    private String str=new String();
    private Label l=new Label(),l2=new Label();
    private DatagramSocket s;
    private InetAddress hostAddress;
    private byte[] buf=new byte[NameCollector.BUFFER_SIZE];
    private DatagramPacket dp=new DatagramPacket(buf,buf.length);
    private int count=0;
    @Override
    public void init(){
        setLayout(new BorderLayout());
        Panel p=new Panel();
        p.setLayout(new GridLayout(2,1));
        p.add(t);
        p.add(send);
        add("north",p);
        Panel labels=new Panel();
        labels.setLayout(new GridLayout(2,1));
        labels.add(l);
        labels.add(l2);
        add("center",labels);

        try{
            s=new DatagramSocket();
            hostAddress=InetAddress.getByName(getCodeBase().getHost());
        }catch (UnknownHostException e){
            l.setText("cannot find host ");
        }catch (SocketException e){
            l.setText("cannot open socket");
        }

        l.setText("ready to send your email address");
    }


    public boolean action(Event event,Object arg){
        if (event.target.equals(send)){
            if (p1!=null){
                Thread remove=p1;
                p1=null;
                remove.interrupt();
            }
            l2.setText("");
            str=t.getText().toLowerCase().trim();

            if (str.indexOf(" ")!=-1){
                l.setText("space not allowed in name");
                return true;
            }

            if (str.indexOf(",")!=-1){
                l.setText("commas not allowed in name");
                return true;
            }

            if (str.indexOf("@")!=-1){
                l.setText("must include @");
                l2.setText("");
                return true;
            }

            if (str.indexOf("@")==0){
                l.setText("name must precessed @");
                l2.setText("");
                return true;
            }

            String end=str.substring(str.indexOf('@'));
            if (end.indexOf('.')==-1){
                l.setText("Portion after '@' must");
                l2.setText("");
                return true;
            }

            byte[] sbuf=new byte[NameCollector.BUFFER_SIZE];
            str.getBytes(0,str.length(),sbuf,0);
            DatagramPacket toSend=new DatagramPacket(sbuf,100,hostAddress,NameCollector.COLLECTOR_PORT);

            try{
                s.send(toSend);
            }catch (Exception e){
                l.setText("couldn't send datagram");
                return true;
            }

            l.setText("send:"+str);
            send.setLabel("Re-send");
            p1=new Thread(this);
            p1.start();
            l2.setText("waiting for verification"+ ++count);

        }else {
            return super.action(event,arg);

        }
        return true;
    }
    @Override
    public void run() {
        try{
            s.receive(dp);
        }catch (Exception e){
            l2.setText("could't receive datagram");
            return;
        }
        l2.setText(new String(dp.getData(),0,0,dp.getLength()));

    }
}
