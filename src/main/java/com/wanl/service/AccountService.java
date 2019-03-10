package com.wanl.service;

import com.wanl.entity.Account;

/**
 * 账户服务
 * @ClassName: AccountService
 * @Package:com.wanl.service
 * @author:YangBin
 * @date:2019/2/21 18:49
 * @version:V1.0
 */
public interface AccountService {

    /**
     * 创建账户
     * @Author YangBin
     * @Date 18:51 2019/2/21
     * @Param [account]
     * @param account 账户
     * @version v1.0
     * @return java.lang.Integer
     **/
    Integer create(Account account);

    /**
     * 获取用户余额
     * @Author YangBin
     * @Date 22:18 2019/3/10
     * @Param [id]
     * @param id ID 用户
     * @version v1.0
     * @return com.wanl.entity.Account
     **/
    Account get(String id);
}
