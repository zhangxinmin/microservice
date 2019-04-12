package com.test.microservivce.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class HelloService {
    public String hello(String name){
        return "hello,"+name;
    }
}
