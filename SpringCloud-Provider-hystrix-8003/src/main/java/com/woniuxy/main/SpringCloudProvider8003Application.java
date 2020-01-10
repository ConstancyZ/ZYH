package com.woniuxy.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.woniuxy"})
@MapperScan("com.woniuxy.mapper")
@EnableEurekaClient   //注册中心
@EnableCircuitBreaker  //开启熔断器
public class SpringCloudProvider8003Application{
	public static void main(String[] args){
		SpringApplication.run(SpringCloudProvider8003Application.class,args);

}
}