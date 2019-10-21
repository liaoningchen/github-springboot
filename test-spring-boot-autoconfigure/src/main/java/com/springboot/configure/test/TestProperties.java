package com.springboot.configure.test;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author chendeyou 2019/10/21 17:06
 * @ClassName: com.springboot.configure.test
 * @describe
 */

@ConfigurationProperties("com.cdy")
public class TestProperties {


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
