package com.woniuxy.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.woniuxy.pojo.Product;

@Controller
@RequestMapping("/product")

public class ProductHandler {

	//
	@Autowired
	private RestTemplate restTemplate;

	private static final String URL="http://WONIU58-PROVIDER/product";
	
	@RequestMapping("/all")
	@ResponseBody
	public List<Product> all(){
		List<Product> products=	restTemplate.getForObject(URL+"/all",List.class);
		return products;
		}
	
	@RequestMapping("/find")
	@ResponseBody
	public Product find(Integer pid){
		Product products=	restTemplate.getForObject(URL+"/find/"+pid,Product.class);
		return products;
		}
}
