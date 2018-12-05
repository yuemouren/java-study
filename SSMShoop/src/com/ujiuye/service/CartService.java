package com.ujiuye.service;

import java.util.List;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.Cartitem;

public interface CartService {
	
	public boolean saveCartitem(Cartitem cartitems);
	
	public Cart getOne(int uid);
	
	public Cart getCartByUid(int uid);
	
	public boolean deleteCartitem(List<Integer> ids);
}
