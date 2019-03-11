package com.wanl.controller;

import com.wanl.constant.EsmConstant;
import com.wanl.entity.*;
import com.wanl.service.AccountService;
import com.wanl.service.OrderService;
import com.wanl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @Autowired
    private AccountService accountService;

    /**
     * 下单
     * @Author YangBin
     * @Date 20:54 2019/3/10
     * @Param [cartId]
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    @RequestMapping(value = "/down",method = RequestMethod.POST)
    @ResponseBody
    public Result orderDown(@RequestBody String[] cartId){

        Result result = orderService.createOrder(cartId);

        return result;
    }

    /**
     * 获取订单对应信息
     * @Author YangBin
     * @Date 20:55 2019/3/10
     * @Param [id]
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView orderDetail(@PathVariable("id") String id, ModelAndView modelAndView, HttpSession session){
        Result result = orderService.getOrderInfo(id);
        User user = (User)session.getAttribute(EsmConstant.USER_SESSION);
        Order order = (Order)result.getData();
        if (result.getStatus().intValue() == EsmConstant.STATUS_OK && user.getId().equals(order.getUser().getId())){
            List<Address> addresses = null;
            modelAndView.setViewName("order_info");
            modelAndView.addObject("order",order);
            if (order.getStatus().intValue() == EsmConstant.ORDER_NOTPAY){
                if (user != null) {
                    addresses = orderService.getAddress(user.getId());
                }
                Account account = accountService.get(user.getId());
                modelAndView.addObject("addresses",addresses);
                modelAndView.addObject("account",account);
            }
            return modelAndView;
        }
        modelAndView.setViewName("order_info");
        modelAndView.addObject("order",result);
        return modelAndView;
    }

    /**
     * 订单付款
     * @Author YangBin
     * @Date 18:53 2019/3/11
     * @Param [address, paymode, orderId, session]
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    @ResponseBody
    public Result pay(String address,String paymode, String orderId,HttpSession session){
        User user = (User)session.getAttribute(EsmConstant.USER_SESSION);
        if (paymode.equals(EsmConstant.PAY_BALANCE)){
            Result result = orderService.payOrder(address,orderId);
            return result;
        }
        return new Result(-1,"数据有误!");
    }

    @RequestMapping(value = "/confirm",method = RequestMethod.POST)
    @ResponseBody
    public Result confirm(String orderId,HttpSession session){
        User user = (User)session.getAttribute(EsmConstant.USER_SESSION);
        Result result = orderService.confirm(orderId);
        return result;
    }
}
