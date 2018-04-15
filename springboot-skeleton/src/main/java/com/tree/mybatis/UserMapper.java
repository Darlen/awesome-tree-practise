package com.tree.mybatis;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName com.tree.mybatis
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * @Author tree
 * @Date 2018/4/15 22:44
 * @Version 1.0
 */
@Mapper
public interface UserMapper {


    /**
     * <p>
     *	Results应对对象属性与数据库中的clumn不一致的情况(注意User中的pwd名字与数据库中不一样)
     *  ResultMap能解决多个方法都需要写results映射的问题
     *  selectProvider 应对复杂sql
     * </p>
     * @Param:
     * @return:
     * @Author: tree
     * @Date: 2018/4/15 23:30
     */
    @Results(id="getUserList", value = {
            @Result(property = "pwd", column = "pswd")
    })
    @Select("SELECT * FROM USER")
    List<User> getUserList();

    @Results(id="getUser", value = {
            @Result(property = "pwd", column = "pswd")
    })
    @Select("SELECT * FROM USER WHERE ID = #{id}")
    List<User> getUser(String id);



    @Results(id="addUser", value = {
            @Result(property = "pwd", column = "pswd")
    })
    @Insert("insert into user(email,nickname,pswd) values (#{email}, #{nickname},#{pwd})")
    int addUser(User user);

}
