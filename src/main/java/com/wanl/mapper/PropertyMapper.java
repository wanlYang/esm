package com.wanl.mapper;

import com.wanl.entity.Property;

/**
 * 属性mapper
 * @ClassName: PropertyMapper
 * @Package:com.wanl.mapper
 * @author:YangBin
 * @date:2019/3/5 22:59
 * @version:V1.0
 */
public interface PropertyMapper {

    /**
     * 根据id对应属性
     * @Author YangBin
     * @Date 23:03 2019/3/5
     * @Param [id]
     * @param id ID
     * @version v1.0
     * @return com.wanl.entity.Property
     **/
    public Property findPropertyById(Integer id);
}
