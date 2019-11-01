package com.springboot.myexception.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author chendeyou 2019/11/1 16:30
 * @ClassName: com.springboot.myexception.aspect
 * @describe
 */
@Aspect
@Component
public class CommonLogAspect {

    @Pointcut("@annotation(com.springboot.myexception.annotation.CommonLog)")
    public void commonLogAspect() {
    }

    @Around("commonLogAspect()")
    public Object commonLogAspect(final ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = null;
        try {
            System.out.println("环绕通知-----------------before");
            proceed = joinPoint.proceed();
            System.out.println("环绕通知-----------------after");
        }catch (Exception e){
            System.out.println("AOP拦截到异常");
            System.out.println(e.getCause().toString());
            e.printStackTrace();

        }
        return proceed;
    }
}
