package com.test.microservivce.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "com.test.microservivce.el")
@PropertySource("classpath:com/test/microservivce/el/test.properties")
public class ElConfig {
    @Value("hello")
    private String normal;
    @Value("#{systemProperties['os.name']}")
    private String osName;
    @Value("#{T(java.lang.Math).random()*100}")
    private double randomNumber;
    @Value("#{proBean.name}")
    private String beanPro;

    @Value("${name}")
    private String proname;

    public static PropertySourcesPlaceholderConfigurer properties(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public String toString() {
        return "ElConfig{" +
                "normal='" + normal + '\'' +
                ", osName='" + osName + '\'' +
                ", randomNumber=" + randomNumber +
                ", beanPro='" + beanPro + '\'' +
                ", proname='" + proname + '\'' +
                '}';
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig config=context.getBean(ElConfig.class);
        System.out.println(config);
    }


}
