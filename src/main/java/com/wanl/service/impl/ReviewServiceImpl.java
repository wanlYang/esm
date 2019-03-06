package com.wanl.service.impl;

import com.wanl.entity.Review;
import com.wanl.mapper.ReviewMapper;
import com.wanl.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
