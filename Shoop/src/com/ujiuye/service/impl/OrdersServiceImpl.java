package com.ujiuye.service.impl;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ujiuye.bean.OrderItem;
import com.ujiuye.bean.Orders;
import com.ujiuye.bean.Product;
import com.ujiuye.bean.User;
import com.ujiuye.dao.CartItemDao;
import com.ujiuye.dao.OrderItemDao;
import com.ujiuye.dao.OrdersDao;
import com.ujiuye.dao.ProductDao;
import com.ujiuye.dao.impl.CartItemDaoImpl;
import com.ujiuye.dao.impl.OrderItemDaoImpl;
import com.ujiuye.dao.impl.OrdersDaoImpl;
import com.ujiuye.dao.impl.ProductDaoImpl;
import com.ujiuye.service.OrdersService;
import com.ujiuye.util.C3P0DataSource;

public class OrdersServiceImpl implements OrdersService {
	private OrdersDao dao = new OrdersDaoImpl();
	private OrderItemDao itemdao = new OrderItemDaoImpl();
	private CartItemDao cdao = new CartItemDaoImpl();
	private ProductDao pdao = new ProductDaoImpl();
	@Override
	public boolean submitOrder(Orders orders, User user) {
		Connection conn = null;
		try {
			conn = C3P0DataSource.getDs().getConnection();
			conn.setAutoCommit(false);
			
			boolean saveOrders = dao.saveOrders(conn,orders,user.getUid());
			boolean saveOrderItem = false;
			for(OrderItem oi : orders.getOrderItems()) {
				saveOrderItem = itemdao.saveOrderItem(conn,oi,orders.getOid(),oi.getProduct().getPid());
			}
			boolean deleteCartItem = cdao.deleteCartItem(conn,null,user.getCart().getCid());
			
			conn.commit();
			conn.setAutoCommit(true);
			
			if(saveOrders&&saveOrderItem&&deleteCartItem) {
				return true;
			}
			
		} catch (Exception e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		}
		
		
		return false;
	}
	@Override
	public List<Orders> getOrderByUid(Integer uid) {
		List<Orders> allInfo = dao.getAllInfo(uid);
		for(Orders order : allInfo) {
			List<OrderItem> itemByOid = itemdao.getItemByOid(order.getOid());
			for(OrderItem oi : itemByOid) {
				Product product = pdao.getOneInfo(oi.getPid());
				oi.setProduct(product);
			}
			order.setOrderItems(itemByOid);
		}
		return allInfo;
	}

}
