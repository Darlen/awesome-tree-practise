package com.tree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * com.tree.controller
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 *
 * @Author tree
 * @Date 2018/4/5 18:41
 * @Version 1.0
 */
@Controller
public class HelloController {
    @Autowired
    private Environment env;
    @Value("${jdbc.url}")
    private String jurl;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        String path = env.getProperty("nas.path");
        String url = env.getProperty("jdbc.url");
        return "hello world";
    }

}
