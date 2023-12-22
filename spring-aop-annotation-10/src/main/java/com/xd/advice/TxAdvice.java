package com.xd.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(10) //设置优先级，值越小优先级越高，优先级更高的，前置更先执行，后置更晚执行
@Aspect
@Component
public class TxAdvice {
    @Before("execution(* com..impl.*.*(..))")
    public void start() {
        System.out.println("TxAdvice start");
    }
    @AfterReturning("execution(* com..impl.*.*(..))")
    public void commit() {
        System.out.println("TxAdvice after returning commit");

    }
    @After("execution(* com..impl.*.*(..))")
    public void after() {
        System.out.println("TxAdvice after");

    }
    @AfterThrowing("execution(* com..impl.*.*(..))")
    public void rollback() {
        System.out.println("TxAdvice rollback");
    }
}
