package com.wanl.entity;

/**
 * 属性值实体类
 * @ClassName: PropertyValue
 * @Package:com.wanl.entity
 * @author:YangBin
 * @date:2019/3/5 22:48
 * @version:V1.0
 */
public class PropertyValue {

    private Integer id;
    private Product product;
    private Property property;
    private String value;

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

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PropertyValue{" +
                "id=" + id +
                ", product=" + product +
                ", property=" + property +
                ", value='" + value + '\'' +
                '}';
    }
}
