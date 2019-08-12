package com.spboot.aopdemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author feifei
 * @Classname Invocation
 * @Description TODO
 * @Date 2019/8/8 15:05
 * @Created by ChenS
 */
public class Invocation {
    private Object[] params;

    private Method method;

    private Object target;

    public Invocation(Object target,Method method,Object[] params){
        this.method=method;
        this.params=params;
        this.target=target;
    }

    public Object proceed()throws InvocationTargetException,IllegalAccessException {
        return method.invoke(target,params);
    }
}
