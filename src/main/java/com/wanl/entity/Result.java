package com.wanl.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Title: Result.java
 * @Package:com.wanl.entity
 * @Description:(前后台互交)
 * @author:YangBin
 * @date:2019年2月21日
 * @version:V1.0
 */
public class Result {

    private Integer status;

    private String message;

    private Integer count;

    private Object data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result() {
        super();
    }

    public static String failed() {
        return failed("解析失败");
    }

    public static String failed(String msg) {
        return failed(-1, msg);
    }

    public static String failed(Integer code, String msg) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String resultJson = gson.toJson(new Result(code, msg, 0, null));
        return resultJson;
    }

    @Override
    public String toString() {
        return "Result [status=" + status + ", message=" + message + ", count=" + count + ", data=" + data + "]";
    }

    public Result(Integer status, String message, Integer count, Object data) {
        super();
        this.status = status;
        this.message = message;
        this.count = count;
        this.data = data;
    }

}
