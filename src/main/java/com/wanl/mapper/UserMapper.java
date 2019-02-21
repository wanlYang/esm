package com.wanl.mapper;

import com.wanl.entity.User;

/**
 * @Title: UserMapper.java
 * @Package:com.wanl.mapper
 * @Description:(用户数据库mapper)
 * @author:YangBin
 * @date:2019年2月19日
 * @version:V1.0
 */
public interface UserMapper {

    /**
     * 添加用户注册
     * @Author YangBin
     * @Date 17:37 2019/2/21
     * @Param [user]
     * @param user 用户实体
     * @version v1.0
     * @return java.lang.Integer
     **/
    Integer create(User user);

    /**
     * 根据用户名查找用户
     * @Author YangBin
     * @Date 17:46 2019/2/21
     * @Param [username]
     * @param  username 用户名
     * @version v1.0
     * @return com.wanl.entity.User
     **/
    User findUserByUsername(String username);

    /**
     * 根据手机号获取用户
     * @Author YangBin
     * @Date 18:23 2019/2/21
     * @Param [phone]
     * @param phone 手机号
     * @version v1.0
     * @return com.wanl.entity.User
     **/
    User findUserByPhone(String phone);

    /**
     * 获取用户ID
     * @Author YangBin
     * @Date 18:48 2019/2/21
     * @Param [userId]
     * @param userId 用户ID
     * @version v1.0
     * @return com.wanl.entity.User
     **/
    User findUserById(String userId);
}
