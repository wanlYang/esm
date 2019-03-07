package com.wanl.interceptor;

import com.wanl.constant.EsmConstant;
import com.wanl.entity.Result;
import com.wanl.entity.User;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 用户操作拦截器
 * @ClassName: AuthInterceptor
 * @Package:com.wanl.interceptor
 * @author:YangBin
 * @date:2019/3/7 18:41
 * @version:V1.0
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute(EsmConstant.USER_SESSION);
        if (user != null){
            return true;
        }
        if (request.getHeader(EsmConstant.X_REQUEST_WITH) != null && request.getHeader(EsmConstant.X_REQUEST_WITH).equalsIgnoreCase(EsmConstant.XML_HTTP_REQUEST)) {
            response.setCharacterEncoding(EsmConstant.UTF_8);
            response.setContentType(EsmConstant.CONTENT_TYPE_APP_JSON_UTF_8);
            PrintWriter writer = response.getWriter();
            String unauthorized = Result.failed(401, "请登录!");
            writer.write(unauthorized);
            writer.close();
            return false;
        }else{
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
