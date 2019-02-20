package com.wanl.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * cookie操作工具类
 * @ClassName: CookieUtil
 * @Package:com.ic.utils
 * @author:YangBin
 * @date:2019/1/4 11:27
 * @version:V1.0
 */
public class CookieUtil {

    private static Logger logger = LogManager.getLogger(CookieUtil.class.getName());

    /**
     * 添加cookie
     * @Author YangBin
     * @Date 11:45 2019/1/4
     * @Param [response, name, value, maxAge, isEncode]
     * @version v1.0
     * @return void
     **/
    public static void addCookie(HttpServletResponse response,String name,String value,Integer maxAge,boolean isEncode){
        try {
            if (value == null){
                value = "";
            } else if (isEncode){
                value = URLEncoder.encode(value,"UTF-8");
            }
            Cookie cookie = new Cookie(name,value);
            if (maxAge > 0){
                cookie.setMaxAge(maxAge);
            }
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            logger.error("添加cookie出错!");
            e.printStackTrace();
        }
    }

    /**
     * 删除cookie
     * @Author YangBin
     * @Date 11:45 2019/1/4
     * @Param [response, request, name]
     * @version v1.0
     * @return boolean
     **/
    public static boolean delCookie(HttpServletResponse response, HttpServletRequest request,String name){
        boolean bool = false;
        Cookie[] cookies = request.getCookies();
        if(null == cookies || cookies.length == 0) {
            return bool;
        }
        try {
            for (Cookie cookie:cookies) {
                if (cookie.getName().equals(name)){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    bool = true;
                    break;
                }
            }
        } catch (Exception e) {
            logger.error("删除cookie发生异常!");
            e.printStackTrace();
        }
        return bool;
    }

    /**
     * 获取cookie
     * @Author YangBin
     * @Date 11:54 2019/1/4
     * @Param [request, name, isDecoder]
     * @version v1.0
     * @return java.lang.String
     **/
    public static String getCookie(HttpServletRequest request,String name,boolean isDecoder){
        Cookie[] cookies = request.getCookies();
        if (cookies == null || name == null){
            return "";
        }
        String retValue = null;
        try {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(name)) {
                    if (isDecoder){
                        retValue = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
                    } else {
                        retValue = cookies[i].getValue();
                    }
                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
            logger.error("获取cookie发生异常!");
            e.printStackTrace();
        }
        return retValue;
    }
}
