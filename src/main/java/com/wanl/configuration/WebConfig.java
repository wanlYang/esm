package com.wanl.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/**
 * @Title: WebConfig.java
 * @Package:com.wanl.configuration
 * @Description:(springmvc配置类)
 * @author:YangBin
 * @date:2019年2月20日
 * @version:V1.0
 */
@Configuration
@ComponentScan(basePackages = {"com.wanl.*"}, useDefaultFilters = false, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, ControllerAdvice.class})
})
@EnableAspectJAutoProxy
public class WebConfig extends WebMvcConfigurationSupport {

    private static Logger logger = LogManager.getLogger(WebConfig.class.getName());

    /**
     * 自定处理静态资源
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    /**
     * 注册默认静态资源处理
     */
    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 注册页面
     */
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/404").setViewName("404");
        registry.addViewController("/500").setViewName("500");
        registry.addViewController("/403").setViewName("403");
    }

    /**
     * @param templateEngine
     * @return
     * @Description:(thymeleaf 视图解析器)
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @return:ThymeleafViewResolver
     */
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine);
        thymeleafViewResolver.setCharacterEncoding("utf-8");
        logger.info("thymeleaf 视图解析器------> success create");
        return thymeleafViewResolver;
    }

    /**
     * @param templateResolver
     * @return
     * @Description:(模板引擎)
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @return:SpringTemplateEngine
     */
    @Bean
    public SpringTemplateEngine springTemplateEngine(SpringResourceTemplateResolver templateResolver) {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(templateResolver);
        springTemplateEngine.addDialect(new SpringSecurityDialect());
        logger.info("SpringTemplateEngine 模板引擎------> success create");
        return springTemplateEngine;
    }

    /**
     * @return
     * @Description:(模板解析器)
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @return:SpringResourceTemplateResolver
     */
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setOrder(9);
        templateResolver.setPrefix("/WEB-INF/view/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCacheable(false);
        templateResolver.setCharacterEncoding("utf-8");
        logger.info("SpringResourceTemplateResolver 模板解析器------> success create");
        return templateResolver;
    }

    /**
     * @return
     * @Description:(配置文件上传)
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @return:CommonsMultipartResolver
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        commonsMultipartResolver.setMaxUploadSizePerFile(5242880);
        commonsMultipartResolver.setResolveLazily(true);
        return commonsMultipartResolver;
    }

}
