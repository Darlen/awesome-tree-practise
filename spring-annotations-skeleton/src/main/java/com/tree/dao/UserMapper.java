package com.tree.dao;


import com.tree.model.User;

import java.util.List;

/**
* Package: com.tree.dao
* Description: <类功能描述>. <br>
* <p>
*	<使用说明>
* </p>
* @Author tree
* @Date  2018/4/7 00:23
* @Version 1.0
*/
public interface UserMapper {
    User selectByPrimaryKey(long id);
    List<User> getAllUser();

    Integer updateById(User user) ;
    Integer addUser(User user) ;
}