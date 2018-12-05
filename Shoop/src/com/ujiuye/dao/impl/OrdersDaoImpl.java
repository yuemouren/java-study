package com.ujiuye.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ujiuye.bean.Orders;
import com.ujiuye.dao.OrdersDao;
import com.ujiuye.util.C3P0DataSource;

public class OrdersDaoImpl implements OrdersDao {

	@Override
	public boolean saveOrders(Connection conn,Orders order,int uid) {
		
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		
		QueryRunner qr = new QueryRunner();
		try {
			int count = qr.update(conn,sql,order.getOid(),order.getOrdertime(),order.getTotal(),order.getState(),order.getAddress(),order.getName(),order.getTelephone(),uid);
			if(count > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Orders> getAllInfo(Integer uid) {
		String sql = "select oid,ordertime,total,state,address,name,telephone from orders";
		if(uid != null) {
			 sql+=" where uid="+uid;
		}
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql,new BeanListHandler<Orders>(Orders.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
