package com.liuyi.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by looye on 2017/11/15.
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String cathcException(HttpServletRequest request, Exception e) {
        return "对不起，服务器繁忙，请稍后再试";
    }

}
