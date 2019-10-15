package com.springboot.mycat.controller;


import com.springboot.mycat.dto.Test;
import com.springboot.mycat.service.TestService;
import com.springboot.mycat.util.Url;
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
