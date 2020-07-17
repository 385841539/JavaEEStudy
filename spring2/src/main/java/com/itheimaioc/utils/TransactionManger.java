package com.itheimaioc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;


@Component
public class TransactionManger {



    @Autowired
    private ConnectionUtils connectionUtils;

    public  void beginTransaction(){

        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public  void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public  void rollback(){

        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public  void release(){

        try {
            //还回连接池中
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
