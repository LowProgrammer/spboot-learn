package com.spboot.aopdemo;


import java.lang.reflect.InvocationTargetException;

/**
 * @Classname Interceptor
 * @Description TODO
 * @Date 2019/8/8 14:47
 * @Created by ChenS
 */
public interface Interceptor {
    //事前方法
    public boolean before();
    //时候方法
    public void after();

    /**
     *@description 取消原有事件方法
     *@param invocation --回调参数，通过调用proceed方法，调用事件
     *@returns 原有事件返回对象
     *@author feifei
     *@data 2019/8/8
     */
    public Object around(Invocation invocation)
            throws InvocationTargetException,IllegalAccessException;

    //事件返回方法。事件没有发生执行异常
    public void afterReturning();

    //事后异常方法，当事件发生异常时执行
    public void afterThrowinng();

    //是否使用around方法取代原有方法
    boolean useAround();
}
