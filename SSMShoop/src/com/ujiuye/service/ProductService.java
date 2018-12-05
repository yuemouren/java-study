package com.ujiuye.service;

import java.util.List;

import com.ujiuye.bean.Product;
import com.ujiuye.bean.ProductExample;

public interface ProductService {
	
	public  List<Product> getHot();
	
	public  List<Product> getNew();
	
	public Product getPro(int pid);
	
	public List<Product> getProByCid(int cid);
	
	public List<Product> likeSerach(String name);
	
	public List<Product> getAllPro(int start,int pagesize);
	
	public int getCount(ProductExample example);
	
	public boolean addProduct(Product product,int cid);
}
