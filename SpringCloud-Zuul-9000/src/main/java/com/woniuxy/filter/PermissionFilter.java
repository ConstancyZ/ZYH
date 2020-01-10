package com.woniuxy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class PermissionFilter extends ZuulFilter{

	public boolean shouldFilter() {  //是否要过滤
		//1.得到request
		//2.判断url是不是需要认证
		//3.判断url中是否包含某些特定的字符串
		String uri = "";
		if(uri.contains("/user/login")) {
			return false;
		}
		if(uri.contains("/order/makeorder")) {
			return true;  //如果返回true 就会执行run方法
		}
		return false;
	}

	public Object run() throws ZuulException {
		//自己在这里去判断是否有认证过
		//没登录，就到登录页面
		//如果登陆过，就判断是否有权限,从redis中获取权限信息进行对比
		//如果有，则返回null
		//如果没有，跳到你没有权限的页面
		return null;
	}

	@Override
	public String filterType() {
		// 指定过滤器的类型,过滤器执行的时间
		return null;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
}