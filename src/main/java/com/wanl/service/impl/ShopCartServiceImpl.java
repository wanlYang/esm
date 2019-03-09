package com.wanl.service.impl;

import com.wanl.entity.Result;
import com.wanl.entity.ShopCart;
import com.wanl.entity.User;
import com.wanl.mapper.ProductMapper;
import com.wanl.mapper.ShopCartMapper;
import com.wanl.mapper.UserMapper;
import com.wanl.service.ShopCartService;
import com.wanl.utils.RegexUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 实现类
 * @ClassName: ShopCartServiceImpl
 * @Package:com.wanl.service.impl
 * @author:YangBin
 * @date:2019/3/7 19:46
 * @version:V1.0
 */
@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    private ShopCartMapper shopCartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加购物车
     *
     * @param id     商品ID
     * @param amount 数量
     * @return com.wanl.entity.Result
     * @Author YangBin
     * @Date 19:47 2019/3/7
     * @Param [id, amount]
     * @version v1.0
     **/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addShopCart(String id, String amount, User user) {
        if (!StringUtils.isNotBlank(id)&&!StringUtils.isNotBlank(amount)&&!StringUtils.isNotBlank(user.getId())){
            return new Result(-1,"参数错误!",0,0);
        }
        ShopCart shopCart = shopCartMapper.getShopCart(Integer.parseInt(id));
        if (shopCart == null){
            ShopCart newShopCart = new ShopCart();
            newShopCart.setProduct(productMapper.findProductById(Integer.parseInt(id)));
            newShopCart.setUser(userMapper.findUserById(user.getId()));
            newShopCart.setAmount(Integer.parseInt(amount));
            Integer integer = shopCartMapper.addShopCart(newShopCart);
        }else{
            Integer newAmount = shopCart.getAmount();
            shopCart.setAmount(newAmount + Integer.parseInt(amount));
            Integer upInteger = shopCartMapper.updateAmount(shopCart);
        }
        List<ShopCart> shopCarts = shopCartMapper.getShopCarts(user.getId());

        return new Result(200,"添加成功!",shopCarts.size(),shopCarts);
    }

    /**
     * 获取购物车物件
     *
     * @return com.wanl.entity.Result
     * @Author YangBin
     * @Date 20:56 2019/3/7
     * @Param []
     * @param id 用户ID
     * @version v1.0
     **/
    @Override
    public Result getShopCartPiece(String id) {
        Integer piece = shopCartMapper.getShopCartPiece(id);

        return new Result(200,"获取成功!",0,piece);
    }

	@Override
	public List<ShopCart> getShopCartList(String id) {
		User user = userMapper.findUserById(id);
		List<ShopCart> shopCarts = null;
		if (user != null) {
			shopCarts = shopCartMapper.getShopCarts(id);
		}
		return shopCarts;
	}

    /**
     * 修改数量
     *
     * @param id     ID
     * @param amount 数量
     * @return java.lang.Integer
     * @Author YangBin
     * @Date 15:45 2019/3/9
     * @Param [id, amount]
     * @version v1.0
     **/
    @Override
    public Result updateAmount(String id, String amount) {
        ShopCart shopCart = shopCartMapper.getShopCartById(Integer.parseInt(id));
        if (!RegexUtils.isTwoNumber(amount)){
            return new Result(-1,"请输入1~99之间数值!",0,shopCart);
        }
        shopCart.setAmount(Integer.parseInt(amount));
        Integer integer = shopCartMapper.updateAmount(shopCart);
        if (integer.intValue() <= 0){
            return new Result(-2,"数据出错!",0,shopCart);
        }
        shopCart.setSubPrice(String.valueOf(shopCart.getAmount()*Double.parseDouble(shopCart.getProduct().getPrice())));
        return new Result(200,"修改成功!",0,shopCart);
    }

    /**
     * 从购物车删除商品
     *
     * @param id id
     * @return com.wanl.entity.Result
     * @Author YangBin
     * @Date 16:27 2019/3/9
     * @Param [id]
     * @version v1.0
     **/
    @Override
    public Result delProduct(String id) {
        if (!StringUtils.isNotBlank(id)){
            return new Result(-2,"数据出错!",0,0);
        }
        Integer row = shopCartMapper.del(id);
        if (row <= 0){
            return new Result(-2,"删除失败!",0,0);
        }
        return new Result(200,"删除成功!",0,0);
    }

    /**
     * 清空购物车
     *
     * @param id 用户ID
     * @return com.wanl.entity.Result
     * @Author YangBin
     * @Date 16:33 2019/3/9
     * @Param [id]
     * @version v1.0
     **/
    @Override
    public Result clear(String id) {
        if (!StringUtils.isNotBlank(id)){
            return new Result(-2,"删除失败!",0,0);
        }
        User user = userMapper.findUserById(id);
        Integer integer = shopCartMapper.clear(user.getId());
        if (integer <= 0){
            return new Result(-2,"删除失败!",0,0);
        }
        return new Result(200,"删除成功!",0,0);
    }
}
