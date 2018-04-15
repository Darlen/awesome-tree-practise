package com.tree;

import com.alibaba.fastjson.JSON;
import com.tree.jpa.UserRepository;
import com.tree.jpa.model.User;
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
 * @Date 2018/4/9 23:27
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUser(){
        userRepository.save(new User("aaa","aaa@163.com","123456"));
    }

    @Test
    public void getUser(){
        System.err.println("find User result: "+JSON.toJSON(userRepository.findUser("aaa")));
    }
}
