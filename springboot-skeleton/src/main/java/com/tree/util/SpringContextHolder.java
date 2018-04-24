package com.tree.util;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName com.tree.util
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候取出ApplicaitonContext.
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * @Author tree
 * @Date 2018/4/22 11:16
 * @Version 1.0
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {
    private  static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        checkApplicationContext();
        return applicationContext;
    }

    /**
     * @Description: 从静态变量applicationContext中取得Bean.
     * <p>
     *	<使用说明>
     * </p>
     * @Param: beanName
     * @return: Object
     * @Author: tree
     * @Date: 2018/4/22 11:23
     */ 
    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }

    /**
     * @Description: 根据从静态变量applicationContext中取得Bean,
     * <p>
     *	<使用说明>
     * </p>
     * @Param: requireType
     * @return:
     * @Author: tree
     * @Date: 2018/4/22 11:25
     */
    public static <T> T getBean(Class<T> requireType){
        return applicationContext.getBean(requireType);
    }

    /**
     * @Description: 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型
     * <p>
     *	<使用说明>
     * </p>
     * @Param: beanName, requireType
     * @return:
     * @Author: tree
     * @Date: 2018/4/22 11:24
     */
    public static <T> T getBean(String beanName,Class<T> requireType){
        return applicationContext.getBean(beanName,requireType);
    }

    public static String[] getBeanNames(){
        return applicationContext.getBeanDefinitionNames();
    }

    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
        }
    }

    /**
     * 检查ApplicationContext不为空.
     */
    private static void assertContextInjected() {
        Validate.validState(applicationContext != null, "applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.");
    }






}
