package com.spboot.aopdemo;

import java.lang.reflect.InvocationTargetException;

/**
 * @author feifei
 * @Classname MyInterceptor
 * @Description TODO
 * @Date 2019/8/8 15:13
 * @Created by ChenS
 */
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("my before.......");
        return true;
    }

    @Override
    public void after() {
        System.out.println("my after ......");
    }

    @Override
    public Object around(com.spboot.aopdemo.Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before .....");
        Object obj=invocation.proceed();
        System.out.println("around after ......");
        return obj;
    }



    @Override
    public void afterReturning() {
        System.out.println("afterReturning ......");
    }

    @Override
    public void afterThrowinng() {
        System.out.println("afterThrowing .......");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
