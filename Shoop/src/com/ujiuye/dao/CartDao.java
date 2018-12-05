package com.ujiuye.dao;

import com.ujiuye.bean.Cart;

public interface CartDao {
	
	public boolean saveCart(Cart cart,int uid);
	
	public Cart getInfo(int uid);
	
}
