package com.tree.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * com.tree.config
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 *
 * @Author tree
 * @Date 2018/4/5 18:41
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.tree",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class})})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource(value =  {"classpath:db.properties","classpath:app.properties"})
@Import({CacheConfig.class,DataSourceConfig.class})
public class AppConfig {

}
