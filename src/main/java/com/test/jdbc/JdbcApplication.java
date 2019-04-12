package com.test.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {
		//两种启动方式
		SpringApplication springApplication = new SpringApplication(JdbcApplication.class);
		Map<String,Object> properties = new LinkedHashMap<>();
		properties.put("server.port",8000);
		springApplication.setDefaultProperties(properties);
		springApplication.run(args);

	}
}
