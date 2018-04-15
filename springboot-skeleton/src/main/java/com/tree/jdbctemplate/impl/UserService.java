package com.tree.jdbctemplate.impl;

import com.tree.jdbctemplate.IUserService;
import com.tree.jdbctemplate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName com.tree.jdbctemplate.impl
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * @Author tree
 * @Date 2018/4/15 23:58
 * @Version 1.0
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(String name, String pwd) {
        return jdbcTemplate.update("insert into user(nickname,email,pswd) values(?,?,?)",name,"aaa.163.com",pwd);
    }

    @Override
    public Integer deleteById(String id) {
        return jdbcTemplate.update("delete from user where id = ?", id);

    }

    @Override
    public List getAllUsers() {
        return  jdbcTemplate.queryForList("select * from user");
    }

    @Override
    public void deleteAllUsers() {

    }
}
