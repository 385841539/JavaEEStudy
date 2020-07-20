package com.itheimaioc.test;

import com.config.Config;
import com.itheimaaop.service.IAccountService;
import com.itheimaaop.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class AccountAopTest {


//    @Autowired
//    static
//    IAccountService accountService;
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("BeanAop.xml");

        IAccountService accountService = (IAccountService)classPathXmlApplicationContext.getBean("accountServiceImpl");
        accountService.saveAccount();
//        accountService.deleteAccount();
//        accountService.updateAccount(3);
    }


}
