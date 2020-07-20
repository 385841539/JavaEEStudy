package com.config;


import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan({"com.itheimaioc","com.itheimaaop"})
@Import({JdbcConfig.class,JdbcConfig.class})
@PropertySource("classpath:jdbcConfig.properties")
@EnableTransactionManagement
public class Config {
//
//
//    @Bean
//    @Scope("prototype")
//    public QueryRunner createQueryRunner(DataSource dataSource) {
//
//        return new QueryRunner(dataSource);
//    }
//
//
//    @Bean
//    public DataSource createDataSource() throws PropertyVetoException {
//
//
//        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//
//        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
//        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/eesy");
//        comboPooledDataSource.setUser("root");
//        comboPooledDataSource.setPassword("111111");
//        return  comboPooledDataSource;
//
//    }
}
