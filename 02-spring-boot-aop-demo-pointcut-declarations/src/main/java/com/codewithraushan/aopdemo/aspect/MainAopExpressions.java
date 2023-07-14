package com.codewithraushan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MainAopExpressions {
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
    public void getter(){}

    //create a pointcut for setter methods
    @Pointcut("execution (* com.codewithraushan.aopdemo.dao.*.set*(..))")
    public void setter(){}

    //create pointcut: include package... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}

}
