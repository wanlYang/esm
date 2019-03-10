package com.wanl.service;

import com.wanl.entity.Result;

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

}
