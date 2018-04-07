package com.tree.config;

import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

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
@PropertySource(value =  {"classpath:app.properties"})
@ComponentScan(basePackages = "com.tree",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class})})
@EnableAspectJAutoProxy(proxyTargetClass = true)

@Import({CacheConfig.class,DataSourceConfig.class,DaoConfig.class})
public class AppConfig {


    /**
     *
     * 描述 : <负责解析资源文件>. <br>
     *     <这个类必须有，而且必须声明为static，否则不能正常解析>
     *
     * document from Spring :
     * <p>
         * Specialization of {@link PlaceholderConfigurerSupport} that resolves ${...} placeholders
         * within bean definition property values and {@code @Value} annotations against the current
         * Spring {@link Environment} and its set of {@link org.springframework.core.env.PropertySources}.
         *
         * <p>This class is designed as a general replacement for {@code PropertyPlaceholderConfigurer}
         * in Spring 3.1 applications. It is used by default to support the {@code property-placeholder}
         * element in working against the spring-context-3.1 XSD, whereas spring-context versions
         * &lt;= 3.0 default to {@code PropertyPlaceholderConfigurer} to ensure backward compatibility.
         * See the spring-context XSD documentation for complete details.
         *
         * <p>Any local properties (e.g. those added via {@link #setProperties}, {@link #setLocations}
         * et al.) are added as a {@code PropertySource}. Search precedence of local properties is
         * based on the value of the {@link #setLocalOverride localOverride} property, which is by
         * default {@code false} meaning that local properties are to be searched last, after all
         * environment property sources.
     * </p>
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
