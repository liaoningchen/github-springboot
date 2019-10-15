package com.springboot.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        logger.trace("跟踪日志------------------");
        logger.debug("debugger级别日志------------------");
        logger.info("info级别日志------------------");
        logger.warn("警告级别日志--------------------");
        logger.error("错误级别日志-------------------");
    }

}
