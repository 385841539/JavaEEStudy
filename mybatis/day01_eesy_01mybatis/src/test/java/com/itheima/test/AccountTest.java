package com.itheima.test;


import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;
import com.itheima.dao.IAccountDao;
import com.itheima.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {

    private static InputStream resourceAsStream;
    private static SqlSessionFactoryBuilder builder;
    private static SqlSessionFactory factory;
    private static SqlSession session;
    private static IAccountDao accountDao;
    private IUserDao userDao;


    @Before
     public  void init()  {
         System.out.println("0000000init0000000");
        //1. 读取配置文件SqlMapConfig.xml
         try {
             resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
         } catch (IOException e) {
             e.printStackTrace();
         }

         //2.创建SqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();

        factory = builder.build(resourceAsStream);

        //3.使用工厂生产SqlSession对象
        session = factory.openSession();

        //4.使用SqlSession创建Dap接口的代理对象
        accountDao = session.getMapper(IAccountDao.class);
        userDao = session.getMapper(IUserDao.class);
    }

    @Test
    public   void testSelect() throws IOException {

        //5.使用代理对象执行方法

        List<Account> users = accountDao.findAll();


        for (int i = 0; i < users.size(); i++) {

            Account user = users.get(i);
            System.out.println(user.toString());
        }

    }




    @Test
    public   void findAllAccount() {

        //5.使用代理对象执行方法

        List<AccountUser> users = accountDao.findAllAccount();


        for (int i = 0; i < users.size(); i++) {

            AccountUser user = users.get(i);
            System.out.println(user.toString());
        }

    }





    @After
    public   void  destory(){
        //提交事务
        session.commit();
        session.close();
        try {
            resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
