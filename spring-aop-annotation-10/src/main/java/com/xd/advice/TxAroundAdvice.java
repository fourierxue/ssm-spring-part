package com.xd.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxAroundAdvice {
    /**
     * 环绕通知需要在增强方法中，定义目标方法的执行
     * @param proceedingJoinPoint
     * @return 目标方法的返回值
     */
    @Around("com.xd.pointcut.MyPointCut.pc()")
    public Object tracsation(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("TxAroundAdvice start");
        // 保证目标方法执行
        Object[] args = proceedingJoinPoint.getArgs();
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed(args);
            System.out.println("TxAroundAdvice commit");
        } catch (Throwable throwable) {
            System.out.println("TxAroundAdvice 回滚");
            // 必须抛出异常否则，调用者捕捉不到
            throw new RuntimeException(throwable);
        } finally {

        }
        return proceed;
    }
}
