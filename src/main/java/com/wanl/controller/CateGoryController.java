package com.wanl.controller;

import com.wanl.entity.Category;
import com.wanl.entity.Result;
import com.wanl.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类
 * @ClassName: CateGoryController
 * @Package:com.wanl.controller
 * @author:YangBin
 * @date:2019/2/26 8:23
 * @version:V1.0
 */
@Controller
@RequestMapping("/category")
public class CateGoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Result getCateGory(){

        List<Category> categories = categoryService.getCateGory();

        return new Result(200,"获取成功!",0,categories);
    }

}
