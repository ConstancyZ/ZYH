package com.woniuxy.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean
	@LoadBalanced   //开启负载均衡，默认采用随机轮训
	public RestTemplate getRestTeamplate() {
		
		return new RestTemplate();
	}
}
