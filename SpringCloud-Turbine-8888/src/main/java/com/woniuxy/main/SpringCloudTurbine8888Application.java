package com.woniuxy.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableEurekaClient
@EnableTurbine	//开启涡轮
@EnableHystrixDashboard
public class SpringCloudTurbine8888Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTurbine8888Application.class, args);
	}
}
