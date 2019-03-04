package com.wanl.mapper;

import com.wanl.entity.Category;

import java.util.List;

/**
 * 分类数据库操作
 * @ClassName: CategoryMapper
 * @Package:com.wanl.mapper
 * @author:YangBin
 * @date:2019/2/26 8:42
 * @version:V1.0
 */
public interface CategoryMapper {


    /**
     * 获取所有商品分类
     * @Author YangBin
     * @Date 9:14 2019/2/26
     * @Param []
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Category>
     **/
    List<Category> findAll();

    /**
     * 根据ID获取
     * @Author YangBin
     * @Date 9:00 2019/3/1
     * @Param [id]
     * @version v1.0
     * @return com.wanl.entity.Category
     **/
    Category findCateById(Integer id);

    /**
     * 根据父类ID获取全部子分类
     * @Author YangBin
     * @Date 23:21 2019/3/4
     * @Param [cateSkirt]
     * @param cateParentId 父类ID
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Category>
     **/
    List<Category> findCateByParentId(Integer cateParentId);
}
