package com.gfg.jbdl52.config;

import com.gfg.jbdl52.domain.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class AppConfig {

    /***
     * Providing custom bean to IoC is via @Bean annotation
     * */

    Logger logger=LoggerFactory.getLogger(AppConfig.class);


    /*@Value("${mysql.uri}")
    private String uri;

    @Value("${mysql.username}")
    private String username;

    @Value("${mysql.password}")
    private String password;

    *//**
     * Driver manager is able to establish connection because of the mysql driver dependency we added in pom
     * *//*



    @Bean("mySqlConnection")
    @Primary
    public Connection getMySQLConnection(){
        try {
            Connection connection=DriverManager.getConnection(uri,username,password);
            return connection;
        } catch (SQLException e) {
            logger.error("error connecting to mysql");
        }
        return null;
    }

   *//**
    *To create bean of connection for multiple types
    * @Bean("postgresConnectBean")
    public Connection getpostgresonnection(){
        try {
            Connection connection=DriverManager.getConnection(uri,username,password);
            return connection;
        } catch (SQLException e) {
            logger.error("error connecting to mysql");
        }
        return null;
    }
*/


}
