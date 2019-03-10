package com.wanl.mapper;

import com.wanl.entity.Order;
import com.wanl.entity.OrderItem;

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


}
