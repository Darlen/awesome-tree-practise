package com.tree.controller;

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

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }

}
