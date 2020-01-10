package com.woniuxy.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.woniuxy.handler")
@EnableEurekaClient  //注册客户端
@EnableFeignClients(basePackages="com.woniuxy.service")//生产feign调用时的对象
@ComponentScan("com.woniuxy.factory")
public class SpringCloudFeign80Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeign80Application.class,args);
	}
}
