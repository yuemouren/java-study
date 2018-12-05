package com.ujiuye.dao;

import java.util.List;

import com.ujiuye.bean.ProductDetail;

public interface ProductDetailDao {
	
	public List<ProductDetail> getDetailByUid(int pid);
}
