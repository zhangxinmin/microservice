package com.test.microservivce.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * 对spring mvc 进行配置
 * 1、5.0 之前 extends WebMvcConfigurerAdapter 之后 implements WebMvcConfigurer
 * 2、重写方法
 * 3、增加 @EnableWebMvc 不加注解重写方法无效
 */
@Configuration
@EnableWebMvc//开启 mvc 一些默认配置
@ComponentScan(basePackages = "com.test.microservivce.mvc")
public class MvcConfig  extends WebMvcConfigurerAdapter implements WebMvcConfigurer {
    //viewResolver 配置viewresolver 指定 模板文件的 前缀和后缀
@Bean
    public InternalResourceViewResolver viewResolver(){

       InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
       viewResolver.setPrefix("/WEB-INF/classes/views/");
       viewResolver.setSuffix(".jsp");
       viewResolver.setViewClass(JstlView.class);
       return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //配置 /assets/** 访问路径  对应  资源路径为  /assets/
       registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }
   //配置访问路径 和 视图之间 的映射关系  访问这个路径直接跳转到指定视图  同controller 中 方法 不做任何操作 直接 return 一个视图
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //访问 index2 直接跳转到 index.jsp
        registry.addViewController("/index2").setViewName("index");
        registry.addViewController("/anno/toupload").setViewName("upload");
    }
    //注入multipartResolver
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000000);
        return multipartResolver;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }
}
