package com.springboot.configure.test;

/**
 * @author chendeyou 2019/10/21 18:03
 * @ClassName: com.springboot.configure.test
 * @describe
 */
public class TestService {

    private  TestProperties testProperties;

    public TestProperties getTestProperties() {
        return testProperties;
    }

    public void setTestProperties(TestProperties testProperties) {
        this.testProperties = testProperties;
    }

    public String test(String name){
        return testProperties.getName() +"----"+ name;
    }
}
