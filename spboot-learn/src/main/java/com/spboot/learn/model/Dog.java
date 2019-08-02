package com.spboot.learn.model;

import com.spboot.learn.definition.Animal;
import org.springframework.stereotype.Component;

/**
 * @author feifei
 * @Classname Dog
 * @Description TODO
 * @Date 2019/7/31 10:23
 * @Created by ChenS
 */
@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("狗："+Dog.class.getSimpleName());
    }
}
