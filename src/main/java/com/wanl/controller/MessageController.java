package com.wanl.controller;

import com.wanl.constant.EsmConstant;
import com.wanl.entity.Result;
import com.wanl.utils.CookieUtil;
import com.wanl.utils.RegexUtils;
import com.wanl.utils.SendSms;
import com.wanl.utils.UUIDUtils;
import com.wanl.utils.redis.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 消息控制器
 * @ClassName: MessageController
 * @Package:com.wanl.controller
 * @author:YangBin
 * @date:2019/2/21 15:31
 * @version:V1.0
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private RedisCacheManager redisCacheManager;

    /**
     * 发送手机验证码
     * @Author YangBin
     * @Date 16:57 2019/2/21
     * @Param [phone, response]
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    @RequestMapping(value = "/send/phone/code",method = RequestMethod.POST)
    @ResponseBody
    public Result sendPhoneCode(String phone, HttpServletResponse response, HttpServletRequest request){
        Result result = new Result();
        if (!RegexUtils.checkMobile(phone)){
            result.setMessage("手机号有误!");
            result.setStatus(-1);
            return result;
        }
        String cookie = CookieUtil.getCookie(request, EsmConstant.SMS_CODE, false);
        if (cookie != null){
            redisCacheManager.del(cookie);
            CookieUtil.delCookie(response,request,EsmConstant.SMS_CODE);
        }
        String smsCode = SendSms.getSMSCode();
        Result responseStatus = SendSms.sendMessageCode(smsCode, phone);
        if (((String)responseStatus.getData()).equals(EsmConstant.SEND_CODE_SUCCESS)){
            String codeKey = UUIDUtils.getCode();
            redisCacheManager.set(codeKey,smsCode,5*60);
            redisCacheManager.set(EsmConstant.TEMP_PHONE,phone,5*60);
            CookieUtil.addCookie(response, EsmConstant.SMS_CODE, codeKey, 5*60, false);
        }
        return responseStatus;
    }

}
