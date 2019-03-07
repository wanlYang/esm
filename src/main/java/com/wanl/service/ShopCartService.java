package com.wanl.service;

import com.wanl.entity.Result;
import com.wanl.entity.User;

/**
 * 购物车服务层
 * @ClassName: ShopCartService
 * @Package:com.wanl.service
 * @author:YangBin
 * @date:2019/3/7 19:45
 * @version:V1.0
 */
public interface ShopCartService {

    /**
     * 添加购物车
     * @Author YangBin
     * @Date 19:47 2019/3/7
     * @Param [id, amount]
     * @param id 商品ID
     * @param user 用户
     * @param amount 数量
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    public Result addShopCart(String id, String amount,User user);

    /**
     * 获取购物车物件
     * @Author YangBin
     * @Date 20:56 2019/3/7
     * @Param []
     * @param id 用户ID
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    Result getShopCartPiece(String id);
}
