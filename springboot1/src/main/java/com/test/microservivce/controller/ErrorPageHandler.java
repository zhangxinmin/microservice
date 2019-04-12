package com.test.microservivce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController // =Controller + ResponseBody
public class ErrorPageHandler {

/*
* spring boot 异常处理方式
* 1  实现 ErrorPageRegistrar 接口
* 2、实现接口方法注册  异常处理地址  registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
* 3、实现 异常地址
*
* 优点：
*
* 缺点： 处理地址必须固定
* */
    //处理界面找不到的情况
    @GetMapping("/404.html")
    public Object pageNotFound(HttpStatus status, HttpServletRequest request, HttpServletResponse respongse){
        // return t.getMessage();
        Map<String,Object> errors = new HashMap<>();
        errors.put("status_code",request.getAttribute("javax.servlet.error.status_code"));
        errors.put("request_uri",request.getAttribute("javax.servlet.error.request_uri"));
        return errors;
    }



}
