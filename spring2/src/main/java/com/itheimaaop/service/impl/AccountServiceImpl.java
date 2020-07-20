package com.itheimaaop.service.impl;

import com.itheimaaop.service.IAccountService;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl  implements IAccountService {

    public void saveAccount() {

        System.out.println("AccountServiceImpl--saveAccount");

//        int  ii=1/0;


    }

    public void updateAccount(int i) {

        System.out.println("AccountServiceImpl--updateAccount");


    }

    public int deleteAccount() {

        System.out.println("AccountServiceImpl--deleteAccount");

        return 0;
    }
}
