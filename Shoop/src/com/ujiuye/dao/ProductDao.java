package com.ujiuye.dao;

import java.util.List;

import com.ujiuye.bean.Product;

public interface ProductDao {
	
	public List<Product> getHotProduct();
	
	public List<Product> getNewProduct();
	
	public Product getOneInfo(int pid);
	
	public int getCount(Integer cid,String like);
	
	public List<Product> getProByCid(int cid,int start,int size);
	
	public List<Product> getOneInfo(String ids);
	
	public List<Product> likeSearch(String like,int start,int size);
	
	public List<Product> getAllInfo(int start,int size);
	
	public boolean savePro(Product product,int cid);
	
}
