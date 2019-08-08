package com.spboot.learn.model;

import com.spboot.learn.definition.Animal;

/**
 * @author feifei
 * @Classname Squirrel
 * @Description TODO
 * @Date 2019/8/8 13:42
 * @Created by ChenS
 */
public class Squirrel implements Animal {

    @Override
    public void use() {
        System.out.println("松鼠可以采集");
    }
}
