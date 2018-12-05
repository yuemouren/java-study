package com.ujiuye.service.impl;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.User;
import com.ujiuye.dao.CartDao;
import com.ujiuye.dao.UserDao;
import com.ujiuye.dao.impl.CartDaoImpl;
import com.ujiuye.dao.impl.UserDaoImpl;
import com.ujiuye.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao udao = new UserDaoImpl();
	CartDao cdao = new CartDaoImpl();
	@Override
	public boolean saveUser(User user) {
		return udao.saveUser(user);
	}
	@Override
	public User login(String username, String password) {
		
		return udao.login(username, password);
	}
	@Override
	public boolean saveCart(Cart cart, int uid) {
		
		return cdao.saveCart(cart,uid);
	}
	@Override
	public Cart getInfo(int uid) {
		
		return cdao.getInfo(uid);
	}

}
