package com.ujiuye.service;

import java.util.List;
import java.util.Map;

import com.ujiuye.bean.Product;

public interface ProductService {
	
	public Map<String,List<Product>> getIndexProduct();
	
	public Product getOneInfo(int pid);
	
	public List<Product> getOneInfo(String ids);
	
	public List<Product> getAllInfo(int pagesize,int size);
	
	public int getCount(Integer cid,String like);
	
	public boolean savePro(Product product,int cid);

}
