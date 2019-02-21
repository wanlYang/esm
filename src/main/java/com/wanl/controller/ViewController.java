package com.wanl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 视图控制器
 * @ClassName: ViewController
 * @Package:com.wanl.controller
 * @author:YangBin
 * @date:2019/2/20 14:11
 * @version:V1.0
 */
@Controller
public class ViewController {

    /**
     * 登录页面
     * @Author YangBin
     * @Date 14:12 2019/2/20
     * @Param []
     * @version v1.0
     * @return java.lang.String
     **/
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){

        return "login";
    }

    /**
     * 注册页面
     * @Author YangBin
     * @Date 8:48 2019/2/21
     * @Param []
     * @version v1.0
     * @return java.lang.String
     **/
    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    public String regist(){

        return "regist";
    }

}
