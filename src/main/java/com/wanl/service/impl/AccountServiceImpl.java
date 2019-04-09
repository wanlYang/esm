package com.wanl.service.impl;

import com.wanl.entity.Account;
import com.wanl.entity.User;
import com.wanl.mapper.AccountMapper;
import com.wanl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账户服务实现类
 * @ClassName: AccountServiceImpl
 * @Package:com.wanl.service.impl
 * @author:YangBin
 * @date:2019/2/21 18:50
 * @version:V1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    

    /**
     * 创建账户
     *
     * @param account 账户
     * @return java.lang.Integer
     * @Author YangBin
     * @Date 18:51 2019/2/21
     * @Param [account]
     * @version v1.0
     **/
    @Override
    public Integer create(Account account) {
        boolean condition = (account != null);
        if (!condition){
            return 0;
        }
        return accountMapper.create(account);
    }

    /**
     * 获取用户余额
     *
     * @param id ID 用户
     * @return com.wanl.entity.Account
     * @Author YangBin
     * @Date 22:18 2019/3/10
     * @Param [id]
     * @version v1.0
     **/
    @Override
    public Account get(String id) {

        Account account = accountMapper.get(id);
        return account;
    }

    /**
     * 账户充值
     *
     * @param user  用户
     * @param money 金额
     * @return java.lang.Integer
     * @Author YangBin
     * @Date 19:11 2019/4/9
     * @Param [user, money]
     * @version v1.0
     **/
    @Override
    public Integer recharge(User user, Double money) {
        Account account = accountMapper.get(user.getId());
        account.setBalance(account.getBalance() + money);
        Integer update = accountMapper.update(account);

        return update;
    }
}
