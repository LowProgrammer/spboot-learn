package com.spboot.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author feifei
 * @Classname ProxyBean
 * @Description TODO
 * @Date 2019/8/8 15:22
 * @Created by ChenS
 */
public class ProxyBean implements InvocationHandler {
    private Object target=null;
    private Interceptor interceptor=null;


    public static Object getProxyBean(Object target,Interceptor interceptor){
        ProxyBean proxyBean=new ProxyBean();

        proxyBean.target=target;

        proxyBean.interceptor=interceptor;

        Object proxy= Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),proxyBean);

        return proxy;
    };

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean exceptionFlag=false;
        Invocation invocation=new Invocation(target,method,args);
        Object object=null;
        try{
            if(this.interceptor.before()){
                object=this.interceptor.around(invocation);
            }else{
                object=method.invoke(target,args);
            }
        }catch (Exception e){
            exceptionFlag=true;
        }

        this.interceptor.after();
        if(exceptionFlag){
            this.interceptor.afterThrowinng();
        }else{
            this.interceptor.afterReturning();
            return object;
        }
        return null;
    }
}
