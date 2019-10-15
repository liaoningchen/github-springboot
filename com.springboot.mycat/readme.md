# 搭建步骤
## 1、引入jar
```
<!-- 映入druid包-->
         <!--https://mvnrepository.com/artifact/com.alibaba/druid-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.8</version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.0.1</version>
            <scope>compile</scope>
        </dependency>
```
## 2、yml中需要加入以下配置
```
spring:
  datasource:
    username: root
    password: 123456
    driver-class-name: com.mysql.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource
    # 加上 serverTimezone=GMT 是因为 mysql默认是美国时区，而我们大陆时间要比他们晚8个小时，
    # 解决办法：1把mysql驱动包版本调低（springboot2.0默认mysql驱动包是8.0.17），2、在url连接中拼上serverTimezone=GMT
    url: jdbc:mysql://127.0.0.1:3306/mycat1?serverTimezone=GMT
    #springboot1.x时候不需要配置此项，只需把建表语句(schema.sql或者schema-adll.sql)放在类路径下即可
    #springboot2.x需要配置此项
    #spring.datasource.initialization-mode  初始化模式（springboot2.0），其中有三个值，always为始终执行初始化，embedded只初始化内存数据库（默认值）,如h2等，never为不执行初始化。
    initialization-mode: always
    # 指定建表语句位置
    #schema:
     # - classpath:sql/schema-create.sql
    #data:
      #- classpath:sql/date.sql

    #   数据源其他配置
    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT 1 FROM DUAL
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true
    #   配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
    # 属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有：
    #监控统计用的filter:stat  日志用的filter:log4j 防御sql注入的filter:wall
    filters: stat,wall,slf4j


    maxPoolPreparedStatementPerConnectionSize: 20
    # 合并多个DruidDataSource的监控数据
    useGlobalDataSourceStat: true
    # 通过connectProperties属性来打开mergeSql功能；慢SQL记录
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
  mvc:
    favicon:
      enabled: false

server:
  port: 8888
mybatis:
  config-location: classpath:mybatis/mybatis-config.xml
  mapper-locations: classpath:mybatis/mapper/*.xml
  # pojo类所在包路径
  type-aliases-package: com.springboot.mycat.dto

```
## 3、為主启动类加入以下注解
```
/*此处加注解，就不需要在每个dao中加@Mapper注解了*/
   /*@MapperScan(value = "com.cdy.mybatis.dao")*/ /*和下边的等价*/
   @MapperScan({"com.springboot.mycat.dao"})
 ```