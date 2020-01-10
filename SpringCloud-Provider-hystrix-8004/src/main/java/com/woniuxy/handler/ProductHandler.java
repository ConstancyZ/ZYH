package com.woniuxy.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.woniuxy.pojo.Product;
import com.woniuxy.service.ProductService;

@RestController

@EnableEurekaClient       //成为注册中心的客户端
public class ProductHandler {

	@Autowired
	private ProductService  productService;
	/*
	 * find?pid=1001
	 * rest: find/1001/zhangsan/....
	 */
	@HystrixCommand(fallbackMethod="fallBack")
	@RequestMapping(value="/product/find/{pid}",method=RequestMethod.GET)
	public Product findProductById(@PathVariable("pid") int pid) {
		return productService.findProductById(pid);
		
	}
	public Product fallBack(@PathVariable("pid") int pid) {
		Product product=new Product();
		product.setPname("错误");
		return product;
		
	}
	@RequestMapping(value="/product/all",method=RequestMethod.GET)
	public List<Product> all() {
		return productService.all();
		
	}
}
