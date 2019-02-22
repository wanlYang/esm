package com.wanl.mapper;

import com.wanl.entity.Account;

/**
 * 账户数据库操作
 * @ClassName: AccountMapper
 * @Package:com.wanl.mapper
 * @author:YangBin
 * @date:2019/2/21 18:52
 * @version:V1.0
 */
public interface AccountMapper {

    /**
     * 创建账户
     * @Author YangBin
     * @Date 18:53 2019/2/21
     * @Param [account]
     * @param account 账户
     * @version v1.0
     * @return java.lang.Integer
     **/
    Integer create(Account account);
}