package com.ujiuye.dao;


import java.sql.Connection;
import java.util.List;

import com.ujiuye.bean.Orders;

public interface OrdersDao {
	
	public boolean saveOrders(Connection conn,Orders order,int uid);
	
	public List<Orders> getAllInfo(Integer uid);
}
