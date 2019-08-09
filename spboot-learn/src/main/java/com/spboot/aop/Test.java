package com.spboot.aop;

/**
 * @author feifei
 * @Classname Test
 * @Description TODO
 * @Date 2019/8/9 9:47
 * @Created by ChenS
 */
public class Test {

    public static void main(String[] args) {
        testProxy();
    }
    private static void testProxy(){
        HelloService helloService=new HelloServiceImpl();

        HelloService proxy=(HelloService) ProxyBean.getProxyBean(helloService,new MyInterceptor());
        proxy.sayHello("zhangsan");


        System.out.println("##############   null  ##############");
        proxy.sayHello(null);
    }

}
