package com.ujiuye.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ujiuye.bean.ActiveUsermannger;
import com.ujiuye.bean.Auth;
import com.ujiuye.bean.Usermannger;
import com.ujiuye.mapper.AuthMapper;
import com.ujiuye.mapper.UsermanngerMapper;
import com.ujiuye.service.UsermanngerService;

@Service
public class UsermanngerServiceImpl implements UsermanngerService {

	@Resource
	private  UsermanngerMapper  usermanngerMapper;
	@Resource
	private  AuthMapper  authMapper;
	
	@Override
	public ActiveUsermannger login(String username, String password) {
		Usermannger user = usermanngerMapper.login(username, password);
		ActiveUsermannger au = null;
		if(user != null) {
			au = new ActiveUsermannger();
			au.setUserid(user.getUserid());
			au.setUsername(user.getUsername());
			au.setPassword(user.getPassword());
			List<Auth> parents = authMapper.getParents(user.getUserid());
			List<Auth> childs = authMapper.getChilds(user.getUserid());
			au.setParentes(parents);
			au.setChilds(childs);
		}
		return au;
	}

}
