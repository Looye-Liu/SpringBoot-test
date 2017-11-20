package com.liuyi.config;

import com.liuyi.exception.MyException;
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
    @ExceptionHandler(MyException.class)
    public String catchMyException() {
        return "自定义异常类";
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String catchException(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return "通用异常";
    }

    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public String catchNullException(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return "空指针异常";
    }

}
