package com.codewithraushan.aopdemo.aspect;

import com.codewithraushan.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //add a new advice for @AfterReturning on the findAccount() methods
    @AfterReturning(
            pointcut =  "execution(* com.codewithraushan.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){

        //print out witch method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method : " + method);

        //print out the results of the method call
        System.out.println("\n=====>>> results is : " + result);
    }

    @Before("com.codewithraushan.aopdemo.aspect.MainAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method:  " + methodSignature);

        //display method arguments

        //get args
        Object[] args = theJoinPoint.getArgs();

        //loop thru args
        for (Object tempArg : args){

            System.out.println(tempArg);
            if (tempArg instanceof Account){

                //downcast and print Account specific stuff
                Account theAccount =(Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account lavel : "+ theAccount.getLevel());



            }
        }
    }

}
