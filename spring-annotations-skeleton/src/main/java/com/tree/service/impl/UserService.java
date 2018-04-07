package com.tree.service.impl;

import com.tree.dao.UserMapper;
import com.tree.model.User;
import com.tree.service.IUserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description:
 *
 * @Author tree
 * @Date 2018/4/4 22:44
 * @Version 1.0
 */
@Service
//启用注解事务，默认策略是所有方法都必须在事务中运行，必须声明在实现类上，接口声明无效
@Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
public class UserService implements IUserService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value="commonCache",key="#id + 'UserService.getUserById'")
    public User getUserById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    public Integer updateById(User user) {
        return userMapper.updateById(user);
    }

    @CacheEvict(value="commonCache",key="#user.id + 'UserService.addUser'")
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }


    @CacheEvict(value="commonCache",allEntries=true)
    public void delete(User demo) {
        logger.info("delete");

    }
}
