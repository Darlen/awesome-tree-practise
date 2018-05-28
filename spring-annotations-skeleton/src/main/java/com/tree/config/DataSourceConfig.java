package com.tree.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName com.tree.config
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * @Author tree
 * @Date 2018/4/6 09:41
 * @Version 1.0
 */
@Configuration
//启用注解事务管理，使用CGLib代理
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource({"classpath:db.properties"})
public class DataSourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Value("${jdbc.driver}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    @Autowired
    private Environment env;

    /**
     * 普通datasource
     * @return
     * @throws SQLException
     */
//    @Bean(name = "dataSource")
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(driverClass);
//        dataSource.setUrl(jdbcUrl);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }

    /**
     * 注册druid datasource
     * @return
     * @throws SQLException
     */
    @Bean(name = "dataSource",destroyMethod = "close")
    @PreDestroy
    public DataSource druidDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        //<!-- 配置初始化大小、最小、最大 -->
        dataSource.setInitialSize(1);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(20);
        //<!-- 配置获取连接等待超时的时间 -->
        dataSource.setMaxWait(60000);
        //<!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
        dataSource.setTimeBetweenEvictionRunsMillis(300000);

        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);

//      <!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
//        <!-- 配置监控统计拦截的filters:
//          具体的filter可参见：META-INF/druid-filter.properties-->
        dataSource.setFilters("stat,log4j,mergeStat");
//        List<Filter> proxyFilter = new ArrayList<Filter>();
//        proxyFilter.add(statFilter());
//        dataSource.setProxyFilters(proxyFilter);
        return dataSource;
    }

//    @Bean("stat-filter")
//    public StatFilter statFilter(){
//        StatFilter statFilter = new StatFilter();
//        statFilter.setSlowSqlMillis(1);
//        statFilter.setLogSlowSql(true);
//        return statFilter;
//    }



}
