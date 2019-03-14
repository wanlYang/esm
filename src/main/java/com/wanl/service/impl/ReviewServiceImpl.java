package com.wanl.service.impl;

import com.wanl.entity.Review;
import com.wanl.mapper.ProductMapper;
import com.wanl.mapper.ReviewMapper;
import com.wanl.mapper.UserMapper;
import com.wanl.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 实现类
 * @ClassName: ReviewServiceImpl
 * @Package:com.wanl.service.impl
 * @author:YangBin
 * @date:2019/3/5 23:29
 * @version:V1.0
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据商品ID获取对应评论信息
     *
     * @param id ID
     * @return java.util.List<com.wanl.entity.Review>
     * @Author YangBin
     * @Date 23:32 2019/3/5
     * @Param [id]
     * @version v1.0
     **/
    @Override
    public List<Review> getReviews(Integer id) {
        List<Review> reviews = reviewMapper.findReviewList(id);
        if (reviews != null){
            for (Review review:reviews) {
                String anonymousName = review.getUser().getAnonymousName();
                review.getUser().setAnonymousName(anonymousName);
            }
        }
        return reviews;
    }

    /**
     * 评论
     *
     * @param productId 商品ID
     * @param content   内容
     * @return java.lang.Integer
     * @Author YangBin
     * @Date 13:06 2019/3/14
     * @Param [productId, content]
     * @version v1.0
     **/
    @Override
    @CacheEvict(value="product_detail",key="#root.args[0]")
    public Integer review(String productId, String content,String userId) {
        Review review = new Review();
        review.setContent(content);
        review.setProduct(productMapper.findProductById(Integer.parseInt(productId)));
        review.setTime(new Date());
        review.setUser(userMapper.findUserById(userId));
        Integer row = reviewMapper.insert(review);
        return row;
    }
}
