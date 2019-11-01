package com.springboot.myexception.service.impl;

import com.springboot.myexception.annotation.CommonLog;
import com.springboot.myexception.exception.MyException;
import com.springboot.myexception.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author chendeyou 2019/11/1 16:16
 * @ClassName: com.springboot.myexception.service.impl
 * @describe
 */
@Service
public class TestServiceImpl  implements TestService {

    @CommonLog
    public String test() throws Exception{
        if(1+1==2){
            throw new MyException("自定义异常啊!");
        }

        return "success";
    }
}
