package com.spboot.learn.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author feifei
 * @Classname BeanPostProcessorExample
 * @Description TODO
 * @Date 2019/8/2 17:04
 * @Created by ChenS
 */
@Component
public class BeanPostProcessorExample implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor调用postProcessBeforeInitialization方法，参数"+bean.getClass().getSimpleName()+","+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor调用 postProcessAfterInitialization 方法，参数"+bean.getClass().getSimpleName()+","+beanName);
        return bean;
    }
}
