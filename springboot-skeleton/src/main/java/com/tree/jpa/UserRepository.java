package com.tree.jpa;

import com.tree.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @ClassName com.tree
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * @Author tree
 * @Date 2018/4/9 23:24
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<User,Long>{
    @Query("from User u where u.nickname=:nickname")
    User findUser(@Param("nickname") String nickname);
}
