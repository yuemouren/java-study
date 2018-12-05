package com.ujiuye.dao;

import com.ujiuye.bean.User;

public interface UserDao {
	
	public boolean saveUser(User user);
	
	public User login(String username,String password);
}
