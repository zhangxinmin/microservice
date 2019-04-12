package com.test.microservivce.scope;

import com.test.microservivce.annoconfig.controller.HelloController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.test.microservivce.scope")
/**
 * 步骤：
 * 测试 scope  四种 scope
 */
public class ScopeConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        HelloService controller = context.getBean(HelloService.class);
        HelloService controller2 = context.getBean(HelloService.class);
        System.out.println(controller==controller2);

    }
}
