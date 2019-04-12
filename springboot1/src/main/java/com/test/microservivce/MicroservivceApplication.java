package com.test.microservivce;

import com.test.microservivce.interceptor.MyIntercepetor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class MicroservivceApplication  implements ErrorPageRegistrar , WebMvcConfigurer {

	public static void main(String[] args) {
		//SpringApplication.run(MicroservivceApplication.class, args);
		//两种启动方式
		SpringApplication springApplication = new SpringApplication(MicroservivceApplication.class);
		Map<String,Object> properties = new LinkedHashMap<>();
		properties.put("server.port",8000);
		springApplication.setDefaultProperties(properties);
		springApplication.run(args);
		//fluent api
		//new SpringApplicationBuilder(MicroservivceApplication.class)
		//		.properties("server.port=0").run(args);//=0 表示随机端口
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//super.addInterceptors(registry);
		registry.addInterceptor(new MyIntercepetor());
	}
//  spring boot 实现 404 处理 注册
	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
	}
}
