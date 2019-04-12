package com.test.microservivce.mvc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Registration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * WebApplicationInitializer 为spring 提供 用来配置 servlet3.0 的配置接口
 * 从而替代 web.xml 中的配置
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext  ctx= new AnnotationConfigWebApplicationContext();
        ctx.register(MvcConfig.class);
        ctx.setServletContext(servletContext);

        //注册 核心控制器
        ServletRegistration.Dynamic servlet =
                servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));
        servlet.addMapping("/");
         servlet.setLoadOnStartup(1);


    }
}
