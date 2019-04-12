package com.test.microservivce.aspect;

import com.test.microservivce.javaconfig.controller.JavaHelloController;
import com.test.microservivce.javaconfig.service.JavaHelloService;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.test.microservivce.aspect")
@EnableAspectJAutoProxy //开启spring 对 aspectJ 支持
public class AspectConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        HelloService controller = context.getBean(HelloService.class);
        System.out.println(controller.hello("zhangsan "));
        System.out.println(controller.hello2("lisi "));

    }

}
