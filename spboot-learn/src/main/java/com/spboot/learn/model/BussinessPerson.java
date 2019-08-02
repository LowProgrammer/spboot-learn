package com.spboot.learn.model;

import com.spboot.learn.definition.Animal;
import com.spboot.learn.definition.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * @author feifei
 * @Classname BussinessPerson
 * @Description TODO
 * @Date 2019/7/31 10:21
 * @Created by ChenS
 */
@Component
public class BussinessPerson implements Person {
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
}
