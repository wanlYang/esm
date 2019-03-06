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

    /**
     * 随机获取襦裙类商品
     * @Author YangBin
     * @Date 23:18 2019/3/4
     * @Param []
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Product>
     **/
    List<Product> getSkirtProduct();

    /**
     * 随机获取衣裳类商品
     * @Author YangBin
     * @Date 0:12 2019/3/5
     * @Param []
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Product>
     **/
    List<Product> getClothesProduct();

    /**
     * 随机获取鞋靴类商品
     * @Author YangBin
     * @Date 0:12 2019/3/5
     * @Param []
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Product>
     **/
	List<Product> getBootiesProduct();

	/**
     * 根据ID获取商品
	 * @Author YangBin
	 * @Date 22:34 2019/3/5
	 * @Param [id]
     * @param id 商品ID
	 * @version v1.0
	 * @return com.wanl.entity.Product
	 **/
    Product getProduct(Integer id);

    /**
     * 获取推荐商品
     * @Author YangBin
     * @Date 23:27 2019/3/6
     * @Param []
     * @param id ID
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Product>
     **/
    List<Product> getRecommendProduct(Integer id);
}
