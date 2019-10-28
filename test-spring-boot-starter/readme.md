### 自定义statter步骤
 #### 1、起名标准
 ```java
• 自定义命名空间
– 后缀：“-spring-boot-starter”
– 模式：模块-spring-boot-starter
– 举例：mybatis-spring-boot-starter

• 自定义命名空间
– 后缀：“-spring-boot-autoconfigure”
– 模式：模块-spring-boot-autoconfigure
– 举例：mybatis-spring-boot-autoconfigure
```

### 2、新建springboot工程，作为配置工程 test-spring-boot-autoconfigure
写完java代码后，需要在resource 先新建META-INF 目录，新建spring.factories文件
```java
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.springboot.configure.test.TestAutoConfiguration
```

### 3、新建maven工程，作为自定义startor入口
pom文件中引入 刚刚的配置工程
```java
<dependency>
    <groupId>com.springboot</groupId>
    <artifactId>test-spring-boot-autoconfigure</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```
### 4、测试
  新建springboot项目，引入自定义starter
  ```java
<dependency>
    <groupId>com.springboot</groupId>
    <artifactId>test-spring-boot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
在新项目中可以使用刚刚在配置工程配置的bean了