package com.wanl.entity;

import java.util.Date;

/**
 * 商品评论实体类
 * @ClassName: Review
 * @Package:com.wanl.entity
 * @author:YangBin
 * @date:2019/2/28 9:44
 * @version:V1.0
 */
public class Review {

    private Integer id;

    private User user;

    private Product product;

    private String content;

    private Date time;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
