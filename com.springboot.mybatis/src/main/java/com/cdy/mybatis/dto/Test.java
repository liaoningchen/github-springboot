package com.cdy.mybatis.dto;

import java.io.Serializable;


/**
 *  test
 * @author chendeyou 2019-08-12
 */
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * age
     */
    private Integer age;


    public Test() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}