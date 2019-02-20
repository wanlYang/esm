package com.wanl.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Title: MultipleDataSource.java
 * @Package:com.wanl.datasource
 * @Description:(多个数据源)
 * @author:YangBin
 * @date:2019年2月20日
 * @version:V1.0
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> DATASOURCEKEY = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        DATASOURCEKEY.set(dataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DATASOURCEKEY.get();
    }

    public static void removeDataSourceKey() {
        DATASOURCEKEY.remove();
    }
}
