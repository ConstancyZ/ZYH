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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	@RequestMapping("/file/image")
	public void upload(@RequestParam(value="image")MultipartFile image,String detail,HttpServletRequest req) {
		if(image!=null) {
		String name =image.getOriginalFilename();//获取图片名字
		System.out.println(name);
		System.out.println(detail);
		//获取webapp下的image文件夹
		String rootPath=req.getServletContext().getRealPath("/");//项目根目录
		System.out.println(rootPath);
		//webapp
		File webapp=new File(rootPath);//得到webapp/当前项目名路径
		
		
		//判断webapp下是否有images
		File images=new File(webapp,"images");
		if(!images.exists()) {
			images.mkdirs();
		}
		
		//给文件随机取名字
		String fileName=UUID.randomUUID().toString();
		fileName+=name.substring(name.indexOf("."), name.length());
		System.out.println(fileName);
		//将文件存放在images下
		File newFile=new File(images,fileName);
		
		//上传文件
		try {
			image.transferTo(newFile);
			//再把文件名存入到数据库
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
