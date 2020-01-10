package com.woniuxy.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class FileConfig {
	@Bean
	public MultipartResolver configMultipartResolver() {
	    CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
	    commonsMultipartResolver.setMaxUploadSize(104857600);
	    commonsMultipartResolver.setMaxInMemorySize(4096);
	    return commonsMultipartResolver;
	}
	

}
