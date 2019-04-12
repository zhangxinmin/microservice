package com.test.microservivce.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MyTask {
    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
@Scheduled(fixedRate = 5000)
    public void computeData(){
       System.out.println("task执行时间" +format.format(new Date()));

    }
}
