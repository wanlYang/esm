package com.wanl.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品实体类
 * @ClassName: Product
 * @Package:com.wanl.entity
 * @author:YangBin
 * @date:2019/2/28 9:31
 * @version:V1.0
 */
public class Product implements Serializable{

    /**
     * 商品ID
     */
    private Integer id;

    private Category category;

    private String mainTitle;

    private String subTitle;

    private String price;

    private String oldPrice;

    private Integer buyCount;

    private String img;

    private String detail;

    private Integer status;

    private Integer isHot;

    private Integer stock;

    private Date shelfTime;

    private ProductImage firstProductImage;

    private List<ProductImage> productSingleImages;

    private Integer reviewCount;

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(Date shelfTime) {
        this.shelfTime = shelfTime;
    }

    public ProductImage getFirstProductImage() {
        return firstProductImage;
    }

    public void setFirstProductImage(ProductImage firstProductImage) {
        this.firstProductImage = firstProductImage;
    }

    public List<ProductImage> getProductSingleImages() {
        return productSingleImages;
    }

    public void setProductSingleImages(List<ProductImage> productSingleImages) {
        this.productSingleImages = productSingleImages;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category=" + category +
                ", mainTitle='" + mainTitle + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", price='" + price + '\'' +
                ", oldPrice='" + oldPrice + '\'' +
                ", buyCount=" + buyCount +
                ", img='" + img + '\'' +
                ", detail='" + detail + '\'' +
                ", status=" + status +
                ", isHot=" + isHot +
                ", stock=" + stock +
                ", shelfTime=" + shelfTime +
                ", firstProductImage=" + firstProductImage +
                ", productSingleImages=" + productSingleImages +
                ", reviewCount=" + reviewCount +
                '}';
    }
}
