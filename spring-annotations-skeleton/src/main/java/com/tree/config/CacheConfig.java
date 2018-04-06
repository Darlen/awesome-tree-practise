package com.tree.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @ClassName com.tree.config
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * @Author tree
 * @Date 2018/4/6 09:40
 * @Version 1.0
 */
@Configuration
@EnableCaching//<!-- 启用缓存注解 --> <cache:annotation-driven cache-manager="cacheManager" />
public class CacheConfig {
    private static final Logger logger = LoggerFactory.getLogger(CacheConfig.class);

    @Bean
    public EhCacheManagerFactoryBean cacheManagerFactory(){
        logger.info("entering cacheManagerFactory...");
        EhCacheManagerFactoryBean cacheManagerFactory = new EhCacheManagerFactoryBean() ;
        cacheManagerFactory.setConfigLocation(new ClassPathResource("cache/ehcache.xml"));
        return cacheManagerFactory;
    }

    @Bean
    public EhCacheCacheManager cacheManager(){
        logger.info("entering cacheManager...");
        return  new EhCacheCacheManager(cacheManagerFactory().getObject());
    }
}
