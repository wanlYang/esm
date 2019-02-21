package com.wanl.constant;

/**
 * Esm System Constant(系统常量)
 *
 * @author Yang
 */
public interface EsmConstant {

    /**
     * 开发模式
     */
    boolean DEVELOPMENT_MODEL = true;
    /**
     * 非开发模式
     */
    boolean NOT_DEVELOPMENT_MODEL = false;

    /**
     * (用户)未激活
     */
    Integer USER_STATE_NOTACTIVE = 0;
    /**
     * (用户)已激活
     */
    Integer USER_STATE_ACTIVE = 1;
    /**
     * (用户)是否自动登录
     */
    String SAVE_NAMEPASS = "TRUE";

    /**
     * 超级管理员
     */
    String ROLE_SUPER_ADMIN = "ROLE_SUPER_ADMIN";

    /**
     * 管理员
     */
    String ROLE_ADMIN = "ROLE_ADMIN";

    /**
     * 用户
     */
    String ROLE_USER = "ROLE_USER";

    /**
     * (商品)热门
     */
    Integer IS_HOT_PRODUCT = 1;
    /**
     * (商品)非热门
     */
    Integer IS_NOT_HOT_PRODUCT = 0;
    /**
     * (商品)上架
     */
    Integer IS_UP = 1;
    /**
     * (商品)下架
     */
    Integer IS_DOWN = 0;

    /**
     * (订单)未付款
     */
    Integer ORDER_NOTPAY = 0;
    /**
     * (订单)已付款
     */
    Integer ORDER_PAY = 1;
    /**
     * (订单)待发货
     */
    Integer ORDER_TO_BE_SHIPPED = 2;
    /**
     * (订单)已发货
     */
    Integer ORDER_SHIPPED = 3;
    /**
     * (订单)已完成
     */
    Integer ORDER_SUCCESS = 4;

    /**
     * spring security SPRING_SECURITY_CONTEXT
     */
    String SPRING_SECURITY_CONTEXT = "SPRING_SECURITY_CONTEXT";

    /**
     * 其他常量
     */
    String X_REQUEST_WITH = "X-Requested-With";

    String XML_HTTP_REQUEST = "XMLHttpRequest";

    String REQUEST_METHOD_POST = "POST";
    String REQUEST_METHOD_GET = "GET";

    String UTF_8 = "UTF-8";

    String CONTENT_TYPE_APP_JSON_UTF_8 = "application/json;charset=utf-8";
    String CONTENT_TYPR_TEXT_HTML_UTF_8 = "text/html;charset=utf-8";

    String SEND_CODE_SUCCESS = "00000";

    String SMS_CODE = "smsCode";
    String TEMP_PHONE = "TEMP_PHONE";

    String DEFAUTL_HEAD_IMG = "DEFAUTL_HEAD_IMG";
}