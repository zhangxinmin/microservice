package com.test.microservivce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class MicroservivceApplication  {

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


}
