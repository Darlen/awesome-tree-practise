## Chapter1
### 1.  通过Spring initialer脚手架建立web，mybatis的结构， 并配置jdbc的配置与测试controller, 详细参考ApplicationWebTest与application.properties
```
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/shiro_demo
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```
```
注意扫描包：
默认是扫描启动类（SpringbootSkeletonApplication）当前包和当前包路径下的所有子路径下的所有类--参考：@SpringBootTest
如果想扫描其他包，请使用@ComponetScan
```
### 2. 日志设置
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

##### 参考：
- [默认日志logback配置解析](http://tengj.top/2017/04/05/springboot7/)
- [Spring Boot日志管理]()http://blog.didispace.com/springbootlog/)

### 3. JDBC
#### 3.1. jdbc之jdbcTemplate
参考jdbctemplate包中的User与UserService类（extends JpaRepository），测试类参考JdbcTemplate
- 1. 创建Model对象 --> 参考jpa包下的User对象
- 2. 创建Service对象 --> 参考UserService
- 3. 注入JdbcTemplate
- 4. 测试类 --> JdbcTemplateTest


##### 参考
- [Spring Boot中使用JdbcTemplate访问数据库](http://blog.didispace.com/springbootdata1/)
- [Spring Boot干货系列：（八）数据存储篇-SQL关系型数据库之JdbcTemplate的使用](http://tengj.top/2017/04/13/springboot8/)



#### 3.2. jdbc之jpa
参考jpa包中的User与UserRepository类（extends JpaRepository），测试类参考JpaTest
- 1. 创建Model对象 --> 参考jpa包下的User对象
- 2. 创建Repository对象 --> 参考UserRepository
- 3. 测试类 --> JpaTest

##### 参考：
- [Spring Boot中使用Spring-data-jpa让数据访问更简单、更优雅](http://blog.didispace.com/springbootdata2/)


#### 3.3. jdbc之mybatis
（具体参考）
- 1. 创建Model对象 --> 参考：User对象
- 2. 创建Mapper对象，并使用@Mapper注解（
@Insert
@Update
@Delete
@Select） --> 参考UserMapper对象
其中@Mapper 映射器 相当于以下2种方式
```
a. <property name="mapperLocations" value="classpath*:mapper/*.xml" />
b. <!-- 使用相对于类路径的资源引用 -->
   <mappers>
     <mapper resource="org/mybatis/builder/AuthorMapper.xml"/>
     <mapper resource="org/mybatis/builder/BlogMapper.xml"/>
     <mapper resource="org/mybatis/builder/PostMapper.xml"/>
   </mappers>
```
```
a. Results用来处理字段名与属性名不一致问题：
应对对象属性与数据库中的clumn不一致的情况(注意User中的pwd名字与数据库中pswd字段名字不一样)
b. ResultMap能解决多个方法都需要写results映射的问题
c. selectProvider 应对复杂sql

```
- 3. 测试类 --> MybatisTest
- 4. [TODO] [Spring Boot干货系列：（十一）数据存储篇-Spring Boot整合Mybatis通用Mapper插件](http://tengj.top/2017/12/20/springboot11/)

##### 参考：
- [springboot mybatis视频](https://ke.qq.com/webcourse/index.html#course_id=230866&term_id=100272363&taid=1585452817810898&vid=o1422wn486v)
- [Spring Boot干货系列：（九）数据存储篇-SQL关系型数据库之MyBatis的使用](http://tengj.top/2017/04/23/springboot9/)
- [Mybatis的注解应用之关系映射](https://blog.csdn.net/owen_william/article/details/51815473)

-testtesttesttestt


#### swagger




### 使用aware接口注入applicationContext， 具体参考<a>SpringContextHolder</a>
具体实现原理：
```
AbstractAutowireCapableBeanFactory(initializeBean)
AbstractAutowireCapableBeanFactory(applyBeanPostProcessorsBeforeInitialization)
ApplicationContextAwareProcessor(postProcessBeforeInitialization)
ApplicationContextAwareProcessor(invokeAwareInterfaces)
SpringContextHolder(setApplicationContext)
```

### 参考.
 #### 1. [Spring Boot快速入门](http://blog.didispace.com/spring-boot-learning-1/)
 #### 2. [Spring Boot开发Web应用](http://blog.didispace.com/springbootweb/)
 #### 3. [Spring Boot工程结构推荐](http://blog.didispace.com/springbootproject/)



 ### 总参考
 - [Spring-Boot干货系列](http://tengj.top/categories/Spring-Boot干货系列/)
 - [Spring Boot基础教程](https://gitee.com/didispace/SpringBoot-Learning)
 - [Spring Boot 核心技术](https://gitee.com/tree3170/spring-boot-chapter)