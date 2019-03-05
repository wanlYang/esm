package com.wanl.controller;

import com.wanl.entity.Product;
import com.wanl.entity.PropertyValue;
import com.wanl.entity.Result;
import com.wanl.entity.Review;
import com.wanl.service.ProductService;
import com.wanl.service.PropertyValueService;
import com.wanl.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品请求控制器
 * @ClassName: ProductController
 * @Package:com.wanl.controller
 * @author:YangBin
 * @date:2019/2/28 9:25
 * @version:V1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PropertyValueService propertyValueService;

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable("id") Integer id, ModelAndView modelAndView){

        Product product = productService.getProduct(id);

        List<PropertyValue> propertyValue = propertyValueService.getPropertyValue(id);

        List<Review> reviews = reviewService.getReviews(id);

        return modelAndView;
    }

}
