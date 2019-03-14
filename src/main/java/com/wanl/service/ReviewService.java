package com.wanl.service;

import com.wanl.entity.Review;

import java.util.List;

/**
 * 商品评论
 * @ClassName: ReviewService
 * @Package:com.wanl.service
 * @author:YangBin
 * @date:2019/3/5 23:28
 * @version:V1.0
 */
public interface ReviewService {

    /**
     * 根据商品ID获取对应评论信息
     * @Author YangBin
     * @Date 23:32 2019/3/5
     * @Param [id]
     * @param id ID
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Review>
     **/
    public List<Review> getReviews(Integer id);

    /**
     * 评论
     * @Author YangBin
     * @Date 13:06 2019/3/14
     * @Param [productId, content, userId]
     * @param productId 商品ID
     * @param content 内容
     * @param userId 用户ID
     * @version v1.0
     * @return java.lang.Integer
     **/
    Integer review(String productId, String content,String userId);
}
