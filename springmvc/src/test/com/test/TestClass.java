package com.test;

import com.test.microservivce.javaconfig.JavaConfig;
import com.test.microservivce.javaconfig.service.JavaHelloService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//SpringJUnit4ClassRunner 在junit环境下提供了 spring testCOntext framework 功能
@RunWith(SpringJUnit4ClassRunner.class)
//ContextConfiguration 加载配置    classes 用来加载配置类
@ContextConfiguration(classes={JavaConfig.class})
public class TestClass {
    @Autowired
    private JavaHelloService javaHelloService;
    @Test
    public void TestHello(){
        String res="hello,zhangsan";
        String actual=javaHelloService.hello("zhangsan");
        Assert.assertEquals(res,actual);
    }
}
