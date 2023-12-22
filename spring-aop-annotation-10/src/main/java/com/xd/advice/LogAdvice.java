package com.xd.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 1、注解配置指定插入的位置
 *      前置 @Before
 *      返回 @AfterReturning 正常返回
 *      异常 @AfterThrowing
 *      后置 @After           类似finally，最后
 *      环绕 @Around
 *      try{
 *          前置
 *          调用目标方法
 *          返回
 *      } catch(throwable t) {
 *          异常
 *      } finally {
 *          后置
 *      }
 * 2、配置切点表达式
 * 3、补全注解
 *      加入ioc容器
 *      配置切面
 * 4、开启Aspect支持
 */
@Order(20)
@Component
@Aspect
public class LogAdvice {
    @Before("execution(* com.xd.service.impl.*.*(..))")
    public void start() {
        System.out.println("LogAdvice开始");
    }
    @After("execution(* com.xd.service.impl.*.*(..))")
    public void after() {
        System.out.println("LogAdvice结束");
    }
    @AfterThrowing("execution(* com.xd.service.impl.*.*(..))")
    public void error() {
        System.out.println("LogAdvice报错");
    }
}
