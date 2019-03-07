package com.wanl.entity;

import java.io.Serializable;

/**
 * 商品图片实体类
 * @ClassName: ProductImage
 * @Package:com.wanl.entity
 * @author:YangBin
 * @date:2019/2/28 9:39
 * @version:V1.0
 */
public class ProductImage implements Serializable{

    private Integer id;

    private Product product;

    private String img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", product=" + product +
                ", img='" + img + '\'' +
                '}';
    }
}
