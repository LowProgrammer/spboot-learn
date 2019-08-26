package com.java.learn.clone;

/**
 * @author feifei
 * @Classname Snake
 * @Description TODO
 * @Date 2019/8/26 15:59
 * @Created by 陈群飞
 */
public class Snake implements Cloneable {
    private Snake next;
    private char c;
    Snake(int i,char x){
        c=x;
        if(--i>0){
            next=new Snake(i,(char) (x+1));
        }
    }

    void increment(){
        c++;
        if (next!=null){
            next.increment();
        }
    }

    @Override
    public String toString() {
        String s=" : "+c;
        if (next!=null){
            s+=next.toString();
        }
        return s;
    }

    @Override
    protected Object clone() {
        Object o=null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    public static void main(String[] args) {
        Snake s=new Snake(5,'a');
        System.out.println("s=="+s);

        Snake s2=(Snake) s.clone();
        System.out.println("s2=="+s2);
        s.increment();
        System.out.println("after s.increment ,s2="+s2);
        System.out.println("after s.increment ,s="+s);
    }
}
