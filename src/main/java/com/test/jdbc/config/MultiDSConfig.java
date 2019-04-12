package com.test.jdbc.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MultiDSConfig {
    @Bean
    @Primary
    public DataSource masterDataSource(){
        /**
         * spring.datasource.driver-class-name=com.mysql.jdbc.Driver
         * spring.datasource.url=jdbc:mysql://localhost:3306/test
         * spring.datasource.data-username=root
         * spring.datasource.data-password=root
         */
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        DataSource ds = dataSourceBuilder.
                driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/test")
                .password("root")
                .username("root")
                .build();
        return ds;
    }

    @Bean
    public DataSource slaveDataSource(){
        /**
         * spring.datasource.driver-class-name=com.mysql.jdbc.Driver
         * spring.datasource.url=jdbc:mysql://localhost:3306/test
         * spring.datasource.data-username=root
         * spring.datasource.data-password=root
         */
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        DataSource ds = dataSourceBuilder.
                driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/test2")
                .password("root")
                .username("root")
                .build();
        return ds;
    }






}
