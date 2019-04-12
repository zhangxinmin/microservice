package com.test.microservivce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @RequestMapping("/hello")
    public String hello (HttpServletRequest request, HttpServletResponse respongse){
        request.setAttribute("message","hello world");
        System.out.println("访问 /hello");
        return "index";
    }
}
