package com.wanl.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * url工具类
 * @ClassName: UrlUtil
 * @Package:com.ic.utils
 * @author:YangBin
 * @date:2018/12/31 19:44
 * @version:V1.0
 */
public class UrlUtil {

    private final static String ENCODE = "UTF-8";

    /**
     * url转码
     * @Author YangBin
     * @Date 19:49 2018/12/31
     * @Param [url]
     * @version v1.0
     * @return java.lang.String
     **/
    public static String getURLEncoderString(String url){
        String result = "";
        if (null == url){
            return "";
        }
        try {
            result = URLEncoder.encode(url, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * url解码
     * @Author YangBin
     * @Date 19:51 2018/12/31
     * @Param [url]
     * @version v1.0
     * @return java.lang.String
     **/
    public static String getURLDecoderString(String url){
        String result = "";
        if (null == url){
            return "";
        }
        try {
            result = URLDecoder.decode(url,ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "https://www.theaic.cn/admin/qq/oauth2/login";
        System.out.println(getURLEncoderString(str));
        System.out.println(getURLDecoderString(str));
    }

}
