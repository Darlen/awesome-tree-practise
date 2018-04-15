package com.tree.jdbctemplate;

import java.util.List;

/**
 * @ClassName com.tree.jdbctemplate
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * @Author tree
 * @Date 2018/4/15 23:58
 * @Version 1.0
 */
public interface IUserService {
    /**
     * 新增一个用户
     * @param name
     * @param pwd
     */
    Integer create(String name, String pwd);

    /**
     * 根据name删除一个用户高
     * @param name
     */
    Integer deleteById(String name);

    /**
     * 获取用户总量
     */
    List<User> getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();
}
