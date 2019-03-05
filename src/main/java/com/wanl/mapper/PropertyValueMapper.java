package com.wanl.mapper;

import com.wanl.entity.PropertyValue;

import java.util.List;

/**
 * 属性值
 * @ClassName: PropertyValueMapper
 * @Package:com.wanl.mapper
 * @author:YangBin
 * @date:2019/3/5 22:53
 * @version:V1.0
 */
public interface PropertyValueMapper {

    /**
     * 根据商品ID获取属性值
     * @Author YangBin
     * @Date 22:55 2019/3/5
     * @Param [id]
     * @param id
     * @version v1.0
     * @return java.util.List<com.wanl.entity.PropertyValue>
     **/
    public List<PropertyValue> getPropertyValue(Integer id);
}
