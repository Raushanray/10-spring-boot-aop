package com.codewithraushan.aopdemo.dao;

import com.codewithraushan.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account theAccount) {

        System.out.println(getClass() + ": DOING MY DB WORK : ADDING AN ACCOUNT");
    }
}
