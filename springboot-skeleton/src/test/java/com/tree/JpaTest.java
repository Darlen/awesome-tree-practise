package com.tree;

import com.tree.model.User;
import com.tree.model.UserRepository;
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
    public void getUser(){
        userRepository.save(new User("aaa","aaa@163.com","123456"));
    }
}
