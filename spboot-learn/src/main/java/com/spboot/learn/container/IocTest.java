package com.spboot.learn.container;

import com.spboot.learn.config.AppConfig;
import com.spboot.learn.config.DataBaseProperties;
import com.spboot.learn.model.Dog;
import com.spboot.learn.model.ScopeBean;
import com.spboot.learn.model.Squirrel;
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
        //自定义bean加载过程
//        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
//        ctx.close();
// ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
//        User user=ctx.getBean(User.class);
//        System.out.println(user.getId()+user.getUserName()+user.getNote());
//        logger.info(user.getId()+user.getUserName()+user.getNote());
//
//
//        Person person=ctx.getBean(BussinessPerson.class);
//        person.service();

        //设置数据库
        //DataBaseProperties properties=ctx.getBean(DataBaseProperties.class);
        //System.out.println(properties.getDriverClassName()+properties.getUrl()+properties.getUsername()+properties.getPassword());

        //测试作用域 原型 单例
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        ScopeBean scope1=ctx.getBean(ScopeBean.class);
        ScopeBean scope2=ctx.getBean(ScopeBean.class);
        System.out.println(scope1==scope2);

        //使用xml注解获取bean
        Squirrel squirrel=(Squirrel) ctx.getBean("squirrel");
        squirrel.use();

        Dog dog=ctx.getBean(Dog.class);
        System.out.println(dog.getInitTime());
    }
}
