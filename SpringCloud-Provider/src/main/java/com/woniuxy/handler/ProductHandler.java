package com.woniuxy.handler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.netflix.client.http.HttpRequest;
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
	@RequestMapping(value="/product/find/{pid}",method=RequestMethod.GET)
	public Product findProductById(@PathVariable("pid") int pid) {
		return productService.findProductById(pid);
		
	}
	@RequestMapping(value="/product/all",method=RequestMethod.GET)
	public List<Product> all() {
		return productService.all();
		
	}
	
}
