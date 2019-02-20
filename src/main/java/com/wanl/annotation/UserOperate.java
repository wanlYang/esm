package com.wanl.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title: UserOperate.java
 * @Package:com.wanl.annotation
 * @Description:(定义方法对应的模块名,记录日志)
 * @author:YangBin
 * @date:2019年2月20日
 * @version:V1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface UserOperate {

    // 模块名
    String modelName() default "";
    
    // 操作内容
    //String option() default "";
    
}
