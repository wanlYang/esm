package com.wanl.service.impl;

import com.wanl.entity.Product;
import com.wanl.entity.ProductImage;
import com.wanl.mapper.ProductImageMapper;
import com.wanl.mapper.ProductMapper;
import com.wanl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品实现类
 * @ClassName: ProductServiceImpl
 * @Package:com.wanl.service.impl
 * @author:YangBin
 * @date:2019/2/28 9:30
 * @version:V1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductImageMapper productImageMapper;
    /**
     * 获取爆款商品
     *
     * @return java.util.List<com.wanl.entity.Product>
     * @Author YangBin
     * @Date 8:32 2019/3/1
     * @Param []
     * @version v1.0
     **/
    @Override
    public List<Product> getHotproduct() {
        List<Product> hotProducts = productMapper.findHotProduct();

        setProductImages(hotProducts);

        return hotProducts;
    }

    /**
     * 设置商品第一个图片和商品全部单图
     * @Author YangBin
     * @Date 9:34 2019/3/1
     * @Param [products]
     * @version v1.0
     * @return void
     **/
    public void setProductImages(List<Product> products) {
        for (Product product: products) {
            List<ProductImage> imagesByProductId = productImageMapper.findImagesByProductId(product.getId());
            product.setProductSingleImages(imagesByProductId);
            product.setFirstProductImage(imagesByProductId.get(0));
        }
    }

}
