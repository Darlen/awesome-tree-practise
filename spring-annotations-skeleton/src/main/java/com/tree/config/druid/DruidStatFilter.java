package com.tree.config.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @ClassName com.tree.config.druid
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * @Author tree
 * @Date 2018/5/27 14:28
 * @Version 1.0
 */
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