package com.woniuxy.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.woniuxy"})
@MapperScan("com.woniuxy.mapper")
public class SpringCloudProvider8002Application{
	public static void main(String[] args){
		SpringApplication.run(SpringCloudProvider8002Application.class,args);

}
}