package com.itheima.service;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {

     List<User> queryUserList();
}