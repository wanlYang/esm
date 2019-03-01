package com.wanl.service;

import com.wanl.entity.Product;

import java.util.List;

/**
 * 产品服务接口
 * @ClassName: ProductService
 * @Package:com.wanl.service
 * @author:YangBin
 * @date:2019/2/28 9:30
 * @version:V1.0
 */
public interface ProductService {


    /**
     * 获取爆款商品
     * @Author YangBin
     * @Date 8:32 2019/3/1
     * @Param []
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Product>
     **/
    List<Product> getHotproduct();
}
