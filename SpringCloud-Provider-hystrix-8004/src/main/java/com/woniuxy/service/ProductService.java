package com.woniuxy.service;

import java.util.List;

import com.woniuxy.pojo.Product;




public interface ProductService {
	public List<Product> all();
	
	public Product findProductById(int pid);
	
	public void delById(int pid);
		
	public void descCount(int pid);
}
