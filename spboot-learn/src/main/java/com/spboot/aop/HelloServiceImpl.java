package com.spboot.aop;

/**
 * @author feifei
 * @Classname HelloServiceImpl
 * @Description TODO
 * @Date 2019/8/8 14:45
 * @Created by ChenS
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if(name==null || name==""){
            throw new RuntimeException("参数为空");
        }
        System.out.println("你好，"+name);
    }
}
