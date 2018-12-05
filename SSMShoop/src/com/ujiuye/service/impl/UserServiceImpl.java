package com.ujiuye.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.User;
import com.ujiuye.bean.UserExample;
import com.ujiuye.bean.UserExample.Criteria;
import com.ujiuye.mapper.CartMapper;
import com.ujiuye.mapper.UserMapper;
import com.ujiuye.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	@Resource
	private CartMapper cartMapper;
	
	@Override
	@Transactional
	public boolean saveUser(User user) {
		
		int insert = userMapper.insert(user);
		Cart cart = new Cart();
		cart.setCdis(user.getName()+"的购物车");
		cart.setUid(user.getUid());
		int insert2 = cartMapper.insert(cart);
		
		if(insert > 0 && insert2 > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public User getOne(User user) {
		
		UserExample ue = new UserExample();
		Criteria criteria = ue.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		criteria.andPasswordEqualTo(user.getPassword());
		return userMapper.selectByExample(ue).get(0);
	}

}
