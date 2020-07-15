package com.itheima.test;


import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {

    private static InputStream resourceAsStream;
    private static SqlSessionFactoryBuilder builder;
    private static SqlSessionFactory factory;
    private static SqlSession session;
    private static IUserDao userDao;

    public static void main(String[] args) throws IOException {

//        testSave();
//        testUpdate();

//        testDelete();
//        testSelect();
//        testFind();
//        testFindByName();
//        findTotal();
//        distory();
    }


    @Test
    public void  daoTest(){

        User user = session.selectOne("com.itheima.dao.IUserDao.findUserById", 50);
        System.out.println(user.toString());
    }
    @Test
    public   void findTotal() {

        int total = userDao.findTotal();
        System.out.println(total);
    }


    @Test
    public   void testFindByName(){
        List<User> users = userDao.findUserName("%王%");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString());
        }

    }

    @Test
    public   void testFind(){
        User userById = userDao.findUserById(50);
        System.out.println(userById.toString());
    }

    @Test
    public   void testDelete(){
        userDao.deleteUser(48);
    }

    @Test
    public   void testUpdate(){

        User user = new User();
        user.setUsername("我擦了");
        user.setId(50);
        user.setAddress("倡议的");
        user.setBirthday(new Date());
        user.setSex("1");
        userDao.updateUser(user);

    }
    @Test
    public  void testSave() throws IOException {


        User user = new User();
        user.setUsername("我尼来来阿里玛");
        user.setAddress("倡议");
        user.setBirthday(new Date());
        user.setSex("1");

        userDao.saveUser(user);

    }

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
        userDao = session.getMapper(IUserDao.class);
    }

    @Test
    public   void testSelect() throws IOException {

        //5.使用代理对象执行方法

        List<User> users = userDao.findAll();


        for (int i = 0; i < users.size(); i++) {

            User user = users.get(i);
            System.out.println(user.toString());
        }

    }




    @Test
    public   void findUserByCondition() throws IOException {

        User user=new User();
        user.setUsername("小二王");
        user.setSex("男");
        //5.使用代理对象执行方法
        List<User> users = userDao.findUserByCondition(user);
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString());
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
