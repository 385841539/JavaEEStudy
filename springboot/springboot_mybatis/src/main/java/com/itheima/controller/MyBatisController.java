package com.itheima.controller;


import com.itheima.domain.User;
import com.itheima.service.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MyBatisController {

    @Autowired
    public UserMapper userMapper;



    @RequestMapping("/query")
    @ResponseBody
    public List<User> queryUserList(){

        List<User> users = userMapper.queryUserList();
        return  users;

    }
}
