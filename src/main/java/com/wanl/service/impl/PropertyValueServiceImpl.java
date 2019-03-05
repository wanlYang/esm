package com.wanl.service.impl;

import com.wanl.entity.PropertyValue;
import com.wanl.mapper.PropertyValueMapper;
import com.wanl.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现类
 * @ClassName: PropertyValueServiceImpl
 * @Package:com.wanl.service.impl
 * @author:YangBin
 * @date:2019/3/5 22:45
 * @version:V1.0
 */
@Service
public class PropertyValueServiceImpl implements PropertyValueService {
    @Autowired
    private PropertyValueMapper propertyValueMapper;
    /**
     * 根据商品ID获取商品对应属性及属性值
     *
     * @param id 商品ID
     * @return java.util.List<com.wanl.entity.PropertyValue>
     * @Author YangBin
     * @Date 22:52 2019/3/5
     * @Param [id]
     * @version v1.0
     **/
    @Override
    public List<PropertyValue> getPropertyValue(Integer id) {
        List<PropertyValue> propertyValues = propertyValueMapper.getPropertyValue(id);
        return propertyValues;
    }
}
