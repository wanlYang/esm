package com.wanl.service.impl;

import com.wanl.constant.EsmConstant;
import com.wanl.entity.Category;
import com.wanl.mapper.CategoryMapper;
import com.wanl.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 分类服务实现类
 * @ClassName: CategoryServiceImpl
 * @Package:com.wanl.service.impl
 * @author:YangBin
 * @date:2019/2/26 8:41
 * @version:V1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 获取全部分类
     *
     * @return java.util.List<com.wanl.entity.Category>
     * @Author YangBin
     * @Date 8:51 2019/2/26
     * @Param []
     * @version v1.0
     **/
    @Override
    public List<Category> getCateGory() {
        List<Category> categories = categoryMapper.findAll();
        List<Category> categoriesList = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++){
            if (categories.get(i).getParentId() == 0) {
                categoriesList.add(categories.get(i));
            }
        }
        for (Category category:categoriesList) {
            category.setChildren(treeCategory(categories,category.getId()));
        }

        return categoriesList;
    }

    public List<Category> treeCategory(List<Category> categories,Integer parentId){
        List<Category> childCateList = new ArrayList<>();
        Iterator<Category> iterator = categories.iterator();
        while (iterator.hasNext()){
            Category category = (Category)iterator.next();
            if (category.getParentId().intValue() == parentId.intValue()){
                childCateList.add(category);
            }

        }
        for (Category category:childCateList) {

            if (category.getParentId() != 0){
                category.setChildren(treeCategory(categories,category.getId()));
            }
            
        }

        if (childCateList.size() == 0){
            return null;
        }
        return childCateList;
    }

    /**
     * 获取襦裙子分类
     *
     * @return java.util.List<com.wanl.entity.Category>
     * @Author YangBin
     * @Date 23:04 2019/3/4
     * @Param []
     * @version v1.0
     **/
    @Override
    public List<Category> getSkirt() {
        return getCategory(EsmConstant.CATE_SKIRT);
    }

    /**
     * 获取衣裳子分类
     *
     * @return java.util.List<com.wanl.entity.Category>
     * @Author YangBin
     * @Date 23:59 2019/3/4
     * @Param []
     * @version v1.0
     **/
    @Override
    public List<Category> getClothes() {
        return getCategory(EsmConstant.CATE_CLOTHES);
    }
    public List<Category> getCategory(Integer id){
        List<Category> categories = categoryMapper.findAll();
        List<Category> categoriesList = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++){
            if (categories.get(i).getParentId().intValue() == id.intValue()) {
                categoriesList.add(categories.get(i));
            }
        }
        for (Category category:categoriesList) {
            category.setChildren(treeCategory(categories,category.getId()));
        }
        return categoriesList;
    }
}
