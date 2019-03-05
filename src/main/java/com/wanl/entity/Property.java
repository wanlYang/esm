package com.wanl.entity;

/**
 * 属性实体类
 * @ClassName: Property
 * @Package:com.wanl.entity
 * @author:YangBin
 * @date:2019/3/5 22:50
 * @version:V1.0
 */
public class Property {

    private Integer id;
    private Category category;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                '}';
    }
}
