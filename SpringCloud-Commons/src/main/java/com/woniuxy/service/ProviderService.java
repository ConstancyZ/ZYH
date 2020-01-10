package com.woniuxy.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.woniuxy.factory.ProviderServiceFactory;
import com.woniuxy.pojo.Product;
//要请求的微服务的名字
@FeignClient(name="woniu58-provider",fallbackFactory=ProviderServiceFactory.class)
public interface ProviderService {

	@RequestMapping(value="/product/find/{pid}",method=RequestMethod.GET)
	public Product findProductById(@PathVariable("pid") int pid);
	
	
	@RequestMapping(value="/product/all",method=RequestMethod.GET)
	public List<Product> all();
}