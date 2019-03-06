package com.wanl.entity;

/**
 * 用户实体
 * @ClassName: User
 * @Package:com.wanl.entity
 * @author:YangBin
 * @date:2019/2/21 17:16
 * @version:V1.0
 */
public class User {

    private String id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String headImg;

    private Integer age;

    private String anonymousName;


    public void setAnonymousName(String anonymousName) {
        this.anonymousName = anonymousName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", headImg='" + headImg + '\'' +
                ", age=" + age +
                '}';
    }
    public String getAnonymousName(){
        if(null==username){
            return null;
        }
        if(username.length()<=1){
            return "*";
        }
        if(username.length()==2){
            return username.substring(0,1) +"*";
        }
        char[] cs =username.toCharArray();
        for (int i = 1; i < cs.length-1; i++) {
            cs[i]='*';
        }
        return new String(cs);

    }
}
