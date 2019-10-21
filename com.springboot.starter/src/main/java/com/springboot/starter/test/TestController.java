package com.springboot.starter.test;

import com.springboot.configure.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chendeyou 2019/10/21 18:18
 * @ClassName: com.springboot.starter.test
 * @describe
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService ;

    @GetMapping("/hello")
    public String test(){
        String hello = testService.test("hello");
        return  hello;
    }
}
