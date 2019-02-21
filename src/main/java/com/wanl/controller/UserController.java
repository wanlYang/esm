package com.wanl.controller;

import com.wanl.entity.Result;
import com.wanl.entity.User;
import com.wanl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/regist/submit",method = RequestMethod.POST)
    @ResponseBody
    public Result regist(User user,String phoneCode,String confirmPassword){
        //Result registResult = userService.regist(user, phoneCode, confirmPassword);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Result(200,"成功",0,"");
    }

}
