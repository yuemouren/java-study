package com.ujiuye.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ujiuye.bean.Cart;
import com.ujiuye.dao.CartDao;
import com.ujiuye.util.C3P0DataSource;

public class CartDaoImpl implements CartDao {

	@Override
	public boolean saveCart(Cart cart,int uid) {
		String sql = "insert into cart(cdis,uid)values(?,?)";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			int update = qr.update(sql,cart.getCdis(),uid);
			if(update > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Cart getInfo(int uid) {
		String sql = "select cid,cdis from cart where uid=?";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql,new BeanHandler<Cart>(Cart.class),uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
