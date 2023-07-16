package com.codewithraushan.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    //setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //setup pointcut declarations
    @Pointcut("execution(* com.codewithraushan.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    //do the same for service and dao
    @Pointcut("execution(* com.codewithraushan.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.codewithraushan.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    //add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){

        //display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>>> in @Before : calling method: " + theMethod);

        //display the argument to the method

        //get the argument
        Object[] args = theJoinPoint.getArgs();

        //loop through and display the args
        for (Object tempArg : args){
            myLogger.info("=====>> arguments : " + tempArg);
        }
    }
}








