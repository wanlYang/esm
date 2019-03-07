package com.wanl.mapper;

import com.wanl.entity.ShopCart;

import java.util.List;

/**
 * @ClassName: ShopCartMapper
 * @Package:com.wanl.mapper
 * @author:YangBin
 * @date:2019/3/7 19:48
 * @version:V1.0
 */
public interface ShopCartMapper {

    /**
     * 添加数据
     * @Author YangBin
     * @Date 19:53 2019/3/7
     * @Param [shopCart]
     * @param shopCart 购物车
     * @version v1.0
     * @return java.lang.Integer
     **/
    public Integer addShopCart(ShopCart shopCart);


    /**
     * 根据商品ID获取
     * @Author YangBin
     * @Date 19:53 2019/3/7
     * @Param [id]
     * @param id 商品ID
     * @version v1.0
     * @return com.wanl.entity.ShopCart
     **/
    public ShopCart getShopCart(Integer id);


    /**
     * 根据ID获取
     * @Author YangBin
     * @Date 19:57 2019/3/7
     * @Param [id]
     * @param id 购物车ID
     * @version v1.0
     * @return com.wanl.entity.ShopCart
     **/
    public ShopCart getShopCartById(Integer id);

    /**
     * 更新数量
     * @Author YangBin
     * @Date 20:10 2019/3/7
     * @Param [parseInt]
     * @param shopCart 数量
     * @version v1.0
     * @return java.lang.Integer
     **/
    Integer updateAmount(ShopCart shopCart);

    /**
     * 获取用户对应的购物车
     * @Author YangBin
     * @Date 20:46 2019/3/7
     * @Param [id]
     * @param id 用户ID
     * @version v1.0
     * @return java.util.List<com.wanl.entity.ShopCart>
     **/
    List<ShopCart> getShopCarts(String id);

    /**
     * 获取购物车物件
     * @Author YangBin
     * @Date 20:57 2019/3/7
     * @Param []
     * @param id 用户ID
     * @version v1.0
     * @return java.lang.Integer
     **/
    Integer getShopCartPiece(String id);
}
