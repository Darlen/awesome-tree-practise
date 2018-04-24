package com.tree.controller;

import com.alibaba.fastjson.JSON;
import com.tree.jpa.model.User;
import com.tree.jpa.UserRepository;
import com.tree.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    public String hello() {
        logger.debug("Hello World Debug");
        logger.info("Hello World Info");

        return "hello world"+JSON.toJSONString(SpringContextHolder.getBeanNames());

    }

    @RequestMapping("/saveUser")
    public User saveUser() {
        User user = userRepository.save(new User("aaa", "aaa@163.com", "123456"));
        logger.info(JSON.toJSONString(user));
        return user;
    }

}
