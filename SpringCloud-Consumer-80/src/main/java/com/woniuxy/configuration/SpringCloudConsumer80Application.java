package com.woniuxy.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("com.woniuxy")
@EnableEurekaClient       //成为注册中心的客户端
public class SpringCloudConsumer80Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConsumer80Application.class,args);
	}
}
