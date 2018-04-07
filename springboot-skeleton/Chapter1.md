## Chapter1
### 要点
#### 1.  通过Spring initialer脚手架建立web，mybatis的结构， 并配置jdbc的配置与测试controller, 详细参考ApplicationWebTest与application.properties
```
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/shiro_demo
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```
#### 2. 日志设置
默认Spring boot是用的logback， 其配置文件为base.xml : spring-boot-2.0.1.RELEASE.jar!/org/springframework/boot/logging/logback/base.xml
```
# 开启日志
debug=true
#设置全局debug模式
#logging.level.root=DEBUG
#指定日志文件
logging.config=classpath:logback-spring.xml
```

- [Spring Boot日志管理]()http://blog.didispace.com/springbootlog/)
- 配置log4j
- 配置logback
  - [logback 自定义Pattern模板](https://blog.csdn.net/qq_25870705/article/details/73302376)
  - 详情参考logback-spring.xml文件
  - 配置appender异步到db

#### jdbc

#### swagger


### 参考.
 #### 1. [Spring Boot快速入门](http://blog.didispace.com/spring-boot-learning-1/)
 #### 2. [Spring Boot开发Web应用](http://blog.didispace.com/springbootweb/)
 #### 3. [Spring Boot工程结构推荐](http://blog.didispace.com/springbootproject/)