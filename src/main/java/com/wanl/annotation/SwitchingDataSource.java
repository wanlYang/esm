package com.wanl.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 通过注解来选择数据源
 * @Title: SwitchingDataSource.java
 * @Package:com.wanl.annotation
 * @author:YangBin
 * @date:2019年2月20日
 * @version:V1.0
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SwitchingDataSource {

    String value() default "mysqlDeveDataSource";
    
}
