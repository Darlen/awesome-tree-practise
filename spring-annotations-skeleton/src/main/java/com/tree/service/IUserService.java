package com.tree.service;

import com.tree.model.User;

import java.util.List;

/**
 * Description:
 *
 * @Author tree
 * @Date 2018/4/4 22:42
 * @Version 1.0
 */
public interface IUserService {
    User getUserById(long id);
    List<User> getAllUser();
    Integer updateById(User user) ;
    Integer addUser(User user) ;
    void delete(User demo);
}
