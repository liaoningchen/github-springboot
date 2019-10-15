package com.cdy.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {
    @Autowired
    private DataSource dataSource;
    @Test
    public void contextLoads() throws SQLException {
        //Springboot 2 以后，默认的数据库连接池连接是class com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());//class com.zaxxer.hikari.HikariDataSource
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }

}
