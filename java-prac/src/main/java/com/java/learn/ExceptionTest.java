package com.java.learn;

/**
 * @author feifei
 * @Classname ExceptionTest
 * @Description TODO
 * @Date 2019/8/15 16:11
 * @Created by ChenS
 */
public class ExceptionTest {
    public static void f()throws Exception{
        System.out.println("originating exception in f()");
        throw new Exception("throw f()");
    }
    public static void g()throws Throwable{
        try{
            f();

        }catch (Exception e){
            System.out.println("inside g(),e.printStackTrance");
            e.printStackTrace();
            //System.out.println("after g() printStackTrance（）");
            //throw  e;
            throw e.fillInStackTrace();
        }
    }
    public static void main(String[] args)throws Throwable {
        try{
            g();
        }catch (Exception e){
            System.out.println("Caught in main,e.printStackTrance()");
            e.printStackTrace();
        }
    }
}
