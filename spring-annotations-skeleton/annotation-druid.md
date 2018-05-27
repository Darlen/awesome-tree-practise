#基于Spring annotation的基本框架
#


## 引入druid监控，具体参考：
### servlet升级到3.1.0
### pom.xml:
```
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>${druid.version}</version>
</dependency>

```
### WebConfig:
```
 @Bean(name = "druid-stat-interceptor")
    public DruidStatInterceptor druidStatInterceptor(){
        logger.info("entering druid-stat-interceptor...");
        return new DruidStatInterceptor();
    }
    @Bean(name = "druid-type-proxyCreator")
    public BeanTypeAutoProxyCreator druidTypeProxyCreator(){
        logger.info("entering druid-type-proxyCreator...");
        BeanTypeAutoProxyCreator creator = new BeanTypeAutoProxyCreator();
        creator.setTargetBeanType(UserMapper.class);
        creator.setInterceptorNames("druid-stat-interceptor");
        return creator;
    }
```
### DatasourceConfig 引入druidDatasource 与 StatFilter
### 引入druid servlet（）与filter
#### DruidStatViewServlet
```
@WebServlet(urlPatterns="/druid/*",
    initParams={
            /** 白名单，如果不配置或value为空，则允许所有 */
            @WebInitParam(name="allow",value=""),
            /** 黑名单，与白名单存在相同IP时，优先于白名单 */
            @WebInitParam(name="deny",value=""),
            /** 用户名 */
            @WebInitParam(name="loginUsername",value="root"),
            /** 密码 */
            @WebInitParam(name="loginPassword",value="sunshine"),
            /** 禁用HTML页面上的“Reset All”功能   */
            @WebInitParam(name="resetEnable",value="false")
    })
public class DruidStatViewServlet extends StatViewServlet {

}
```

### DruidStatFilter
```
@WebFilter(
    filterName="druidWebStatFilter",urlPatterns="/*",
    initParams={
            /** 忽略资源 */
            @WebInitParam(name="exclusions", value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*,/static/*"),
            @WebInitParam(name="profileEnable",value="true"),
            /** 监控当前COOKIE的用户 */
            @WebInitParam(name="principalCookieName",value="USER_COOKIE"),
            /** 监控当前SESSION的用户 */
            @WebInitParam(name="principalSessionName",value="USER_SESSION"),
            /** 监控单个url访问数据库情况 */
            @WebInitParam(name = "profileEnable",value = "true")
    }
)
public class DruidStatFilter extends WebStatFilter {

}
```




## 参考
### 1. [druid 源码分析与学习（含详细监控设计思路的彩蛋）](http://herman-liu76.iteye.com/blog/2308563)
### 2. [保存Druid的监控记录](http://www.cnblogs.com/wanghuijie/p/druid_stat_log.html)


