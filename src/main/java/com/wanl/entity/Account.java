package com.wanl.entity;

/**
 * 用户账户实体
 * @ClassName: Account
 * @Package:com.wanl.entity
 * @author:YangBin
 * @date:2019/2/21 18:45
 * @version:V1.0
 */
public class Account {

    private String id;

    private User user;

    private Double balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", balance=" + balance +
                '}';
    }
}
