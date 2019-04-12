package com.test.microservivce.javaconfig.service;

import org.springframework.stereotype.Service;


public class JavaHelloService {
    public String hello(String name){
        return "hello,"+name;
    }
}
