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
        Order order = (Order)result.getData();
        if (result.getStatus().intValue() == EsmConstant.STATUS_OK){
            List<Address> addresses = null;
            modelAndView.setViewName("order_info");
            modelAndView.addObject("order",(Order)result.getData());
            if (order.getStatus().intValue() == EsmConstant.ORDER_NOTPAY){
                User user = (User)session.getAttribute(EsmConstant.USER_SESSION);
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
}
