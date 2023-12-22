package com.xd.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.lang.reflect.Modifier;

/**
 * 获取目标方法信息
 *      所有增强方法中都可以获取的信息：方法名、参数、访问修饰符、所属的类的信息。。。
 *          JoinPoint joinPoint中包含目标方法的信息
 *      返回的结果 @AfterReturning
 *          形参中增加result
 *          注解中增加returning
 *      异常的信息 @AfterThrowing
 *
 *
 */
@Aspect
public class MyAdvice {
    /**
     * 切点表达式的提取和复用
     *      1、当前类中提取
     *          定义一个public void的空方法，增加@Pointcut注解
     *          增强方法中引用切点表达式的方法即可
     *      2、创建一个存储切点的类，单独维护切点表达式
     *          引用其他类的切点方法，类的全限定符.方法名()
     */
    @Pointcut("execution(* com..impl.*.*(..))")
    public void pc() {}
    //@Before("execution(* com..impl.*.*(..))")
    //@Before("pc()")
    @Before("com.xd.pointcut.MyPointCut.pc()")
    public void start(JoinPoint joinPoint) {
        //方法名、参数、访问修饰符、所属的类的信息
        //所属的类的信息
        joinPoint.getTarget().getClass().getSimpleName();
        // method name
        joinPoint.getSignature().getName();
        // 方法的访问修饰符
        int modifiers = joinPoint.getSignature().getModifiers();
        String s = Modifier.toString(modifiers);
        // parameters
        Object[] objects = joinPoint.getArgs();
    }
    @AfterReturning(value = "execution(* com..impl.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

    }
    @After("execution(* com..impl.*.*(..))")
    public void after(JoinPoint joinPoint) {

    }
    @AfterThrowing(value = "execution(* com..impl.*.*(..))", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {

    }
}
