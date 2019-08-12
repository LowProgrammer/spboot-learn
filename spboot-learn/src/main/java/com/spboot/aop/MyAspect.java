package com.spboot.aop;

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

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning .......");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing .....");
    }
}
