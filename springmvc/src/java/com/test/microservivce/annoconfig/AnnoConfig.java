package com.test.microservivce.annoconfig;

import com.test.microservivce.annoconfig.controller.HelloController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.test.microservivce.annoconfig.*")
//测试使用注解配置 依赖注入
/**
 * 步骤：
 * 1、bean 中增加依赖关系注解 autowired 和 service
 * 2、配置类 Configuration   @ComponentScan注解 配置扫描的 包  将包下配置的 bean 初始化并注入
 * 3、适应配置初始化  AnnotationConfigApplicationContext 获取实例
 */
public class AnnoConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(AnnoConfig.class);
        HelloController controller = context.getBean(HelloController.class);
        System.out.println(controller.hello("zhangsan "));
    }
}
