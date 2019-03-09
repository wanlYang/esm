package com.wanl.controller;

import com.wanl.constant.EsmConstant;
import com.wanl.entity.Result;
import com.wanl.entity.ShopCart;
import com.wanl.entity.User;
import com.wanl.service.ShopCartService;
import com.wanl.utils.RegexUtils;
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

    /**
     * 添加购物车
     * @Author YangBin
     * @Date 15:31 2019/3/9
     * @Param [id, amount, session]
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
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


    /**
     * 获取购物车件数
     * @Author YangBin
     * @Date 15:31 2019/3/9
     * @Param [session]
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
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

    /**
     * 购物车视图
     * @Author YangBin
     * @Date 15:32 2019/3/9
     * @Param [session, modelAndView]
     * @version v1.0
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView shopCart(HttpSession session,ModelAndView modelAndView){
    	modelAndView.setViewName("shopcart");
        return modelAndView;
    }

    /**
     * 购物车列表
     * @Author YangBin
     * @Date 15:32 2019/3/9
     * @Param [session]
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
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

    /**
     * 修改购物车数量
     * @Author YangBin
     * @Date 15:36 2019/3/9
     * @Param [session]
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    @RequestMapping(value = "/change/amount",method = RequestMethod.POST)
    @ResponseBody
    public Result changeAmount(String id,String amount){

        Result result = shopCartService.updateAmount(id,amount);

        return result;
    }

    /**
     * 从购车删除商品
     * @Author YangBin
     * @Date 16:27 2019/3/9
     * @Param [id]
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    @RequestMapping(value = "/del/product",method = RequestMethod.POST)
    @ResponseBody
    public Result delProduct(String id,HttpSession session){
        User user = (User)session.getAttribute(EsmConstant.USER_SESSION);
        if (user == null) {
            return new Result(-2,"删除失败!",0,0);
        }
        Result result = shopCartService.delProduct(id);
        Result shopCartPiece = shopCartService.getShopCartPiece(user.getId());
        session.setAttribute("SHOP_CART_PIECE",shopCartPiece.getData());
        return result;
    }

    /**
     * 清空购物车
     * @Author YangBin
     * @Date 16:46 2019/3/9
     * @Param [session]
     * @version v1.0
     * @return com.wanl.entity.Result
     **/
    @RequestMapping(value = "/clear",method = RequestMethod.POST)
    @ResponseBody
    public Result clear(HttpSession session){
        User user = (User)session.getAttribute(EsmConstant.USER_SESSION);
        if (user == null) {
            return new Result(-2,"删除失败!",0,0);
        }
        Result result = shopCartService.clear(user.getId());
        Result shopCartPiece = shopCartService.getShopCartPiece(user.getId());
        session.setAttribute("SHOP_CART_PIECE",shopCartPiece.getData());
        return result;
    }
}
