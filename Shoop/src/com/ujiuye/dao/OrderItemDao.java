package com.ujiuye.dao;

import java.sql.Connection;
import java.util.List;

import com.ujiuye.bean.OrderItem;
import com.ujiuye.bean.OrderItemVo;

public interface OrderItemDao {
	
	public boolean saveOrderItem(Connection conn,OrderItem items,int oid,int pid);
	
	public List<OrderItem> getItemByOid(int oid);
	
	public List<OrderItemVo> getOv();
}
