package com.ujiuye.service;

import java.util.List;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.OrderitemVo;
import com.ujiuye.bean.Orders;

public interface OrdersService {
	
	public boolean saveOrders(Orders orders,Cart cart);
	
	public List<Orders> getAllOrders(int uid);
	
	public List<Orders> getAllOrders();
	
	public List<OrderitemVo> getOrderitemVo();
}
