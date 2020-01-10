package com.woniuxy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class RuleConfiguration {
	/*
	 * 需要什么样的负载均衡策略就返回什么类型的对象即可
	 */
	@Bean
	public IRule getRule() {
		return new RandomRule();
		
	}
}
