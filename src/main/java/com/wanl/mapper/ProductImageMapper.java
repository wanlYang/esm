package com.wanl.mapper;

import com.wanl.entity.ProductImage;

import java.util.List;

/**
 * 商品图片mapper
 * @ClassName: ProductImageMapper
 * @Package:com.wanl.mapper
 * @author:YangBin
 * @date:2019/3/1 9:15
 * @version:V1.0
 */
public interface ProductImageMapper {

    /**
     * 根据商品ID获取图片
     * @Author YangBin
     * @Date 9:17 2019/3/1
     * @Param []
     * @version v1.0
     * @return java.util.List<com.wanl.entity.ProductImage>
     **/
    List<ProductImage> findImagesByProductId(Integer productId);

    /**
     * 根据ID获取
     * @Author YangBin
     * @Date 9:25 2019/3/1
     * @Param [id]
     * @version v1.0
     * @return com.wanl.entity.ProductImage
     **/
    ProductImage findImageById(Integer id);

}
