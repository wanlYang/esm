package com.wanl.entity;

import java.util.List;

/**
 * 分类实体类
 * @ClassName: Category
 * @Package:com.wanl.entity
 * @author:YangBin
 * @date:2019/2/26 8:28
 * @version:V1.0
 */
public class Category {

    /**
     * ID
     */
    private Integer id;

    /**
     * 父ID
     */
    private Integer parentId;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否显示
     */
    private Integer display;

    /**
     * 子分类
     */
    private List<Category> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", display=" + display +
                ", children=" + children +
                '}';
    }
}
