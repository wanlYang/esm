package com.wanl.service.impl;

import com.wanl.constant.EsmConstant;
import com.wanl.entity.*;
import com.wanl.mapper.*;
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

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private ProductMapper productMapper;

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
        if (order == null){
            return new Result(0, "数据有误!", 0, 0);
        }
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

    /**
     * 根据账户余额支付
     *
     * @param address 地址ID
     * @param orderId 订单ID
     * @return com.wanl.entity.Result
     * @Author YangBin
     * @Date 18:07 2019/3/11
     * @Param [address, orderId]
     * @version v1.0
     **/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result payOrder(String address, String orderId) {
        Order chorder = orderMapper.getOrder(orderId);
        if (chorder == null){
            return new Result(0, "数据有误!", 0, 0);
        }
        Result orderInfo = getOrderInfo(orderId);
        Order order = (Order)orderInfo.getData();
        Account account = accountMapper.get(order.getUser().getId());
        if (account.getBalance() < Double.parseDouble(order.getOrderTotal())){
            new Result(-1, "对不起余额不足!", 0, 0);
        }
        Address orderAddress = orderMapper.getAddress(address);
        order.setAddress(orderAddress);
        order.setStatus(EsmConstant.ORDER_SHIPPED);
        order.setPayDate(new Date());
        order.setDeliveryDate(new Date());
        orderMapper.update(order);
        account.setBalance(account.getBalance()-Double.parseDouble(order.getOrderTotal()));
        accountMapper.update(account);
        List<OrderItem> orderItems = orderMapper.getOrderItem(orderId);
        for (OrderItem orderItem : orderItems) {
            Product product = orderItem.getProduct();
            product.setBuyCount(Integer.parseInt(orderItem.getNumber()));
            product.setStock(product.getStock() - Integer.parseInt(orderItem.getNumber()));
            productMapper.update(product);
        }
        return new Result(200,"付款成功!");
    }

    /**
     * 确认订单
     *
     * @param orderId 订单ID
     * @return com.wanl.entity.Result
     * @Author YangBin
     * @Date 18:54 2019/3/11
     * @Param [orderId]
     * @version v1.0
     **/
    @Override
    public Result confirm(String orderId) {
        Result orderInfo = getOrderInfo(orderId);
        Order order = (Order)orderInfo.getData();
        if (order == null){
            return new Result(0, "数据有误!", 0, 0);
        }
        order.setStatus(EsmConstant.ORDER_SUCCESS);
        order.setConfirmDate(new Date());
        orderMapper.update(order);
        return new Result(200,"确认成功!");
    }

    /**
     * 获取订单列表
     *
     * @param id 用户ID
     * @return java.util.List<com.wanl.entity.Order>
     * @Author YangBin
     * @Date 11:10 2019/3/14
     * @Param [id]
     * @version v1.0
     **/
    @Override
    public List<Order> orderList(String id) {
        List<Order> orders = orderMapper.getOrderList(id);

        return orders;
    }

    /**
     * 删除订单
     *
     * @param id 订单ID
     * @return com.wanl.entity.Result
     * @Author YangBin
     * @Date 11:25 2019/3/14
     * @Param [id]
     * @version v1.0
     **/
    @Override
    public Result del(String id) {
        Result orderInfo = getOrderInfo(id);
        if (orderInfo.getStatus().intValue() == 0){
            return new Result(0, "数据有误!", 0, 0);
        }
        Order order = (Order)orderInfo.getData();
        for (OrderItem o:order.getOrderItems()) {
            orderMapper.delOrderItem(o.getId());
        }
        Integer row = orderMapper.del(id);
        return new Result(200,"删除成功!");
    }
}
