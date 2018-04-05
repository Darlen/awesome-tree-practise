package com.tree.controller;

import com.tree.model.User;
import com.tree.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @Author tree
 * @Date 2018/4/4 21:29
 * @Version 1.0
 */
@RestController
@RequestMapping("/")
public class HelloController {
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }

}
