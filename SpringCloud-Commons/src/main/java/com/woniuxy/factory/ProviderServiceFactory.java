package com.woniuxy.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.woniuxy.pojo.Product;
import com.woniuxy.service.ProviderService;

import feign.hystrix.FallbackFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/*
 * 此工厂指定fallback方法，与ProviderService方法保持一致
 */
@Component
public class ProviderServiceFactory implements FallbackFactory<ProviderService>{

	public ProviderService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new ProviderService() {
			public Product findProductById(int pid) {
				Product product=new Product();
				//因为加了链式表达，可以这样写
				product.setPid(2001).setPname("没有数据").setCount(0);
				return product;
			}
			public List<Product> all() {
				// TODO Auto-generated method stub
				return new ArrayList<Product>();
			}
	};
	}
}

