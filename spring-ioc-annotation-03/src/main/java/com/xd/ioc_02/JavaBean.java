package com.xd.ioc_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)// 多例不会管理PreDestroy周期方法
public class JavaBean {
    @PostConstruct
    public void init() {
        System.out.println("init....");
    }
    @PreDestroy
    public void destory() {
        System.out.println("destory....");
    }
}
