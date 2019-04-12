package com.test.microservivce.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        String msg = myEvent.getMsg();
        System.out.println("接收到了实践"+msg+"=="+myEvent.getSource());
    }
}
