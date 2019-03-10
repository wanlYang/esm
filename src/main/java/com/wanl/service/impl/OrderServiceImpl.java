package com.wanl.service.impl;

import com.wanl.constant.EsmConstant;
import com.wanl.entity.*;
import com.wanl.mapper.OrderMapper;
import com.wanl.mapper.ShopCartMapper;
import com.wanl.mapper.UserMapper;
import com.wanl.service.OrderService;
import com.wanl.utils.CreationNumber;
import com.wanl.utils.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单服务实现类
 *
 * @ClassName: OrderServiceImpl
 * @Package:com.wanl.service.impl
 * @author:YangBin
 * @date:2019/3/10 14:24
 * @version:V1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShopCartMapper shopCartMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 下订单
     *
     * @param cartId 选中的购物车商品
     * @return com.wanl.entity.Result
     * @Author YangBin
     * @Date 14:24 2019/3/10
     * @Param [cartId]
     * @version v1.0
     **/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result createOrder(String[] cartId) {
        List<ShopCart> shopCarts = new ArrayList<>();
        for (String id : cartId) {
            ShopCart shopCart = shopCartMapper.getShopCartById(Integer.parseInt(id));
            shopCarts.add(shopCart);
            shopCartMapper.del(id);
        }
        if (shopCarts == null) {
            return new Result(0, "数据有误!", 0, 0);
        }
        Order order = new Order();
        order.setId(CreationNumber.makeOrderCode(UUIDUtils.getCode()));
        User user = userMapper.findUserById(shopCarts.get(0).getUser().getId());
        order.setUser(user);
        order.setCreateDate(new Date());
        order.setPayDate(null);
        order.setDeliveryDate(null);
        order.setConfirmDate(null);
        order.setStatus(EsmConstant.ORDER_NOTPAY);
        order.setAddress(null);
        Double total = 0.00;
        for (ShopCart shopCart : shopCarts) {
            total += shopCart.getAmount() * Double.parseDouble(shopCart.getProduct().getPrice());
            OrderItem orderItem = new OrderItem();
            orderItem.setNumber(shopCart.getAmount().toString());
            orderItem.setOrder(order);
            orderItem.setProduct(shopCart.getProduct());
            orderItem.setUser(user);
            order.getOrderItems().add(orderItem);
        }
        order.setOrderTotal(total.toString());
        orderMapper.create(order);
        for (OrderItem o : order.getOrderItems()) {
            orderMapper.createOrderItem(o);

        }
        return new Result(200, "创建成功!", 0, order.getId());
    }

    /**
     * 获取订单详情
     *
     * @param id 订单ID
     * @return com.wanl.entity.Result
     * @Author YangBin
     * @Date 20:56 2019/3/10
     * @Param [id]
     * @version v1.0
     **/
    @Override
    public Result getOrderInfo(String id) {
        if (!StringUtils.isNotBlank(id)){
            return new Result(0, "数据有误!", 0, 0);
        }
        Order order = orderMapper.getOrder(id);
        List<OrderItem> orderItems = orderMapper.getOrderItem(id);
        Double total = 0.00;
        for (OrderItem orderItem : orderItems) {
            total += Integer.parseInt(orderItem.getNumber()) * Double.parseDouble(orderItem.getProduct().getPrice());
        }
        order.setOrderTotal(total.toString());
        order.setOrderItems(orderItems);
        return new Result(200, "数据成功!", 0, order);
    }

    /**
     * 获取用户对应收获地址
     *
     * @param id 用户ID
     * @return java.util.List<com.wanl.entity.Address>
     * @Author YangBin
     * @Date 21:25 2019/3/10
     * @Param [id]
     * @version v1.0
     **/
    @Override
    public List<Address> getAddress(String id) {
        List<Address> addresses = orderMapper.getAddressList(id);

        return addresses;
    }
}
