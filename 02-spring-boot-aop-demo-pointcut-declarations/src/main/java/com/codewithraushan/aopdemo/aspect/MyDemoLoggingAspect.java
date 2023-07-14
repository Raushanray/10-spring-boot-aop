package com.codewithraushan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    /*
    here 1st * = return type
    then package name
    then 2nd * = class
    then 3rd = method
    and in (..) = any numbers of  parameters
     */

    @Pointcut("execution (* com.codewithraushan.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    //create a pointcut for getter methods
    @Pointcut("execution (* com.codewithraushan.aopdemo.dao.*.get*(..))")
    private void getter(){}

    //create a pointcut for setter methods
    @Pointcut("execution (* com.codewithraushan.aopdemo.dao.*.set*(..))")
    private void setter(){}

    //create pointcut: include package... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n=====>>> performint API Analytics");
    }
}
