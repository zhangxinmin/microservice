package com.test.microservivce.javaconfig;

import com.test.microservivce.annoconfig.AnnoConfig;
import com.test.microservivce.annoconfig.controller.HelloController;
import com.test.microservivce.javaconfig.controller.JavaHelloController;
import com.test.microservivce.javaconfig.service.JavaHelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class JavaConfig {
    @Bean
    public JavaHelloService javaHelloService(){
        return new JavaHelloService();
    }

//    @Bean
//    public JavaHelloController javaHelloController(JavaHelloService javaHelloService){
//        JavaHelloController javaHelloController=  new JavaHelloController();
//        javaHelloController.setJavaHelloService(javaHelloService);
//        return javaHelloController;
//    }

    @Bean
   // @Profile("prod")  可以使用 profile 指定根据不同的环境生成 不同的实例
    //实际使用的 profile 可以通过jvm 的 spring.pfofiles.active 参数指定  也可以通过 springmvc dispatcherServlet 初始化参数指定
    public JavaHelloController javaHelloController(){
        JavaHelloController javaHelloController=  new JavaHelloController();
        javaHelloController.setJavaHelloService(javaHelloService());
        return javaHelloController;
    }

    /**
     * 使用java 配置实现依赖注入
     *
     * 直接在 配置类中 用注解修饰方法，方法返回对象就是实例    这种 直接在java 类中配置了所以 不需要配置 service Autowired 等注解
     * 一般来说 基础配置如 数据库 等使用 java 配置 业务类依赖注入还是使用 注解
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        JavaHelloController controller = context.getBean(JavaHelloController.class);
        System.out.println(controller.hello("zhangsan "));
    }

}
