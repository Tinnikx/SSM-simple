package com.springmvc.demo.aop.basedonannotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Kaixiang Tao
 * @date 2019/7/31
 */
@Aspect
@Component
public class MyAspect {

    // define a pointcut
    @Pointcut("execution(* add(..))")
    public void pointCut() {
    }

    @Pointcut("execution(* annotationAop(..))")
    public void pointCutAfter() {
    }

    // define a adviser
    @Before("com.springmvc.demo.aop.basedonannotation.MyAspect.pointCut()")
    public void beforeMe(JoinPoint joinPoint) {
        Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
        System.out.println(joinPoint.getTarget() + "-------------Before------------");
    }

    @AfterReturning(value = "com.springmvc.demo.aop.basedonannotation.MyAspect.pointCutAfter()", returning = "value")
    public void AfterMe(JoinPoint joinPoint, Object value) {
        System.out.println(value);
    }

    @AfterThrowing(value = "com.springmvc.demo.aop.basedonannotation.MyAspect.pointCutAfter()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) throws Throwable {
//        MethodInvocationProceedingJoinPoint point = (MethodInvocationProceedingJoinPoint) joinPoint;
//        point.proceed();
        System.out.println(e.getMessage());
    }

    @Around("com.springmvc.demo.aop.basedonannotation.MyAspect.pointCutAfter()")
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-----------around before----------");
        Object proceed;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            if ("OutOfBounds".equals(throwable.getMessage())) {
                proceed = joinPoint.proceed();
            } else {
                throw throwable;
            }
        }
        System.out.println("-----------around after-----------");
        return proceed;
    }

    @Around("@within(com.springmvc.demo.annotation.Gateway)")
    public Object aroundGateway(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();
        System.out.println("around gateway" + proceed);
        return proceed;
    }

}
