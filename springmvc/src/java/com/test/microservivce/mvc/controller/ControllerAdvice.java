package com.test.microservivce.mvc.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebResult;

@org.springframework.web.bind.annotation.ControllerAdvice
@ComponentScan(basePackages = "com.test.microservivce.mvc.controller")
public class ControllerAdvice {

    @ModelAttribute
    public void addAttr(Model model){
        //添加属性到全局所有注解有 @RequestMapping 的方法都可以访问到这个属性msg   方法参数上添加注解 @ModelAttribute("msg") 来获取
        model.addAttribute("msg","额外信息");
    }
    @InitBinder
    public void initBinder(WebDataBinder binder){
        //配置忽略属性id
        binder.setDisallowedFields("id");
    }

    //处理异常信息 有异常时 跳转到 error.jsp
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView view = new ModelAndView("error");
        view.addObject("errorMsg",exception.getMessage());
        return view ;
    }


}
