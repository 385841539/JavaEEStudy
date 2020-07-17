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
public class AccountServiceAopTest {



    @Autowired
    private IAccountService as;



    @Test
    public void findAll(){
        List<Account> allAccount = as.findAllAccount();
        for (int i = 0; i < allAccount.size(); i++) {
            System.out.println(allAccount.get(i).toString());
        }
    }

    @Test
    public void testTransfer(){

        as.transfer("aaa","bbb",200.0f);


    }






}
