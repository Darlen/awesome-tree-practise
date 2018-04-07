package com.tree.config;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * @ClassName com.tree.config
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * @Author tree
 * @Date 2018/4/6 12:56
 * @Version 1.0
 */
@Configuration
//启用注解事务管理，使用CGLib代理
@EnableTransactionManagement(proxyTargetClass = true)
@Import({DataSourceConfig.class})
public class DaoConfig {
    private static final Logger logger = Logger.getLogger(DaoConfig.class);

    /**
     * @Description: 配置SqlSessionFactory
     * <p>
     *     设置Mybatis配置文件与Mapper文件， 并设置datasource
     *	Note: 注意参数dataSource的注入-->Spring根据上下文自动发现datasource bean， 并注入
     * </p>
     * @Author: tree
     * @Date: 2018/4/7 10:55
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis/mybatis.xml"));
        // 配置mapper的扫描，找到所有的mapper.xml映射文件
        org.springframework.core.io.Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("mybatis/mapper/*.xml");
        sqlSessionFactory.setMapperLocations(resources);
        sqlSessionFactory.setDataSource(dataSource);
        return sqlSessionFactory;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.tree.**.dao");
        return mapperScannerConfigurer;
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


//    @Bean
//    public PageHelper pageHelper(){
//        logger.info("MyBatis分页插件PageHelper");
//        //分页插件
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("offsetAsPageNum", "true");
//        properties.setProperty("rowBoundsWithCount", "true");
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);
//        return pageHelper;
//    }






}
