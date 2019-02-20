package com.wanl.aspect;

import java.lang.reflect.Method;

import com.wanl.annotation.SwitchingDataSource;
import com.wanl.datasource.MultipleDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 多数据源自动切换通知类(拦截com.ic.admin.service中所有的类中的方法)
 * 首先判断当前类是否被该SwitchingDataSource注解进行注释,如果没有采用默认的数据源配置
 * 如果有,则读取注解中的value值,将数据源切到value指定的数据源
 * 
 * @Title: MultipleDataSourceAspect.java
 * @Package:com.wanl.aspect
 * @Description:(作用)
 * @author:YangBin
 * @date:2019年2月20日
 * @version:V1.0
 */
@Aspect
@Component
@Order(1)
public class MultipleDataSourceAspect {
    
    private static Logger logger = LogManager.getLogger(MultipleDataSourceAspect.class.getName());

    /**
     * @Description:(定义切换数据源时切点)
     * @param:   
     * @return:void  
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     */
    @Pointcut("execution(* com.wanl.service..*.*ServiceImpl.*(..))")
    public void interceptorService() {
    }

    /**
     * @Description:(拦截,进行切换数据源)
     * @param:@param joinPoint   
     * @return:void  
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     */
    @Before(value = "interceptorService()")
    public void setDataSource(JoinPoint joinPoint) {
        // 拦截的实体类,就是当前正在执行的service
        Object target = joinPoint.getTarget();
        if (target.getClass().isAnnotationPresent(SwitchingDataSource.class)) {
            SwitchingDataSource switchingDataSource = target.getClass().getAnnotation(SwitchingDataSource.class);
            String dataSource = switchingDataSource.value();
            logger.info(target.getClass() + "数据源切换至--->" + dataSource);
            MultipleDataSource.setDataSourceKey(dataSource);
        } else {
            logger.info("默认数据源操作--->" + target.getClass());
        }
        // 获取签名
        Signature signature = joinPoint.getSignature();
        // 获取方法签名
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if(method != null) {
            // 判断是否包含自定义注解
            if(method.isAnnotationPresent(SwitchingDataSource.class)) {
                SwitchingDataSource switchingDataSource = method.getAnnotation(SwitchingDataSource.class);
                // 获取模块名
                String dataSource = switchingDataSource.value();
                logger.info(methodSignature.getName() + "数据源切换至--->" + dataSource);
                MultipleDataSource.setDataSourceKey(dataSource);
            }
        }
    }

    /**
     * @Description:(当操作完成时,释放当前的数据源 如果不释放,频繁点击时会发生数据源冲突,本是另一个数据源的表,结果跑到另外一个数据源去,报表不存在)
     * @param:@param joinPoint   
     * @return:void  
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     */
    @After(value = "interceptorService()")
    public void removeDataSource() {
        MultipleDataSource.removeDataSourceKey();
    }

}
