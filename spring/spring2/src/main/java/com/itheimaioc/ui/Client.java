package com.itheimaioc.ui;

import com.itheimaioc.dao.IAccountDao;
import com.itheimaioc.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {

        //获取Spring 的ioc 核心容器 ， 并根据id取 对象

        //获取核心容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        //根据id获取bean 对象
//        IAccountService as = (IAccountService) applicationContext.getBean("accountService");
        IAccountService as = (IAccountService) applicationContext.getBean("accountServiceImpl");
//        IAccountService as2 = (IAccountService) applicationContext.getBean("accountServiceImpl");
        IAccountDao accountDaoImpl = (IAccountDao) applicationContext.getBean("accountDaoImpl");
//        System.out.println(as==as2);
//        as.saveAccount();

//        accountDaoImpl.saveAcount();

        ((ClassPathXmlApplicationContext) applicationContext).close();


    }
}
