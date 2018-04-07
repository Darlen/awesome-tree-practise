package com.tree.config;

import com.tree.core.MyInitializingInterceptor;
import com.tree.core.MyPropertyEditorRegister;
import com.tree.core.MySimpleMappingExceptionResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
* Package: com.tree.config
* Description: <类功能描述>. <br>
* <p>
*	<使用说明>
* </p>
* @Author tree
* @Date  2018/4/5 22:08
* @Version 1.0
*/
@Configuration
@EnableWebMvc
@PropertySource(value =  {"classpath:app.properties"})
@ComponentScan(basePackages = "com.tree", useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value ={Controller.class})})
public class WebConfig extends WebMvcConfigurerAdapter {

    private static Logger logger = LoggerFactory.getLogger(WebConfig.class);

    /**
    * @Description: 注册ViewResolver
    * @Author: tree
    * @Date: 2018/4/5 23:20
    */
    @Bean
    public ViewResolver viewResolver(){
        logger.info("entering viewResolver...");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/jsp/function/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    @Bean
    public MessageSource messageSource(){
        logger.info("entering messageSource...");
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages.messages");
        return messageSource;
    }

    @Bean
    public HandlerAdapter servletHandlerAdapter(){
        logger.info("entering servletHandlerAdapter...");
        return new SimpleServletHandlerAdapter();
    }

    /**
     * @Description: 上传文件解析器
     * <p>
     *	<上传文件，bean必须为multipartResolver，否则form提交上来会出现异常>
     *	   form:enctype="multipart/form-data"
     *	   需要的jar：commons-io.jar , commons-fileupload.jar
     * </p>
     * @Param:
     * @return:
     * @Author: tree
     * @Date: 2018/4/7 12:18
     */
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        logger.info("entering multipartResolver...");
        CommonsMultipartResolver multipartResolver =  new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(5242880);
        return multipartResolver;
    }

    @Bean
    public MySimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        logger.info("entering simpleMappingExceptionResolver...");
        MySimpleMappingExceptionResolver simpleMappingExceptionResolver = new MySimpleMappingExceptionResolver();
        simpleMappingExceptionResolver.setDefaultErrorView("common_error");
        simpleMappingExceptionResolver.setExceptionAttribute("exception");
        Properties properties = new Properties();
        properties.setProperty("java.lang.RuntimeException","common_error");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }

    @Bean(name = "localeResolver")
    public CookieLocaleResolver cookieLocaleResolver(){
        logger.info("entering cookieLocaleResolver...");
        return new CookieLocaleResolver();

    }

    @Bean
    public MyInitializingInterceptor initInterceptor(){
        logger.info("entering initInterceptor...");
        return new MyInitializingInterceptor();

    }


    @Bean(name = "localeChangeInterceptor")
    public LocaleChangeInterceptor localeChangeInterceptor(){
        logger.info("entering localeChangeInterceptor...");
        return new LocaleChangeInterceptor();

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("entering addInterceptors...");
        registry.addInterceptor(initInterceptor());
        registry.addInterceptor(localeChangeInterceptor());
        logger.info("entered addInterceptors...");
    }

    @Bean
    public MyPropertyEditorRegister propertyEditorRegister(){
        logger.info("entering ConfigurableWebBindingInitializer...");
        MyPropertyEditorRegister register = new MyPropertyEditorRegister();
        register.setFormat("yyyy-MM-dd");
        return register;
    }



    @Bean
    public Jaxb2RootElementHttpMessageConverter jaxb2RootElementHttpMessageConverter(){
        logger.info("entering Jaxb2RootElementHttpMessageConverter...");
        return new Jaxb2RootElementHttpMessageConverter();
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        logger.info("entering MappingJackson2HttpMessageConverter...");
        return new MappingJackson2HttpMessageConverter();
    }

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        super.addFormatters(registry);
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        super.addCorsMappings(registry);
//    }
//
//    @Override
//    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
//        super.configureHandlerExceptionResolvers(exceptionResolvers);
//    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
        logger.info("entering localeChangeInterceptor...");
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        requestMappingHandlerAdapter.setWebBindingInitializer(propertyEditorRegister());
        List<HttpMessageConverter<?>> messageConverterList = new ArrayList<HttpMessageConverter<?>>();
        messageConverterList.add(jaxb2RootElementHttpMessageConverter());
        messageConverterList.add(mappingJackson2HttpMessageConverter());
        requestMappingHandlerAdapter.setMessageConverters(messageConverterList);
        return requestMappingHandlerAdapter;
    }


    /**
     * @Description:
     * 1. 可以在jsp中使用/static/**的方式访问/WEB-INF/static/下的内容
     * 2. 访问绝对路径的静态资源，适用于如存储图片的NAS：
     * http://localhost:8080/static/upload/2018040515.a.png  ==>  file:////opt/data/nas/2018040515.a.png
     * @Param:
     * @return:
     * @Author: tree
     * @Date: 2018/4/6 00:01
    */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("entering addResourceHandlers...");
        registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:////opt/data/nas/");
        super.addResourceHandlers(registry);
    }

}
