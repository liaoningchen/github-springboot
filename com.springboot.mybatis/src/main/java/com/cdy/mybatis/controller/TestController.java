package com.cdy.mybatis.controller;

import com.cdy.mybatis.dto.Test;
import com.cdy.mybatis.service.TestService;
import com.cdy.mybatis.util.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TestService testService;


    @GetMapping(Url.TEST)
    private List<Map<String, Object>> test() {
        return  jdbcTemplate.queryForList("select * from test");
    }

    @GetMapping(Url.TEST_MAPPER)
    private Test test1() {
        return  testService.selectByPrimaryKey(4);
    }
}
