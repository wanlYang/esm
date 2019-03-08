package com.wanl.controller;

import com.wanl.constant.EsmConstant;
import com.wanl.entity.Result;
import com.wanl.entity.ShopCart;
import com.wanl.entity.User;
import com.wanl.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * 购物车控制器
 * @ClassName: ShopCartController
 * @Package:com.wanl.controller
 * @author:YangBin
 * @date:2019/3/07 9:25
 * @version:V1.0
 */
@Controller
@RequestMapping("/shopcart")
public class ShopCartController {

    @Autowired
    private ShopCartService shopCartService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
	public Result addShopCart(String id, String amount, HttpSession session){
        User user = (User)session.getAttribute(EsmConstant.USER_SESSION);
        if (user == null){
            return new Result(-1,"参数异常!",0,0);
        }
        Result result = shopCartService.addShopCart(id, amount, user);
        session.setAttribute("SHOP_CART_PIECE",result.getCount());
        return result;
    }


    @RequestMapping(value = "/piece",method = RequestMethod.GET)
    @ResponseBody
    public Result piece(HttpSession session){
        User user = (User)session.getAttribute(EsmConstant.USER_SESSION);
        if (user == null){
            return new Result(-1,"参数异常!",0,0);
        }
        Result result = shopCartService.getShopCartPiece(user.getId());

        return result;
    }
    
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView shopCart(HttpSession session,ModelAndView modelAndView){
    	modelAndView.setViewName("shopcart");
        return modelAndView;
    }

    @RequestMapping(value = "/list/table",method = RequestMethod.POST)
    @ResponseBody
    public Result shopCartTable(HttpSession session){
        User user = (User)session.getAttribute(EsmConstant.USER_SESSION);
        List<ShopCart> shopCarts = null;
        if (user != null) {
            shopCarts = shopCartService.getShopCartList(user.getId());
        }
        return new Result(200,"获取成功",0,shopCarts);
    }

}
