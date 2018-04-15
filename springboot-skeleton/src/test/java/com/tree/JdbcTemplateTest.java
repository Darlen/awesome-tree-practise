package com.tree;

import com.alibaba.fastjson.JSON;
import com.tree.jdbctemplate.IUserService;
import com.tree.jdbctemplate.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName com.tree
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * @Author tree
 * @Date 2018/4/16 00:08
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateTest {
    @Autowired
    private IUserService userService;

    @Test
    public void addUser(){
//        int num = userService.create("jdbc","123456");
//        System.err.println("增加用户="+num);
        System.err.println("增加用户之后再获取所有用户："+ JSON.toJSONString(userService.getAllUsers()));
    }
}
