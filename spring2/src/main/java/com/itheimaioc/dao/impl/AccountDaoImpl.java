package com.itheimaioc.dao.impl;

import com.itheimaioc.dao.IAccountDao;
import com.itheimaioc.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


/**
 * 账户的持久层实现类
 */
@Repository
public class AccountDaoImpl implements IAccountDao {


    @Autowired
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throw new RuntimeException();
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("select * from account where id =?", new BeanHandler<Account>(Account.class), accountId);
        } catch (Exception throwables) {
            throw new RuntimeException();
        }
    }


    public void saveAccount(Account account) {

        try {
            runner.update("insert into account(name , money) values(?,?)", account.getName(), account.getMoney());
        } catch (Exception throwables) {
            throw new RuntimeException();
        }


    }

    public void deleteAccount(Integer accountId) {


        try {
            runner.update("delete from  where id=?", accountId);
        } catch (Exception throwables) {
            throw new RuntimeException();
        }

    }

    public void updateAccount(Account account) {


        try {
            runner.update("update account set name=?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
        } catch (Exception throwables) {
            throw new RuntimeException();
        }

    }

    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = runner.query("select * from account where name =?", new BeanListHandler<Account>(Account.class), accountName);


            if (accounts == null || accounts.size() == 0) {
                return null;
            } else if (accounts.size() > 1) {
                throw new RuntimeException("数据不唯一");
            }

            return accounts.get(0);
        } catch (Exception throwables) {
            throw new RuntimeException();
        }


    }
}
