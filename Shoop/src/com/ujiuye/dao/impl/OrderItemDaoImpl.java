package com.ujiuye.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ujiuye.bean.OrderItem;
import com.ujiuye.bean.OrderItemVo;
import com.ujiuye.bean.Product;
import com.ujiuye.dao.OrderItemDao;
import com.ujiuye.util.C3P0DataSource;

public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public boolean saveOrderItem(Connection conn,OrderItem items, int oid, int pid) {
		String sql = "insert into orderitem (count,subtotal,pid,oid) values (?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		try {
			int count = qr.update(conn,sql,items.getCount(),items.getSubtotal(),pid,oid);
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
	public List<OrderItem> getItemByOid(int oid) {
		String sql = "select itemid,count,subtotal,pid from orderitem where oid=?";
		
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql,new BeanListHandler<OrderItem>(OrderItem.class),oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderItemVo> getOv() {
		String sql="SELECT p.pname,SUM(COUNT) count FROM product p,orderitem o WHERE p.`pid`= o.`pid`  GROUP BY  o.pid;";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql,new BeanListHandler<OrderItemVo>(OrderItemVo.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
