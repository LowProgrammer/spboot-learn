package com.spboot.learn.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author feifei
 * @Classname ScopeBean
 * @Description TODO
 * @Date 2019/8/8 11:43
 * @Created by ChenS
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ScopeBean {
}
