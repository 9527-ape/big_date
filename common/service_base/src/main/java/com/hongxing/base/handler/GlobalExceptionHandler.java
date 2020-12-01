package com.hongxing.base.handler;

import com.hongxing.commonutils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title: GlobalExceptionHandler.java
 * Description: 统一异常处理类
 * Copyright: Copyright (c) 2020
 * @author jsj
 * @date 2020.11.30
 */
//Spring3.2提供的新注解,它是一个Controller增强器,可对controller中被 @RequestMapping注解的方法加一些逻辑处理。最常用的就是异常处理
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//指定出现什么异常会执行以下方法
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("运行结果飞到了火星.......");
    }

    /**
     * 可设置特定异常
     */



}
