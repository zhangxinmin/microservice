package com.test.microservivce.annoconfig.controller;

import com.test.microservivce.annoconfig.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
       @Autowired
    HelloService helloService;

    @RequestMapping("/anno/hello")
    public String hello(String name){
        return helloService.hello(name);
    }

}
