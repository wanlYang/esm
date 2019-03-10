package com.wanl.controller;

import com.wanl.entity.Result;
import com.wanl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单相关控制器
 * @ClassName: OrderController
 * @Package:com.wanl.controller
 * @author:YangBin
 * @date:2019/3/9 17:06
 * @version:V1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/down",method = RequestMethod.POST)
    @ResponseBody
    public Result orderDown(@RequestBody String[] cartId){

        Result result = orderService.createOrder(cartId);

        return result;
    }
}
