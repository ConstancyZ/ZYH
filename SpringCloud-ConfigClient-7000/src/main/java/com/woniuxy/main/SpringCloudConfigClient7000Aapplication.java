package com.woniuxy.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.woniuxy.handler")
public class SpringCloudConfigClient7000Aapplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClient7000Aapplication.class, args);
	}
}
