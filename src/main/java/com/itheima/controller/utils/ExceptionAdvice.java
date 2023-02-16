package com.itheima.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * SpringMVC的异常处理器
 */
@RestControllerAdvice
public class ExceptionAdvice {
    /**
     * 添加@ExceptionHandler注解
     * 用于拦截所有的异常信息
     */
    @ExceptionHandler(Exception.class)
    public R doException(Exception e) {
        //记录日志
        //通知运维
        //通知开发
        e.printStackTrace();
        return R.fail("服务器故障，请稍微再试。");
    }
}
