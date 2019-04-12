package com.test.microservivce.aspect;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @Action(name="hello操作")
    public String hello(String name){
        return "hello,"+name;
    }

    public String hello2(String name){
        return "hello2,"+name;
    }
}
