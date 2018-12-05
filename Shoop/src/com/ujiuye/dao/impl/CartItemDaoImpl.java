package com.ujiuye.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ujiuye.bean.CartItem;
import com.ujiuye.bean.Product;
import com.ujiuye.dao.CartItemDao;
import com.ujiuye.util.C3P0DataSource;

public class CartItemDaoImpl implements CartItemDao {

	@Override
	public boolean saveCartItem(CartItem cartitem, int pid, int cid) {
		String sql = "insert into cartitem(count,subtotal,pid,cid) values (?,?,?,?)";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			int count = qr.update(sql, cartitem.getCount(), cartitem.getSubtotal(), pid, cid);
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CartItem ifExists(int pid) {
		String sql = "select id,count,subtotal from cartitem where pid=?";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql, new BeanHandler<CartItem>(CartItem.class), pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateCartItem(CartItem cartitem) {
		String sql = "update cartitem set count=?,subtotal=? where id=?";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			int count = qr.update(sql, cartitem.getCount(), cartitem.getSubtotal(), cartitem.getId());
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CartItem> getCartItem(int cid) {

		String sql = "select id,subtotal,count,pid from cartitem where cid=?";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql, new BeanListHandler<CartItem>(CartItem.class), cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteCartItem(Connection conn,Integer itemid, Integer cid) {
		
		String sql="delete from cartitem where cid=?";
	    QueryRunner qr = new QueryRunner();
	    int count = 0;
		try {
			if(itemid != null) {
				sql+=" and id=?";
			    count = qr.update(conn,sql,cid,itemid);
			}else {
				count = qr.update(conn,sql,cid);
			}
			if(count > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
