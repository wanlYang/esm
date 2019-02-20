package com.wanl.utils.security;

import com.wanl.constant.EsmConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * spring security 工具类
 *
 * @Title: SpringSecurityUtil
 * @Package:com.ic.utils.security
 * @author:Yang
 * @date:2018/12/30
 * @version:V1.0
 */
public class SpringSecurityUtil {

    /**
     * 获取security Authentication
     * @Author YangBin
     * @Date 21:34 2019/1/12
     * @Param [request]
     * @version v1.0
     * @return org.springframework.security.core.Authentication
     **/
    public static Authentication getSecurityAuthentication() {
        Authentication authentication = getSecurityContextImpl().getAuthentication();
        return authentication;
    }


    /**
     * 获取当前用户权限信息
     * @Author YangBin
     * @Date 21:37 2019/1/12
     * @Param []
     * @version v1.0
     * @return com.ic.entity.User
     **/
    public static Collection<? extends GrantedAuthority> getUserAuthorities(){
        Collection<? extends GrantedAuthority> authorities = (Collection<? extends GrantedAuthority>) getSecurityContextImpl()
                .getAuthentication().getAuthorities();
        return authorities;
    }

    /**
     * 获取security SecurityContextImpl
     * @Author YangBin
     * @Date 21:56 2019/1/12
     * @Param []
     * @version v1.0
     * @return org.springframework.security.core.context.SecurityContextImpl
     **/
    private static SecurityContextImpl getSecurityContextImpl(){
        // 获得requestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获的requestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest)requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        // 获取session信息
        HttpSession session = (HttpSession)requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        // 获取security用户相关信息
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) session.getAttribute(EsmConstant.SPRING_SECURITY_CONTEXT);
        return securityContextImpl;
    }

    /**
     * 私有化构造方法
     * @Author YangBin
     * @Date 21:55 2019/1/12
     * @Param []
     * @version v1.0
     * @return 
     **/
    private SpringSecurityUtil(){
        
    }
}
