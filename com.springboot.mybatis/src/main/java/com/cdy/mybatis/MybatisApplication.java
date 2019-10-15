package com.cdy.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*此处加注解，就不需要在每个dao中加@Mapper注解了*/
/*@MapperScan(value = "com.cdy.mybatis.dao")*/ /*和下边的等价*/
@MapperScan({"com.cdy.mybatis.dao"})
@SpringBootApplication
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

}
