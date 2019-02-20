package com.wanl.configuration;

import com.wanl.configuration.property.PropertiesConfig;
import com.wanl.datasource.MultipleDataSource;
import com.wanl.utils.jdbc.PackagesSqlSessionFactoryBean;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: RootConfig.java
 * @Package:com.wanl.configuration
 * @Description:(spring 配置类)
 * @author:YangBin
 * @date:2019年2月19日
 * @version:V1.0
 */
@Configuration
@ComponentScan(basePackages = {"com.wanl.*"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, ControllerAdvice.class})
})
@PropertySource(value = {"classpath:jdbc.properties", "classpath:merchant.properties"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@MapperScan(basePackages = {"com.wanl.mapper"})
public class RootConfig {

    private static Logger logger = LogManager.getLogger(RootConfig.class.getName());

    @Autowired
    @Qualifier("mysqlTestDataSource")
    private BasicDataSource mysqlTestDataSource;

    @Autowired
    @Qualifier("mysqlDeveDataSource")
    private BasicDataSource mysqlDeveDataSource;

    @Autowired
    @Qualifier("mysqlDataSource")
    private BasicDataSource mysqlDataSource;

    @Autowired
    private MultipleDataSource multipleDataSource;


    /**
     * @param driverClassName
     * @param url
     * @param user
     * @param password
     * @return
     * @Description:(配置测试数据源)
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @return:BasicDataSource
     */
    @Bean(destroyMethod = "close", name = "mysqlTestDataSource")
    public BasicDataSource mysqlTestDataSource(
            @Value(value = "${jdbc.mysql.test.driver}") String driverClassName,
            @Value(value = "${jdbc.mysql.test.url}") String url,
            @Value(value = "${jdbc.mysql.test.user}") String user,
            @Value(value = "${jdbc.mysql.test.password}") String password
    ) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driverClassName);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }

    /**
     * @param driverClassName
     * @param url
     * @param user
     * @param password
     * @return
     * @Description:(配置开发数据源)
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @return:BasicDataSource
     */
    @Bean(destroyMethod = "close", name = "mysqlDeveDataSource")
    public BasicDataSource mysqlDeveDataSource(
            @Value(value = "${jdbc.mysql.deve.driver}") String driverClassName,
            @Value(value = "${jdbc.mysql.deve.url}") String url,
            @Value(value = "${jdbc.mysql.deve.user}") String user,
            @Value(value = "${jdbc.mysql.deve.password}") String password
    ) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driverClassName);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }

    /**
     * @param driverClassName
     * @param url
     * @param user
     * @param password
     * @return
     * @Description:(配置主数据源)
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @return:BasicDataSource
     */
    @Bean(destroyMethod = "close", name = "mysqlDataSource")
    public BasicDataSource mysqlDataSource(
            @Value(value = "${jdbc.mysql.driver}") String driverClassName,
            @Value(value = "${jdbc.mysql.url}") String url,
            @Value(value = "${jdbc.mysql.user}") String user,
            @Value(value = "${jdbc.mysql.password}") String password
    ) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driverClassName);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }

    /**
     * @return
     * @Description:(多个数据源)
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @return:MultipleDataSource
     */
    @Bean
    public MultipleDataSource multipleDataSource() {
        MultipleDataSource multipleDataSource = new MultipleDataSource();
        multipleDataSource.setDefaultTargetDataSource(mysqlDeveDataSource);
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("mysqlDataSource", mysqlDataSource);
        targetDataSources.put("mysqlTestDataSource", mysqlTestDataSource);
        targetDataSources.put("mysqlDeveDataSource", mysqlDeveDataSource);
        multipleDataSource.setTargetDataSources(targetDataSources);
        return multipleDataSource;
    }

    /**
     * @return
     * @Description:(配置mybatis sqlSessionFactoryBean)
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @return:SqlSessionFactory
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {

        try {
            PackagesSqlSessionFactoryBean sqlSessionFactoryBean = new PackagesSqlSessionFactoryBean();
            sqlSessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:/mybatis-config.xml"));
            sqlSessionFactoryBean.setDataSource(multipleDataSource);
            sqlSessionFactoryBean.setTypeAliasesPackage("com.wanl.**.entity");
            PathMatchingResourcePatternResolver mapperLocations = new PathMatchingResourcePatternResolver();
            Resource[] resources = mapperLocations.getResources("classpath:/com/wanl/mapper/*Mapper.xml");
            sqlSessionFactoryBean.setMapperLocations(resources);
            logger.info("mybatis sqlSessionFactoryBean success create ");
            return sqlSessionFactoryBean.getObject();
        } catch (IOException e) {
            logger.error("mybatis resolver mapper*xml is error");
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            logger.error("mybatis sqlSessionFactoryBean create error");
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @return
     * @Description:(配置事务管理对象)
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @return:PlatformTransactionManager
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(multipleDataSource);
    }

    /**
     * @return
     * @Description:(${}占位符)
     * @author:YangBin
     * @date:2019年2月20日
     * @version:V1.0
     * @return:PropertySourcesPlaceholderConfigurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "propertyConfigurer")
    @Scope("singleton")
    public static PropertyPlaceholderConfigurer propertiesConfig() {
        PropertiesConfig propertiesConfig = new PropertiesConfig();
        PathMatchingResourcePatternResolver mapperLocations = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = mapperLocations.getResources("classpath*:/merchant.properties");
            propertiesConfig.setLocations(resources);
        } catch (IOException e) {
            logger.error("propertyConfigurer is error");
            e.printStackTrace();
        }
        return propertiesConfig;
    }

}
