package com.wanl.service;

import com.wanl.entity.Address;
import com.wanl.entity.Result;

import java.util.List;

/**
 * 订单服务
 * @ClassName: OrderService
 * @Package:com.wanl.service
 * @author:YangBin
 * @date:2019/3/10 14:22
 * @version:V1.0
 */
public interface OrderService {


    /**
     * 下订单
     * @Author YangBin
     * @Date 14:24 2019/3/10
     * @Param [cartId]
     * @param cartId 选中的购物车商品
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    Result createOrder(String[] cartId);

    /**
     * 获取订单详情
     * @Author YangBin
     * @Date 20:56 2019/3/10
     * @Param [id]
     * @param id 订单ID
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    Result getOrderInfo(String id);

    /**
     * 获取用户对应收获地址
     * @Author YangBin
     * @Date 21:25 2019/3/10
     * @Param [id]
     * @param id 用户ID
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Address>
     **/
    List<Address> getAddress(String id);
}
