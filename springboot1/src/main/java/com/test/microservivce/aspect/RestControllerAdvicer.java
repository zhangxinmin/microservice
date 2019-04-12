package com.test.microservivce.aspect;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice  专门拦截 controller
//@ResponseBody
@RestControllerAdvice(basePackages = "com.test.microservivce.controller")  //=  ControllerAdvice+ResponseBody
public class RestControllerAdvicer {
            //处理空指针异常
    /**
     * spring mvc 实现异常处理
     * 1、 注解 RestControllerAdvice  拦截指定 basePackages 下的controller
     * 2、 方法 通过注解  @ExceptionHandler(NullPointerException.class) 实现对不同异常的处理
     * 处理方式优缺点：
     * 优点：全局异常处理，易于理解
     * 缺点：很难完全掌握所有的异常信息
     * @param t
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public Object handleNPE(Throwable t){
                return t.getMessage();
    }

}
