package com.itheimaioc.service.impl;

import com.itheimaioc.dao.IAccountDao;
import com.itheimaioc.domain.Account;
import com.itheimaioc.proxy.MyBeanFactory;
import com.itheimaioc.service.IAccountService;
import com.itheimaioc.utils.TransactionManger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 账户的业务层实现类
 */

//<!--    <bean
// id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
// scope="prototype"  init-method="init" destroy-method="destory">
// </bean>-->
//用于创建对象
@Component
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {


    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }


    public void saveAccount(Account account) {
        accountDao.saveAccount(account);

    }

    public void updateAccount(Account account) {

        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {

        accountDao.deleteAccount(accountId);

    }

    public void transfer(String sourceName, String targetName, Float money) {

            Account sourceAccount = accountDao.findAccountByName(sourceName);
            Account targetAccount = accountDao.findAccountByName(targetName);

            sourceAccount.setMoney(sourceAccount.getMoney()-money);

            targetAccount.setMoney(targetAccount.getMoney()+money);


            accountDao.updateAccount(sourceAccount);


//            int i=1/0;
            accountDao.updateAccount(targetAccount);

            System.out.println("转账成功....");



    }
}
