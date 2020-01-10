package com.woniuxy.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigHandler {
	
	@Value("${spring.application.name}")//就是用来读取application.yml中的配置信息
	private String applicationName;
	
	@RequestMapping("getName")
	public String getApplicationName() {
		
		return applicationName;	
	}
}
