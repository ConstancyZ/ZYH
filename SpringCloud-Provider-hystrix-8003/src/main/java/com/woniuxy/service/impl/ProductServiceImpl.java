package com.woniuxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.woniuxy.mapper.ProductMapper;
import com.woniuxy.pojo.Product;
import com.woniuxy.service.ProductService;

import lombok.Data;

@Data
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper productMapper;

	public List<Product> all() {
		return productMapper.all();
	}
	public Product findProductById(int pid) {
		return productMapper.findProductById(pid);
	}
	//这里面需要把"productAll","findProductById"两个方法都放入里面，因为当删除后就不再是直接从redis中读取数据，而是需要重新在数据库中查找
	public void delById(int pid) {
		// TODO Auto-generated method stub
		productMapper.delById(pid);
	}
	public void descCount(int pid) {
		// TODO Auto-generated method stub
		productMapper.descCount(pid);
	}
	
	
}
