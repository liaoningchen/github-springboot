package com.springboot.myexception.controller;

import com.springboot.myexception.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chendeyou 2019/11/1 16:15
 * @ClassName: com.springboot.myexception.controller
 * @describe
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/hello")
    public String test() throws Exception {
        return  testService.test();
    }
}
