package com.codewithraushan.aopdemo.dao;

import com.codewithraushan.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    //add new method findAccount()
    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

    void addAccount(Account theAccount, boolean vipFlag);
    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);



}
