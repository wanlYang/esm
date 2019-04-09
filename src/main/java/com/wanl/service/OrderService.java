package com.wanl.service;

import com.wanl.entity.Address;
import com.wanl.entity.Order;
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

    /**
     * 根据账户余额支付
     * @Author YangBin
     * @Date 18:07 2019/3/11
     * @Param [address, orderId]
     * @param address 地址ID
     * @param orderId 订单ID
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    Result payOrder(String address, String orderId);

    /**
     * 确认订单
     * @Author YangBin
     * @Date 18:54 2019/3/11
     * @Param [orderId]
     * @param orderId 订单ID
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    Result confirm(String orderId);

    /**
     * 获取订单列表
     * @Author YangBin
     * @Date 11:10 2019/3/14
     * @Param [id]
     * @param id 用户ID
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Order>
     **/
    List<Order> orderList(String id);

    /**
     * 删除订单
     * @Author YangBin
     * @Date 11:25 2019/3/14
     * @Param [id]
     * @param id 订单ID
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    Result del(String id);

    /**
     * 添加地址
     * @Author YangBin
     * @Date 18:00 2019/4/9
     * @Param [address, city, id]
     * @param id 用户ID
     * @param address 地址
     * @param city 处理
     * @version v1.0
     * @return java.lang.Integer
     **/
    Integer addAddress(Address address, String city, String id);
}
