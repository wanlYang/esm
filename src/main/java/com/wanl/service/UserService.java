package com.wanl.service;

import com.wanl.entity.Result;
import com.wanl.entity.User;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 * @ClassName: UserService
 * @Package:com.wanl.service
 * @author:YangBin
 * @date:2019/2/21 17:23
 * @version:V1.0
 */
public interface UserService {

    /**
     * 用户注册验证
     * @Author YangBin
     * @Date 17:26 2019/2/21
     * @Param [user, phoneCode, confirmPassword]
     * @param user 用户实体
     * @param phoneCode 手机号码
     * @param  confirmPassword 确认密码
     * @version v1.0
     * @return
     **/
    Result regist(User user, String phoneCode, String confirmPassword);

    /**
     * 登陆验证
     * @Author YangBin
     * @Date 9:46 2019/2/23
     * @Param [username, password]
     * @param password 密码
     * @param username 用户名
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    Result login(String username,String password);

}
