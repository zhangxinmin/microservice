package com.test.microservivce.javaconfig.controller;

import com.test.microservivce.javaconfig.service.JavaHelloService;
import org.springframework.stereotype.Controller;

public class JavaHelloController {
    private JavaHelloService javaHelloService;

    public String hello(String name){
        return javaHelloService.hello(name);
    }

    public JavaHelloService getJavaHelloService() {
        return javaHelloService;
    }

    public void setJavaHelloService(JavaHelloService javaHelloService) {
        this.javaHelloService = javaHelloService;
    }
}
