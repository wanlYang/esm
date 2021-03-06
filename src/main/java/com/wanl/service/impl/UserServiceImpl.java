package com.wanl.service.impl;

import com.wanl.configuration.property.PropertiesConfig;
import com.wanl.constant.EsmConstant;
import com.wanl.entity.Account;
import com.wanl.entity.Result;
import com.wanl.entity.User;
import com.wanl.mapper.UserMapper;
import com.wanl.service.AccountService;
import com.wanl.service.UserService;
import com.wanl.utils.*;
import com.wanl.utils.redis.RedisCacheManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户服务实现类
 * @ClassName: UserServiceImpl
 * @Package:com.wanl.service.impl
 * @author:YangBin
 * @date:2019/2/21 17:24
 * @version:V1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountService accountService;

    @Autowired
    private RedisCacheManager redisCacheManager;

    /**
     * 用户注册验证
     *
     * @param user            用户实体
     * @param phoneCode       手机号码
     * @param confirmPassword 确认密码
     * @return java.lang.Integer
     * @Author YangBin
     * @Date 17:26 2019/2/21
     * @Param [user, phoneCode, confirmPassword]
     * @version v1.0
     **/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result regist(User user, String phoneCode, String confirmPassword) {
        boolean condition = (user != null && StringUtils.isNotBlank(phoneCode) && StringUtils.isNotBlank(confirmPassword)
        && StringUtils.isNotBlank(user.getUsername()) && StringUtils.isNotBlank(user.getPassword()) && StringUtils.isNotBlank(user.getPhone()));
        if (!condition){
            return new Result(-1011,"参数为空!",0,null);
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String cookie = CookieUtil.getCookie(request, EsmConstant.SMS_CODE, false);
        if (cookie == null){
            return new Result(-2001,"验证码无效!",0,null);
        }
        String code = (String)redisCacheManager.get(cookie);
        if (code == null){
            return new Result(-3001,"验证码无效!",0,null);
        }
        if (!phoneCode.equals(code)){
            return new Result(-4011,"验证码输入错误!",0,null);
        }
        if (!confirmPassword.equals(user.getPassword())){
            return new Result(-4056,"两次密码不一致!",0,null);
        }
        String tempPhone = (String)redisCacheManager.get(EsmConstant.TEMP_PHONE);
        if (tempPhone == null){
            return new Result(-5210,"请刷新重试!",0,null);
        }
        if (!tempPhone.equals(user.getPhone())){
            return new Result(-6031,"手机号异常!",0,null);
        }
        User userByUsername = userMapper.findUserByUsername(user.getUsername());
        if(userByUsername != null){
            return new Result(-7652,"用户名已被使用!",0,null);
        }
        User userByPhone = userMapper.findUserByPhone(user.getPhone());
        if(userByPhone != null){
            return new Result(-7653,"手机已被注册!",0,null);
        }
        String decoder = Base64Util.decoder(MD5Util.MD5Encode(user.getPassword()));
        user.setPassword(decoder);
        user.setId(UUIDUtils.generateNumberUUID(EsmConstant.USER_ID));
        user.setHeadImg(PropertiesConfig.getPropertyValue(EsmConstant.DEFAUTL_HEAD_IMG));
        user.setAge(0);
        Account account = new Account();
        account.setId(UUIDUtils.generateNumberUUID(EsmConstant.ACCOUNT_ID));
        account.setUser(user);
        account.setBalance(0.00);
        Integer insertUserIsOk = userMapper.create(user);
        Integer insertAccountIsOk = accountService.create(account);
        if (insertUserIsOk.intValue() == 0 || insertAccountIsOk.intValue() == 0){
            return new Result(-200,"注册失败!",0,null);
        }
        return new Result(200,"注册成功!",0,null);
    }

    /**
     * 登陆验证
     *
     * @param username 用户名
     * @param password 密码
     * @return com.wanl.entity.Result
     * @Author YangBin
     * @Date 9:46 2019/2/23
     * @Param [username, password]
     * @version v1.0
     **/
    @Override
    public Result login(String username, String password) {
        if (!StringUtils.isNotBlank(username) && !StringUtils.isNotBlank(password)){
            return new Result(-1011,"参数为空!");
        }
        User userByUsername = userMapper.findUserByUsername(username);
        if (userByUsername == null){
            return new Result(-1012,"还用户名尚未注册!");
        }
        String decoder = Base64Util.decoder(MD5Util.MD5Encode(password));
        User userByNamePass = userMapper.findUserByNamePass(username, decoder);
        if (userByNamePass == null){
            return new Result(-1013,"密码错误!");
        }
//        boolean hmset = redisCacheManager.hmset(userByNamePass.getId(), EntityUtils.entityToMap(userByNamePass), 60 * 10);
//        if (!hmset){
//            new Result(-1014,"对不起!设置信息有误!请稍后再试!");
//        }
        return new Result(200,"登陆成功!",0,userByNamePass);
    }
}
