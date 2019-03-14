package com.wanl.controller;

import com.wanl.constant.EsmConstant;
import com.wanl.entity.Product;
import com.wanl.entity.Result;
import com.wanl.entity.User;
import com.wanl.service.ProductService;
import com.wanl.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 评论控制器
 *
 * @ClassName: ReviewController
 * @Package:com.wanl.controller
 * @author:YangBin
 * @date:2019/3/14 12:02
 * @version:V1.0
 */
@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView orderDetail(@PathVariable("id") String id, ModelAndView modelAndView, HttpSession session) {
        Product product = productService.getProduct(Integer.parseInt(id));
        modelAndView.setViewName("product_review");
        modelAndView.addObject("product", product);

        return modelAndView;
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public Result submit(String productId, String content, HttpSession session) {
        User user = (User)session.getAttribute(EsmConstant.USER_SESSION);
        Integer review = reviewService.review(productId, content, user.getId());
        if (review.intValue() <= 0){
            return new Result(-1,"数据有误!");
        }
        return new Result(200,"评论成功!",0,productId);
    }

}
