package com.itheimaioc.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 链接工具类，用于从数据源获取一个链接，并且实现和线程绑定
 */


@Component
public class ConnectionUtils {

    private ThreadLocal<Connection> t1=new ThreadLocal<Connection>();


    @Autowired
    private DataSource dataSource;

    public void setT1(ThreadLocal<Connection> t1) {
        this.t1 = t1;
    }

    public Connection getThreadConnection(){


        Connection connection = t1.get();

        if (connection==null){

            try {
                connection=dataSource.getConnection();

                t1.set(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }


        return  connection;

    }


    public void removeConnection() {
        t1.remove();;
    }
}
