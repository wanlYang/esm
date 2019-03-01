package com.wanl.controller;

import com.wanl.entity.Product;
import com.wanl.entity.Result;
import com.wanl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 首页控制器
 * @ClassName: IndexController
 * @Package:com.wanl.controller
 * @author:YangBin
 * @date:2019/2/23 10:58
 * @version:V1.0
 */
@Controller
public class IndexController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/index/hot/product")
    @ResponseBody
    public Result getHotProduct(){
        List<Product> products = productService.getHotproduct();
        Result result = new Result();
        result.setMessage("获取成功!");
        result.setStatus(200);
        result.setCount(0);
        result.setData(products);
        return result;
    }

}
