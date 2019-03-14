package com.wanl.mapper;

import com.wanl.entity.Review;

import java.util.List;

/**
 * 评论mapper
 * @ClassName: ReviewMapper
 * @Package:com.wanl.mapper
 * @author:YangBin
 * @date:2019/3/5 23:19
 * @version:V1.0
 */
public interface ReviewMapper {

    /**
     * 根据商品ID获取商品评论数量
     * @Author YangBin
     * @Date 23:22 2019/3/5
     * @Param [id]
     * @param id
     * @version v1.0
     * @return java.lang.Integer
     **/
    public Integer getCount(Integer id);

    /**
     * 根据商品ID获取对应评论
     * @Author YangBin
     * @Date 23:34 2019/3/5
     * @Param [id]
     * @param id ID
     * @version v1.0
     * @return java.util.List<com.wanl.entity.Review>
     **/
    List<Review> findReviewList(Integer id);

    /**
     * 插入
     * @Author YangBin
     * @Date 13:10 2019/3/14
     * @Param [review]
     * @param review 评论
     * @version v1.0
     * @return java.lang.Integer
     **/
    Integer insert(Review review);
}
