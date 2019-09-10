package com.java.net.tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author feifei
 * @Classname WhoAmI
 * @Description TODO
 * @Date 2019/9/5 15:55
 * @Created by 陈群飞
 */
public class WhoAmI {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress a=InetAddress.getByName("LAPTOP-JH4ANA4G");
        System.out.println(a);

        InetAddress addr=InetAddress.getByName(null);
        System.out.println(addr);
    }
}
