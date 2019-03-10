package com.wanl.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;

/**
 * 订单项
 * @ClassName: OrderItem
 * @Package:com.wanl.entity
 * @author:YangBin
 * @date:2019/3/10 14:20
 * @version:V1.0
 */

public class OrderItem implements Serializable {

    private int id;

    private Product product;

    private Order order;

    private User user;

    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", product=" + product +
                ", order=" + order +
                ", user=" + user +
                ", number='" + number + '\'' +
                '}';
    }
}
