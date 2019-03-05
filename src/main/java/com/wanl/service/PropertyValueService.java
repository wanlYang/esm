package com.wanl.service;

import com.wanl.entity.PropertyValue;

import java.util.List;

/**
 * 商品属性值
 * @ClassName: PropertyValueService
 * @Package:com.wanl.service
 * @author:YangBin
 * @date:2019/3/5 22:44
 * @version:V1.0
 */
public interface PropertyValueService {

    /**
     * 根据商品ID获取商品对应属性及属性值
     * @Author YangBin
     * @Date 22:52 2019/3/5
     * @Param [id]
     * @param id 商品ID
     * @version v1.0
     * @return java.util.List<com.wanl.entity.PropertyValue>
     **/
    public List<PropertyValue> getPropertyValue(Integer id);

}
