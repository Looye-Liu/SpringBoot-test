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
    public String cathException(HttpServletRequest request, Exception e) {
        return "通用异常";
    }

    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public String cathNullException(HttpServletRequest request, Exception e) {
        return "空指针异常";
    }

}
