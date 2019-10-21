package com.springboot.configure.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chendeyou 2019/10/21 18:05
 * @ClassName: com.springboot.configure.test
 * @describe
 */
@Configuration

@EnableConfigurationProperties(TestProperties.class)
public class TestAutoConfiguration {

    @Autowired
    TestProperties testProperties;

    @Bean
    public TestService testService(){
        TestService testService = new TestService();
        testService.setTestProperties(testProperties);
        return testService;
    }

}
