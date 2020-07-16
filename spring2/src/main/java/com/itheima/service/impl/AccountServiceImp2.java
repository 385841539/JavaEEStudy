package com.itheima.service.impl;

import com.itheima.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImp2 implements IAccountService {


    private String  name;
    private Integer  age;
    private Date birthday;

    public AccountServiceImp2() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void  saveAccount(){


        System.out.println("----saveAccount----"+name+","+age+","+birthday);

    }




}
