package com.ujiuye.service;

import com.ujiuye.bean.CartItem;

public interface CartItemService {
	
	public boolean saveCartItem(CartItem cartitem,int pid,int cid);
	
	public CartItem ifExists(int pid);
	
	public boolean updateCartItem(CartItem cartitem);
	
	public boolean deleteCartItem(Integer itemid,Integer cid);
}
