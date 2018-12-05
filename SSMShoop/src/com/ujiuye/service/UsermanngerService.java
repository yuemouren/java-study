package com.ujiuye.service;

import com.ujiuye.bean.ActiveUsermannger;

public interface UsermanngerService {
	
	public ActiveUsermannger login(String username,String password);
}
