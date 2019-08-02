package com.spboot.learn.container;

import com.spboot.learn.config.AppConfig;
import com.spboot.learn.definition.Person;
import com.spboot.learn.model.BussinessPerson;
import com.spboot.learn.model.User;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author feifei
 * @Classname IocTest
 * @Description TODO
 * @Date 2019/7/29 15:17
 * @Created by ChenS
 */
public class IocTest {
    private static Logger logger=Logger.getLogger(IocTest.class);
    public static void main(String[] args){
        //
        ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        User user=ctx.getBean(User.class);
        System.out.println(user.getId()+user.getUserName()+user.getNote());
        logger.info(user.getId()+user.getUserName()+user.getNote());


        Person person=ctx.getBean(BussinessPerson.class);
        person.service();
    }
}
