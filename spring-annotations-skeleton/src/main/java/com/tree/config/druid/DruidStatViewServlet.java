package com.tree.config.druid;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @ClassName com.tree.config.druid
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * @Author tree
 * @Date 2018/5/27 14:39
 * @Version 1.0
 */
@SuppressWarnings("serial")
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