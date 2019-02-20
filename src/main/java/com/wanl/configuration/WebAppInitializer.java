package com.wanl.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Title: WebAppInitializer.java
 * @Package:com.wanl.configuration
 * @Description:(DispatherServlet初始化,代替在web.xml中到DispatherServlet配置)
 * @author:YangBin
 * @date:2019年2月19日
 * @version:V1.0
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static Logger logger = LogManager.getLogger(WebAppInitializer.class.getName());

    @Override
    protected Class<?>[] getRootConfigClasses() {
        logger.info("root配置类初始化-->");
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        logger.info("web配置类初始化-->");
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        logger.info("初始化映射-->");
        return new String[]{"/"};
    }
}
