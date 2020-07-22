package com.itheima.springbootmybatis;

import com.itheima.SpringbootMybatisApplication;
import com.itheima.domain.User;
import com.itheima.responsitory.UserResponsity;
import com.itheima.service.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class MyBatisTest {


    public static void main(String[] args) {

    }

    @Autowired
    UserMapper userMapper;



    @Autowired
    private UserResponsity userResponsity;
    @Test
    public void testMyBatis(){

        List<User> users = userMapper.queryUserList();

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString()+"----------nihao---");
        }
    }

    @Test
    public void testJpa(){


        List<User> users = userResponsity.findAll();

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString()+"----------nihao  啊 ---");
        }


    }
}
