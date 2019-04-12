package com.test.microservivce.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class publisher {
    @Autowired
    ApplicationContext context;
    public void pub(){
        context.publishEvent(new MyEvent(this,"你好啊"));
    }
}
