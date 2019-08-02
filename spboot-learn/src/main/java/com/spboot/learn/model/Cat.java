package com.spboot.learn.model;

import com.spboot.learn.definition.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author feifei
 * @Classname Cat
 * @Description TODO
 * @Date 2019/7/31 10:23
 * @Created by ChenS
 */
@Component
@Primary
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println("猫："+ Cat.class.getSimpleName());
    }
}
