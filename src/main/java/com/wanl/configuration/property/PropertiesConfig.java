package com.wanl.configuration.property;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Title: PropertiesConfig
 * @Package:com.wanl.configuration.property
 * @Description:(配置文件类)
 * @author:Yang
 * @date:2019/2/20
 * @version:V1.0
 */
public class PropertiesConfig extends PropertyPlaceholderConfigurer {

    private static Logger logger = LogManager.getLogger(PropertiesConfig.class.getName());

    private static Map<String,String> propertyMap;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        propertyMap = new HashMap<String,String>();
        for (Object key: props.keySet()) {
            String keyString = key.toString();
            String value = props.getProperty(keyString);
            propertyMap.put(keyString,value);
        }
        logger.info("PropertiesConfig-->" + propertyMap);
    }

    public static String getPropertyValue(String keyName){
        return propertyMap.get(keyName);
    }
}
