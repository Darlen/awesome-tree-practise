package com.tree.dao;


import com.tree.model.User;

import java.util.List;

public interface UserMapper {
    User selectByPrimaryKey(long id);
    List<User> getAllUser();

    Integer updateById(User user) ;
    Integer addUser(User user) ;
}