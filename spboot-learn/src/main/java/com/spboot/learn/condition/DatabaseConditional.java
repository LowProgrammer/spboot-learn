package com.spboot.learn.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author feifei
 * @Classname DatabaseConditional
 * @Description TODO
 * @Date 2019/8/2 18:27
 * @Created by ChenS
 */
public class DatabaseConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {


        Environment environment=context.getEnvironment();

        return environment.containsProperty("spring.datasource.driver-class-name")&&environment.containsProperty("spring.datasource.url")
                &&environment.containsProperty("spring.datasource.username")
                &&environment.containsProperty("spring.datasource.password");
    }
}
