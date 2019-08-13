package com.spboot.aop;

import com.spboot.learn.model.User;
import org.aspectj.lang.JoinPoint;
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

    @DeclareParents(value = "com.spboot.aop.UserValidateImpl",defaultImpl = UserValidateImpl.class)
    public UserValidator userValidator;

    @Pointcut("execution(* com.spboot.aop.UserServiceImpl.printUser(..))")
    public void pointCut(){

    }

    @Before("pointCut() && args(user)")
    public void beforeParam(JoinPoint point, User user){
        Object[] args=point.getArgs();
        System.out.println("before .....");
    }
    @Before("pointCut()")
    public void before(){
        System.out.println("before......");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after .....");

    }

//    //环绕通知
//    @Around("pointCut()")
//    public void around(ProceedingJoinPoint jp) throws Throwable {
//        System.out.println("around before ....");
//        jp.proceed();
//        System.out.println("around after ....");
//    }




    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturning .......");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing .....");
    }
}
