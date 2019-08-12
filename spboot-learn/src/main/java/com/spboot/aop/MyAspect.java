package com.spboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author feifei
 * @Classname MyAspect
 * @Description TODO
 * @Date 2019/8/9 14:46
 * @Created by ChenS
 */
@Aspect
public class MyAspect {


    @Pointcut("execution(* com.spboot.aop.UserServiceImpl.printUser(..))")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void before(){
        System.out.println("before......");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after .....");

    }

    //环绕通知
    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before ....");
        jp.proceed();
        System.out.println("around after ....");
    }




    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning .......");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing .....");
    }
}
