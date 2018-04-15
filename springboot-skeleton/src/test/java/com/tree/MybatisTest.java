package com.tree;

import com.alibaba.fastjson.JSON;
import com.tree.mybatis.User;
import com.tree.mybatis.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName com.tree
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * @Author tree
 * @Date 2018/4/15 23:03
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    @Resource
    private UserMapper userMapper;


    @Test
    public void getUserList(){
        System.err.println("获取用户列表："+ JSON.toJSONString(userMapper.getUserList()));
    }

    @Test
    public void getUser(){
        System.err.println("获取第一个用户："+ JSON.toJSONString(userMapper.getUser("1")));
    }

    @Test
    public void addUser(){
        User user = new User("mybatis_aaa"+1,"aaa@163.com","123456");
        int num = userMapper.addUser(user);
        System.err.println("添加成功：num = "+num);
        System.err.println("获取用户："+ JSON.toJSONString(userMapper.getUserList()));
    }
}
