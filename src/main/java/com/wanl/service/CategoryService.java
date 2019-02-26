package com.wanl.service;

import com.wanl.entity.Category;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 分类服务
 * @ClassName: CategoryService
 * @Package:com.wanl.service
 * @author:YangBin
 * @date:2019/2/26 8:40
 * @version:V1.0
 */
public interface CategoryService {

    /**
     * 获取默认分类
     * @Author YangBin
     * @Date 8:51 2019/2/26
     * @Param []
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Category>
     **/
    List<Category> getCateGory();
}
