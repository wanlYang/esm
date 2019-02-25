package com.wanl.controller.handlerex;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanl.entity.Result;

/**
 * @Title: EsmHandlerException.java
 * @Package:com.wanl.controller.handlerex
 * @Description:(处理简单异常)
 * @author:YangBin
 * @date:2018年12月24日
 * @version:V1.0
 */
@ControllerAdvice
@ResponseBody
public class EsmExceptionHandler {

    private static final String LOGEXCEPTIONFORMAT = "Capture Exception By ImunityHandlerException: Code: %s Detail: %s";
    private static Logger logger = LogManager.getLogger(EsmExceptionHandler.class.getName());

    /**
     * @Description:(运行时异常)
     * @param:@param ex
     * @param:@return
     * @return:ModelAndView
     * @author:YangBin
     * @date:2018年12月24日
     * @version:V1.0
     */
    @ExceptionHandler(RuntimeException.class)
    public String noHandlerFound(RuntimeException ex) {
        return resultFormat(-1001, ex);
    }

    /**
     * @param ex
     * @return
     * @Description:(空指针)
     * @author:YangBin
     * @date:2018年12月25日
     * @version:V1.0
     * @return:String
     */
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException ex) {
        return resultFormat(-2001, ex);
    }

    /**
     * @param ex
     * @return
     * @Description:(类型转换异常)
     * @author:YangBin
     * @date:2018年12月25日
     * @version:V1.0
     * @return:String
     */
    @ExceptionHandler(ClassCastException.class)
    public String classCastExceptionHandler(ClassCastException ex) {
        return resultFormat(-3001, ex);
    }

    /**
     * @param ex
     * @return
     * @Description:(IO异常)
     * @author:YangBin
     * @date:2018年12月25日
     * @version:V1.0
     * @return:String
     */
    @ExceptionHandler(IOException.class)
    public String iOExceptionHandler(IOException ex) {
        return resultFormat(-4001, ex);
    }

    /**
     * @param ex
     * @return
     * @Description:(未知方法异常)
     * @author:YangBin
     * @date:2018年12月25日
     * @version:V1.0
     * @return:String
     */
    @ExceptionHandler(NoSuchMethodException.class)
    public String noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return resultFormat(-5001, ex);
    }

    /**
     * @param ex
     * @return
     * @Description:(数组越界异常)
     * @author:YangBin
     * @date:2018年12月25日
     * @version:V1.0
     * @return:String
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public String indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return resultFormat(-6001, ex);
    }

    /**
     * @param ex
     * @return
     * @Description:(404异常)
     * @author:YangBin
     * @date:2018年12月25日
     * @version:V1.0
     * @return:String
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public String requestNotReadable(HttpMessageNotReadableException ex) {
        return resultFormat(-7001, ex);
    }

    /**
     * @param ex
     * @return
     * @Description:(400)
     * @author:YangBin
     * @date:2018年12月25日
     * @version:V1.0
     * @return:String
     */
    @ExceptionHandler({TypeMismatchException.class})
    public String requestTypeMismatch(TypeMismatchException ex) {
        return resultFormat(-8001, ex);
    }

    /**
     * @param ex
     * @return
     * @Description:(400)
     * @author:YangBin
     * @date:2018年12月25日
     * @version:V1.0
     * @return:String
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public String requestMissingServletRequest(MissingServletRequestParameterException ex) {
        return resultFormat(-9001, ex);
    }

    /**
     * @param ex
     * @return
     * @Description:(405)
     * @author:YangBin
     * @date:2018年12月25日
     * @version:V1.0
     * @return:String
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public String request405(HttpRequestMethodNotSupportedException ex) {
        return resultFormat(-10002, ex);
    }

    /**
     * @param ex
     * @return
     * @Description:(500)
     * @author:YangBin
     * @date:2018年12月25日
     * @version:V1.0
     * @return:String
     */
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public String request406(HttpMediaTypeNotAcceptableException ex) {
        return resultFormat(-1100, ex);
    }

    /**
     * @param ex
     * @return
     * @Description:(500)
     * @author:YangBin
     * @date:2018年12月25日
     * @version:V1.0
     * @return:String
     */
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public String server500(RuntimeException ex) {
        return resultFormat(-12001, ex);
    }

    /**
     * @param ex
     * @return
     * @Description:(栈溢出)
     * @author:YangBin
     * @date:2018年12月25日
     * @version:V1.0
     * @return:String
     */
    @ExceptionHandler({StackOverflowError.class})
    public String requestStackOverflow(StackOverflowError ex) {
        return resultFormat(-13001, ex);
    }

    /**
     * @param ex
     * @return
     * @Description:(其他错误)
     * @author:YangBin
     * @date:2018年12月25日
     * @version:V1.0
     * @return:String
     */
    @ExceptionHandler({Exception.class})
    public String exception(Exception ex) {
        return resultFormat(-14001, ex);
    }

    /**
     * @param code
     * @param ex
     * @return
     * @Description:(异常信息格式化)
     * @author:YangBin
     * @date:2018年12月25日
     * @version:V1.0
     * @return:String
     */
    private <T extends Throwable> String resultFormat(Integer code, T ex) {
        ex.printStackTrace();
        logger.error(String.format(LOGEXCEPTIONFORMAT, code, ex.getMessage()));
        return Result.failed(code, ex.getMessage());
    }

}
