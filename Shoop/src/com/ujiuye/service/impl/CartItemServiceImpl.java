package com.ujiuye.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.ujiuye.bean.CartItem;
import com.ujiuye.dao.CartItemDao;
import com.ujiuye.dao.impl.CartItemDaoImpl;
import com.ujiuye.service.CartItemService;
import com.ujiuye.util.C3P0DataSource;

public class CartItemServiceImpl implements CartItemService {
	private CartItemDao dao = new CartItemDaoImpl();
	@Override
	public boolean saveCartItem(CartItem cartitem, int pid, int cid) {
		
		return dao.saveCartItem(cartitem, pid, cid);
	}
	@Override
	public CartItem ifExists(int pid) {
		
		return dao.ifExists(pid);
	}
	@Override
	public boolean updateCartItem(CartItem cartitem) {
		
		return dao.updateCartItem(cartitem);
	}
	@Override
	public boolean deleteCartItem(Integer itemid, Integer cid) {
		Connection conn = null;
		try {
			conn = C3P0DataSource.getDs().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dao.deleteCartItem(conn,itemid, cid);
	}

}
