package com.wanl.controller;

import com.wanl.entity.Product;
import com.wanl.entity.PropertyValue;
import com.wanl.entity.Result;
import com.wanl.entity.Review;
import com.wanl.service.ProductService;
import com.wanl.service.PropertyValueService;
import com.wanl.service.ReviewService;
import com.wanl.utils.RegexUtils;

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
    public ModelAndView detail(@PathVariable("id") String id, ModelAndView modelAndView){
    	if(!RegexUtils.isNumber(id)) {
    		modelAndView.setViewName("redirect:/");
    		return modelAndView;
    	}
    	int parseInt = Integer.parseInt(id);
        Product product = productService.getProduct(parseInt);

        List<PropertyValue> propertyValues = propertyValueService.getPropertyValue(parseInt);

        List<Review> reviews = reviewService.getReviews(parseInt);
        modelAndView.setViewName("item_show");
        modelAndView.addObject("product", product);
        modelAndView.addObject("propertyValues", propertyValues);
        modelAndView.addObject("reviews", reviews);
        return modelAndView;
    }

    @RequestMapping(value = "/recommend",method = RequestMethod.POST)
    @ResponseBody
    public Result getSkirtProduct(String id){
    	if(!RegexUtils.isNumber(id)) {
    		return new Result(-1, "参数异常!");
    	}
        List<Product> products = productService.getRecommendProduct(Integer.parseInt(id));
        Result result = new Result();
        result.setMessage("获取成功!");
        result.setStatus(200);
        result.setCount(products.size());
        result.setData(products);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

}
