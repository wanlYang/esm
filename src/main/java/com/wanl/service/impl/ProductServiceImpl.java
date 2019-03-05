package com.wanl.service.impl;

import com.wanl.constant.EsmConstant;
import com.wanl.entity.Category;
import com.wanl.entity.Product;
import com.wanl.entity.ProductImage;
import com.wanl.mapper.CategoryMapper;
import com.wanl.mapper.ProductImageMapper;
import com.wanl.mapper.ProductMapper;
import com.wanl.mapper.ReviewMapper;
import com.wanl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 商品实现类
 * @ClassName: ProductServiceImpl
 * @Package:com.wanl.service.impl
 * @author:YangBin
 * @date:2019/2/28 9:30
 * @version:V1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductImageMapper productImageMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ReviewMapper reviewMapper;
    /**
     * 获取爆款商品
     *
     * @return java.util.List<com.wanl.entity.Product>
     * @Author YangBin
     * @Date 8:32 2019/3/1
     * @Param []
     * @version v1.0
     **/
    @Override
    public List<Product> getHotproduct() {
        List<Product> hotProducts = productMapper.findHotProduct();
        setProductImages(hotProducts);
        return hotProducts;
    }

    /**
     * 设置商品第一个图片和商品全部单图
     * @Author YangBin
     * @Date 9:34 2019/3/1
     * @Param [products]
     * @version v1.0
     * @return void
     **/
    public void setProductImages(List<Product> products) {
        for (Product product: products) {
            List<ProductImage> imagesByProductId = productImageMapper.findImagesByProductId(product.getId());
            product.setProductSingleImages(imagesByProductId);
            Random random = new Random();
            int n = random.nextInt(imagesByProductId.size());
            product.setFirstProductImage(imagesByProductId.get(n));
        }
    }

    /**
     * 随机获取襦裙类商品
     *
     * @return java.util.List<com.wanl.entity.Product>
     * @Author YangBin
     * @Date 23:18 2019/3/4
     * @Param []
     * @version v1.0
     **/
    @Override
    public List<Product> getSkirtProduct() {
        return getCateProduct(EsmConstant.CATE_SKIRT, 8);
    }
    public List<Product> getRandom(List<Product> products,int count){
        Random index = new Random();
        //存储已经被调训出来的List 中的 index
        List<Integer> indexList = new ArrayList<>();
        List<Product> newList = new ArrayList<>();
        for(int i=0,j;i<count;i++){
            //获取在 list.size 返回内的随机数
            j = index.nextInt(products.size());
            //判断是否重复
            if(!indexList.contains(j)){
                //获取元素
                indexList.add(j);
                newList.add(products.get(j));
            }else{
                i--;//如果重复再来一次
            }
        }
        return newList;
    }

    /**
     * 随机获取衣裳类商品
     *
     * @return java.util.List<com.wanl.entity.Product>
     * @Author YangBin
     * @Date 0:12 2019/3/5
     * @Param []
     * @version v1.0
     **/
    @Override
    public List<Product> getClothesProduct() {
        return getCateProduct(EsmConstant.CATE_CLOTHES, 8);
    }
    public List<Product> getCateProduct(Integer id,Integer count){
        List<Category> categories = categoryMapper.findCateByParentId(id);
        List<Product> productsAll = new ArrayList<>();
        for (Category category:categories) {
            List<Product> products = productMapper.findProductByCategoryId(category.getId());
            productsAll.addAll(products);
        }
        List<Product> random = getRandom(productsAll, count);
        setProductImages(random);
        return random;
    }

    /**
     * 随机获取鞋靴类商品
     * @Author YangBin
     * @Date 0:12 2019/3/5
     * @Param []
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Product>
     **/
	@Override
	public List<Product> getBootiesProduct() {
		
		return getCateProduct(EsmConstant.CATE_BOOTIES, 8);
	}

    /**
     * 根据ID获取商品
     *
     * @param id 商品ID
     * @return com.wanl.entity.Product
     * @Author YangBin
     * @Date 22:34 2019/3/5
     * @Param [id]
     * @version v1.0
     **/
    @Override
    public Product getProduct(Integer id) {
        Product product = productMapper.findProductById(id);
        List<ProductImage> images = productImageMapper.findImagesByProductId(id);
        product.setProductSingleImages(images);
        product.setFirstProductImage(images.get(0));
        product.setReviewCount(reviewMapper.getCount(id));
        return product;
    }
}
