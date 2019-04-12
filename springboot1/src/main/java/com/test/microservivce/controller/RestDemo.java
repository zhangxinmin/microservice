package com.test.microservivce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // =Controller + ResponseBody
public class RestDemo {
    @GetMapping("/tindex")
    public String index (){
        return "<html>hello world</html>";
    }

    //测试抛出异常
    @GetMapping("/npe")
    public String npe (){
        throw new NullPointerException("空指针异常");
    }
}
