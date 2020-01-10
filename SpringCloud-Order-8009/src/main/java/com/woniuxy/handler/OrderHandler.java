package com.woniuxy.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.woniuxy.service.ProviderService;

@RestController
public class OrderHandler {

	@Autowired
	private ProviderService providerService;
	
	@RequestMapping(value="/order/pay/{pid}",method=RequestMethod.GET)
	public String pay(@PathVariable("pid") int pid) {
		
		
		return "你应该为"+providerService.findProductById(pid)+"这个商品支付100元";
	}
}
