package com.ujiuye.dao;

import java.sql.Connection;
import java.util.List;

import com.ujiuye.bean.CartItem;

public interface CartItemDao {
	
	public boolean saveCartItem(CartItem cartitem,int pid,int cid);
	
	public CartItem ifExists(int pid);
	
	public boolean updateCartItem(CartItem cartitem);
	
	public List<CartItem> getCartItem(int cid);
	
	public boolean deleteCartItem(Connection conn,Integer itemid,Integer cid);
}
