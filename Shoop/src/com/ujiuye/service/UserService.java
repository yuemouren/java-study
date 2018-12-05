package com.ujiuye.service;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.User;

public interface UserService {
	
	public boolean saveUser(User user);
	
	public User login(String username,String password);
	
	public boolean saveCart(Cart cart,int uid);
	
	public Cart getInfo(int uid);
}
