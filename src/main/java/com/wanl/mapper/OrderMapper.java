package com.wanl.mapper;

import com.wanl.entity.Address;
import com.wanl.entity.Order;
import com.wanl.entity.OrderItem;

import java.util.List;

/**
 * 订单mapper
 * @ClassName: OrderMapper
 * @Package:com.wanl.mapper
 * @author:YangBin
 * @date:2019/3/10 14:25
 * @version:V1.0
 */
public interface OrderMapper {


    /**
     * 创建订单
     * @Author YangBin
     * @Date 14:26 2019/3/10
     * @Param [order]
     * @param order 订单
     * @version v1.0
     * @return java.lang.Integer
     **/
    Integer create(Order order);

    /**
     * 创建订单项
     * @Author YangBin
     * @Date 14:29 2019/3/10
     * @Param [orderItem]
     * @param orderItem 订单项
     * @version v1.0
     * @return java.lang.Integer
     **/
    Integer createOrderItem(OrderItem orderItem);

    /**
     * 获取订单
     * @Author YangBin
     * @Date 20:57 2019/3/10
     * @Param [id]
     * @param id 订单ID
     * @version v1.0
     * @return com.wanl.entity.Order
     **/
    Order getOrder(String id);

    /**
     * 获取地址
     * @Author YangBin
     * @Date 21:02 2019/3/10
     * @Param [id]
     * @param id ID
     * @version v1.0
     * @return com.wanl.entity.Address
     **/
    Address getAddress(String id);

    /**
     * 获取订单对应商品详情
     * @Author YangBin
     * @Date 21:06 2019/3/10
     * @Param [id]
     * @param id 订单ID
     * @version v1.0
     * @return java.util.List<com.wanl.entity.OrderItem>
     **/
    List<OrderItem> getOrderItem(String id);

    /**
     * 获取收获地址
     * @Author YangBin
     * @Date 21:27 2019/3/10
     * @Param [id]
     * @param id 用户ID
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Address>
     **/
    List<Address> getAddressList(String id);

    /**
     * 更新订单
     * @Author YangBin
     * @Date 18:21 2019/3/11
     * @Param [order]
     * @param order 订单
     * @version v1.0
     * @return java.lang.Integer
     **/
    Integer update(Order order);
}
