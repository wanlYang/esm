package com.wanl.controller;

import com.wanl.constant.EsmConstant;
import com.wanl.entity.Account;
import com.wanl.entity.Address;
import com.wanl.entity.Result;
import com.wanl.entity.User;
import com.wanl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 账户相关
 * @ClassName: AccountController
 * @Package:com.wanl.controller
 * @author:YangBin
 * @date:2019/4/9 18:57
 * @version:V1.0
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/recharge",method = RequestMethod.GET)
    public ModelAndView rechargePage(ModelAndView modelAndView,String backUrl,HttpSession session){
        User user = (User)session.getAttribute(EsmConstant.USER_SESSION);
        Account account = accountService.get(user.getId());
        modelAndView.addObject("backUrl",backUrl);
        modelAndView.setViewName("account_recharge");
        modelAndView.addObject("account",account);
        return modelAndView;
    }

    @RequestMapping(value = "/recharge/submit",method = RequestMethod.POST)
    @ResponseBody
    public Result recharge(Double money,HttpSession session){
        User user = (User)session.getAttribute(EsmConstant.USER_SESSION);
        if (user == null){
            return new Result(-1,"异常!",0,0);
        }
        Integer row = accountService.recharge(user,money);
        Account account = accountService.get(user.getId());
        return new Result(200,"充值成功!",row,account);
    }

}
