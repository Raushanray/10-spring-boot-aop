package com.codewithraushan.aopdemo.dao;

import com.codewithraushan.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);
    boolean doWork();
}
