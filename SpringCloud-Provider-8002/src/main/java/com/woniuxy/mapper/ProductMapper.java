package com.woniuxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.woniuxy.pojo.Product;



public interface ProductMapper {
	@Select("select * from product")
	@Results({
		@Result(id=true,column="pid",property="pid"),
		@Result(property="images",column="pid",many=@Many(select="findImagesByPid"))
		
	})
	public List<Product> all();
	
	@Select("select * from product where pid=#{pid}")
	@Results({
		@Result(id=true,column="pid",property="pid"),
		@Result(property="images",column="pid",many=@Many(select="findImagesByPid")),
		@Result(property="productType",column="pid",many=@Many(select="findProductTypeByPid"))
	})
	public Product findProductById(int pid);
	
	@Delete("delete from product where pid =#{pid}")
	public void delById(int pid);
	
	//通过pid找到对应的图片
	@Select("select name from images where pid =#{pid}")
	public List<String> findImagesByPid(int pid);
	
	//通过pid找到商品的类型
	@Select("select productType from producttype where pid =#{pid}")
	public List<String> findProductTypeByPid(int pid);
	
	//减少库存操作
	@Update("update product set count=count-1 where pid=#{pid}")
	public void descCount(int pid);
}
