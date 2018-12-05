package com.ujiuye.service;

import com.ujiuye.bean.User;

public interface UserService {
	
	public boolean saveUser(User user);
	
	public User getOne(User user);
	
}
