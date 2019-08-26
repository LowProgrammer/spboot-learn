package com.java.learn.clone;

/**
 * @author feifei
 * @Classname MyObject
 * @Description TODO
 * @Date 2019/8/26 15:43
 * @Created by 陈群飞
 */
public class MyObject implements Cloneable {
    int i;
    MyObject(int ii){
        i=ii;
    }
    @Override
    public Object clone(){
        Object o=null;
        try {
            o=super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("MyObject can't clone");
        }
        return o;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
