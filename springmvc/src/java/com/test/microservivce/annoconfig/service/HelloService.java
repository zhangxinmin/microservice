package com.test.microservivce.annoconfig.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String hello(String name){
        return "hello,"+name;
    }
}
