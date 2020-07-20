package com.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("com.itheimaioc")
public class JdbcConfig {



    @Value("${jdbc.jdbcUrl}")
    private String url;

    @Value("${jdbc.name}")
    private String name;


    @Value("${jdbc.driver}")
    private String driver;


    @Value("${jdbc.password}")
    private String password;

    @Bean
//    @Scope("${prototype}")
    public QueryRunner createQueryRunner( DataSource dataSource) {

        return new QueryRunner(dataSource);
    }


    @Bean
    public DataSource createDataSource() throws PropertyVetoException {


        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

//        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
//        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/eesy");
//        comboPooledDataSource.setUser("root");
//        comboPooledDataSource.setPassword("111111");
//
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(name);
        comboPooledDataSource.setPassword(password);
        return  comboPooledDataSource;

    }


//    @Bean
//    public DataSource createDataSource2() throws PropertyVetoException {
//
//
//        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//
////        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
////        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/eesy");
////        comboPooledDataSource.setUser("root");
////        comboPooledDataSource.setPassword("111111");
////
//        comboPooledDataSource.setDriverClass(driver);
//        comboPooledDataSource.setJdbcUrl("jdbc.jdbcUrl=jdbc:mysql://localhost:3306/eesy02");
//        comboPooledDataSource.setUser(name);
//        comboPooledDataSource.setPassword(password);
//        return  comboPooledDataSource;
//
//    }
}
