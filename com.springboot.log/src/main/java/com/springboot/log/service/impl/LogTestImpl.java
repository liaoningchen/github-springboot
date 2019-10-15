package com.springboot.log.service.impl;

import com.springboot.log.service.LogTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Service
public class LogTestImpl implements LogTest {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void test() {
        ExecutorService pool = Executors.newFixedThreadPool(50);
        Callable call = new Callable(){

            @Override
            public Object call() throws Exception {
                Thread t = Thread.currentThread();
                for(int i= 0;i<100;i++) {
                    try {
                        int j = 0/0;
                    }catch (Exception e){
                        logger.error("错误",e);
                    }
                    logger.info("------------------------info-"+t.getName()+"-------------");
                    logger.error("------------------------error-"+t.getName()+"-------------");
                }
                return null;
            }
        };
        for (int i =0;i < 500 ;i++) {
            pool.submit(call);
        }

        pool.shutdown();
    }
}
