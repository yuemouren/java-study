package com.ujiuye.service;

import java.util.List;

import com.ujiuye.bean.Orders;
import com.ujiuye.bean.User;

public interface OrdersService {
	public boolean submitOrder(Orders orders,User user);
	
	public List<Orders> getOrderByUid(Integer uid);
}
