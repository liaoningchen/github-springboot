package com.springboot.myexception.exception;

/**
 * @author chendeyou 2019/11/1 16:12
 * @ClassName: com.springboot.myexception.exception
 * @describe
 */
public class MyException  extends Exception {

    public MyException(){}

    public MyException(String str){
        super(str);
    }

}
