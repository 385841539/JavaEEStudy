package com.itheimaioc.dao;

import com.itheimaioc.domain.Account;

import java.util.List;

public interface IAccountDao {


    List<Account> findAllAccount();


    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void deleteAccount(Integer accountId);
    void updateAccount(Account account);
    Account findAccountByName(String accountName);


}
