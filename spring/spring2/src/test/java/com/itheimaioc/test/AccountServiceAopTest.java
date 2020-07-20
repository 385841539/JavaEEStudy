package com.itheimaioc.test;

import com.config.Config;
import com.itheimaioc.domain.Account;
import com.itheimaioc.proxy.MyBeanFactory;
import com.itheimaioc.service.IAccountService;
import com.itheimaioc.utils.TransactionManger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.IOP.TransactionService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class AccountServiceAopTest {



//    @Autowired
    private IAccountService as;

    @Autowired
    MyBeanFactory myBeanFactory;


    @Before
    public void  init(){

        as=myBeanFactory.getiAccountService();
    }

    @Test
    public void findAll(){
        List<Account> allAccount = as.findAllAccount();
        for (int i = 0; i < allAccount.size(); i++) {
            System.out.println(allAccount.get(i).toString());
        }
    }

    @Test
    public void testTransfer(){


        DataSourceTransactionManager dataSourceTransactionManager=null;

        as.transfer("aaa","bbb",200.0f);


    }






}
