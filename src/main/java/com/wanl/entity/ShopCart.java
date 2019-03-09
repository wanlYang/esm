package com.wanl.entity;

import java.util.List;

/**
 * 购物车实体类
 * @ClassName: ShopCart
 * @Package:com.wanl.entity
 * @author:YangBin
 * @date:2019/3/7 18:27
 * @version:V1.0
 */
public class ShopCart {

    private Integer id;

    private User user;

    private Product product;

    private Integer amount;

    private String subPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getSubPrice() {
        return subPrice;
    }

    public void setSubPrice(String subPrice) {
        this.subPrice = subPrice;
    }

    @Override
    public String toString() {
        return "ShopCart{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", amount=" + amount +
                ", subPrice='" + subPrice + '\'' +
                '}';
    }
}
