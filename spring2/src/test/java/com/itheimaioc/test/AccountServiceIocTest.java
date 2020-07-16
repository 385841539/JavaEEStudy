package com.itheimaioc.test;

import com.config.Config;
import com.itheimaioc.domain.Account;
import com.itheimaioc.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class AccountServiceIocTest {


//    private AnnotationConfigApplicationContext applicationContext;

    @Autowired
    private IAccountService accountServiceImpl;

    public  void  init(){
//         applicationContext = new ClassPathXmlApplicationContext("beaninject.xml");
//         applicationContext = new AnnotationConfigApplicationContext(Config.class);


//         accountServiceImpl = applicationContext.getBean("accountServiceImpl", IAccountService.class);
    }
    @Test
    public void testFindAll(){


        List<Account> allAccount = accountServiceImpl.findAllAccount();

        for (int i = 0; i < allAccount.size(); i++) {
            System.out.println(allAccount.get(i).toString());
        }
    }



    @Test
    public void testFindOne() {

        Account accountById = accountServiceImpl.findAccountById(1);
        System.out.println(accountById.toString());


    }


    @Test
    public void testSave(){


        Account account = new Account();
//        account.se
        account.setMoney(1000876543002.0f);
        account.setName("你来了");
        accountServiceImpl.saveAccount(account);
    }

    @Test
    public void testUpdate(){

        Account accountById = accountServiceImpl.findAccountById(4);
        accountById.setName("我来也");
        accountById.setMoney(23456.0f);
        accountServiceImpl.updateAccount(accountById);
    }

    @Test
    public void testDelete(){}
}
