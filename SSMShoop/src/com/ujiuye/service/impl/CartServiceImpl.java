package com.ujiuye.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.CartExample;
import com.ujiuye.bean.CartExample.Criteria;
import com.ujiuye.bean.Cartitem;
import com.ujiuye.bean.CartitemExample;
import com.ujiuye.mapper.CartMapper;
import com.ujiuye.mapper.CartitemMapper;
import com.ujiuye.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Resource
	private CartitemMapper  cartitemMapper;
	@Resource
	private CartMapper cartMapper;
	
	@Override
	public boolean saveCartitem(Cartitem cartitems) {
		
		int insert = cartitemMapper.insert(cartitems);
		if(insert > 0) {
			return true;
		}
		return false;
		
	}

	@Override
	public Cart getOne(int uid) {
		
		CartExample ce = new CartExample();
		Criteria criteria = ce.createCriteria();
		criteria.andUidEqualTo(uid);
		return cartMapper.selectByExample(ce).get(0);
	}

	@Override
	public Cart getCartByUid(int uid) {
		
		return cartMapper.getCartByUid(uid);
		
	}

	@Override
	public boolean deleteCartitem(List<Integer> ids) {
		CartitemExample ce = new CartitemExample();
		com.ujiuye.bean.CartitemExample.Criteria criteria = ce.createCriteria();
		criteria.andIdIn(ids);
		int deleteByExample = cartitemMapper.deleteByExample(ce);
		if(deleteByExample > 0) {
			return true;
		}
		return false;
	}

}
