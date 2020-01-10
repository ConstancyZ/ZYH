package com.woniuxy.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.woniuxy.handler")
@EnableFeignClients(basePackages="com.woniuxy.service")//生产feign调用时的对象
@EnableEurekaClient  //注册中心客户端
@ComponentScan("com.woniuxy.factory")
public class SpringCloudOrderApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOrderApplication.class, args);
	}
}
