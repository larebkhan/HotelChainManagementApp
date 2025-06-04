package com.lareb.springProject.AirBnb.Aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspects {

    @Before("execution(* com.lareb.springProject.AirBnb.service.ShipmentServiceImpl.*(..))")
    public void beforeOrderPackage(JoinPoint joinPoint){
        log.info("Before orderPackage called from LoggingAspect , {}", joinPoint.getKind());
        log.info("Before orderPackage called from LoggingAspect , {}", joinPoint.getSignature());
    }
    @Before("within(com.lareb.springProject.AirBnb.service.*)")
    public void beforeServiceImplCalls(){
        log.info("Service Impl Calls");
    }

    @Around("allServiceMethodsPointcut()")
    public Object logExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Long startTime = System.currentTimeMillis();
        Object returnedValue = proceedingJoinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        Long diff = endTime - startTime;
        log.info("Time taken for {} is {} ", proceedingJoinPoint.getSignature(), diff);
        return returnedValue;
    }

    @Pointcut("execution(* com.lareb.springProject.AirBnb.service.ShipmentServiceImpl.*(..))")
    public void allServiceMethodsPointcut(){
    }

}
