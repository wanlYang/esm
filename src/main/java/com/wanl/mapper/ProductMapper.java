package com.wanl.mapper;

import com.wanl.entity.Product;

import java.util.List;

/**
 * 商品mapper
 * @ClassName: ProductMapper
 * @Package:com.wanl.mapper
 * @author:YangBin
 * @date:2019/3/1 8:33
 * @version:V1.0
 */
public interface ProductMapper {

    /**
     * 获取劲爆热门商品
     * @Author YangBin
     * @Date 9:22 2019/3/1
     * @Param []
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Product>
     **/
    List<Product> findHotProduct();

    /**
     * 根据ID获取商品
     * @Author YangBin
     * @Date 9:22 2019/3/1
     * @Param []
     * @param id ID
     * @version v1.0
     * @return com.wanl.entity.Product
     **/
    Product findProductById(Integer id);

    /**
     * 获取一个分类下的所有商品
     * @Author YangBin
     * @Date 23:25 2019/3/4
     * @Param [id]
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Product>
     **/
    List<Product> findProductByCategoryId(Integer id);
}
