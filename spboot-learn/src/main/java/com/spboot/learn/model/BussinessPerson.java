package com.spboot.learn.model;

import com.spboot.learn.definition.Animal;
import com.spboot.learn.definition.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author feifei
 * @Classname BussinessPerson
 * @Description TODO
 * @Date 2019/7/31 10:21
 * @Created by ChenS
 */
@Component
public class BussinessPerson implements Person, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
//    @Autowired
//    @Qualifier("dog")

    private Animal animal=null;

//    public BussinessPerson(@Autowired @Qualifier("dog") Animal animal){
//        this.animal=animal;
//    }

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    @Autowired @Qualifier("dog")
    public void setAniamal(Animal aniamal) {
        System.out.println("延迟依赖注入");
        this.animal=aniamal;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用setbeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用setbeanFactory");
    }

    @Override

    public void destroy() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】DisposableBean方法");
    }

    @PreDestroy
    public void destory1(){
        System.out.println("【"+this.getClass().getSimpleName()+"】注解@PerDestory定义的自定义销毁方法");

    }
    @PostConstruct
    public void init(){
        System.out.println("【"+this.getClass().getSimpleName()+"】注解@PostConstruct定义的初始化方法 ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用afterProperties");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()
                +"】调用setApplicationContext");
    }
}
