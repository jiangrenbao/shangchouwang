package com.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * parkerJ
 * 2021/11/4
 * description：
 * function：
 */
@Aspect
@Component
public class AspectJ {

    @Pointcut(value = "execution(* *..test.*.*(..))")
    private void cut(){};

    @Before(value = "cut()")
    public void before( ){
        System.out.println("前置功能实现了");
    }

    @AfterReturning(value = "execution(* *..test.*.*.*(..))",returning = "object")
    public void afterReturn(Object object){
        System.out.println("后置功能实现");
    }

    @Around("cut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("前置功能");
        Object result = pjp.proceed(pjp.getArgs());
        System.out.println("后置通知");
        System.out.println( result.toString().toUpperCase());
        return result.toString().toUpperCase();
    }


}

