package com.wanl.service.impl;

import com.wanl.entity.Category;
import com.wanl.mapper.CategoryMapper;
import com.wanl.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return categories;
    }
}
