package com.woniuxy.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy		//指定当前微服务为路由服务器代理
public class SpringCloudZuul9000 {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuul9000.class, args);
	}
}
