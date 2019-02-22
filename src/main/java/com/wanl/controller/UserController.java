package com.wanl.controller;

import com.wanl.constant.EsmConstant;
import com.wanl.entity.Result;
import com.wanl.entity.User;
import com.wanl.service.UserService;
import com.wanl.utils.CookieUtil;
import com.wanl.utils.redis.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登陆注册相关实例操作
 * @ClassName: UserController
 * @Package:com.wanl.controller
 * @author:YangBin
 * @date:2019/2/21 17:02
 * @version:V1.0
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisCacheManager redisCacheManager;

    @RequestMapping(value = "/regist/submit",method = RequestMethod.POST)
    @ResponseBody
    public Result regist(User user, String phoneCode, String confirmPassword, HttpServletRequest request, HttpServletResponse response){
        Result registResult = userService.regist(user, phoneCode, confirmPassword);
        String cookie = CookieUtil.getCookie(request, EsmConstant.SMS_CODE, false);
        String tempPhone = (String)redisCacheManager.get(EsmConstant.TEMP_PHONE);
        if (tempPhone != null){
            redisCacheManager.del(EsmConstant.TEMP_PHONE);
        }
        if (cookie != null){
            redisCacheManager.del(cookie);
            CookieUtil.delCookie(response,request,EsmConstant.SMS_CODE);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return registResult;
    }

}