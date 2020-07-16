package com.itheimaioc.service;

import com.itheimaioc.domain.Account;

import java.util.List;

/**
 * 账户业务层的接口
 */
public interface IAccountService {


    List<Account> findAllAccount();


    Account findAccountById(Integer accountId);

    void saveAccount(Account account);
    void updateAccount(Account account);

    void deleteAccount(Integer accountId);


    void transfer(String sourceName,String  targetName,Float money);

}
