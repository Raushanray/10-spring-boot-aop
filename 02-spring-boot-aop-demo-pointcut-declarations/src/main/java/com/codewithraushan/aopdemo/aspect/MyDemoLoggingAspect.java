package com.codewithraushan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//this is where we add all of our related advices for logging

//let's start with an @Before advice

    /*
    here 1st * = return type
    then package name
    then 2nd * = class
    then 3rd = method
    and in (..) = any numbers of  parameters
     */

    @Pointcut("execution (* com.codewithraushan.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){

        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
