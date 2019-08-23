package com.java.learn.RTTI;

/**
 * @author feifei
 * @Classname SweetShop
 * @Description TODO
 * @Date 2019/8/23 13:36
 * @Created by 陈群飞
 */
class Candy{
    static {
        System.out.println("Loading candy");
    }
}
class Gum{
    static {
        System.out.println("Loading Gum");
    }
}
class Cookie{
    static {
        System.out.println("Loading Cookie");
    }
}
public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");

        new Candy();
        System.out.println("after creating candy");
        try{
            Class.forName("Gum");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        System.out.println("after class for name GUM");
        new Cookie();
        System.out.println("after create cookie");
    }
}
