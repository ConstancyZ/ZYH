package com.woniuxy.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.pojo.Product;
import com.woniuxy.service.ProviderService;



@RestController

public class FeignHandler {

	@Autowired
	private ProviderService providerService;
	
	@RequestMapping(value="/product/find/{pid}",method=RequestMethod.GET)
	public Product findProductById(@PathVariable("pid") int pid) {
		return  providerService.findProductById(pid);//通过feign访问provider
	}
	
	
	@RequestMapping(value="/product/all",method=RequestMethod.GET)
	public List<Product> all() {
		return  providerService.all();
	}
}
