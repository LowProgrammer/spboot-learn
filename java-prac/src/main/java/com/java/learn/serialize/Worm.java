package com.java.learn.serialize;

import java.io.*;

/**
 * @author feifei
 * @Classname Worm
 * @Description TODO 序列化
 * @Date 2019/8/21 17:49
 * @Created by 陈群飞
 */
class Data implements Serializable{
    private int i;
    Data(int x){
        i=x;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
public class Worm implements Serializable {
    private static int r(){
        return (int)(Math.random()*10);
    }
    private Data[] d={new Data(r()),new Data(r()),new Data(r())};

    private Worm next;
    private char c;
    Worm(int i,char x){
        System.out.println("Worm constructor "+i);
        c=x;
        if(--i>0){
            next=new Worm(i,(char)(x+1));
        }
    }
    Worm(){
        System.out.println("default constructor");
    }

    @Override
    public String toString() {
        String s=":"+c+"(";
        for (int i = 0; i < d.length; i++) {
            s+=d[i].toString();
        }
        s+=")";
        if(next!=null){
            s+=next.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        Worm w=new Worm(6,'a');
        System.out.println("w="+w);
        try{
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("worm.out"));
            out.writeObject("Worm storage");
            out.writeObject(w);
            out.close();

            ObjectInputStream in=new ObjectInputStream(new FileInputStream("worm.out"));
            String s=(String) in.readObject();
            Worm w2=(Worm) in.readObject();

            System.out.println(s+",w2="+w2);
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            ByteArrayOutputStream bout=new ByteArrayOutputStream();
            ObjectOutputStream out=new ObjectOutputStream(bout);
            out.writeObject("worm storage");
            out.writeObject(w);
            out.flush();
            ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));

            String s=(String)in.readObject();
            Worm w3=(Worm)in.readObject();
            System.out.println(s+",w3="+w3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
