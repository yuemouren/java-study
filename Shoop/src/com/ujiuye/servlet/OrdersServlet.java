package com.ujiuye.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.CartItem;
import com.ujiuye.bean.OrderItem;
import com.ujiuye.bean.Orders;
import com.ujiuye.bean.User;
import com.ujiuye.service.OrdersService;
import com.ujiuye.service.impl.OrdersServiceImpl;
import com.ujiuye.util.IdUtil;

@WebServlet(urlPatterns= {"/servlet/OrdersServlet"})
public class OrdersServlet extends HttpServlet {
	
	private OrdersService service = new OrdersServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		try {
			Method methods = OrdersServlet.class.getDeclaredMethod(method,HttpServletRequest.class,HttpServletResponse.class);
			methods.invoke(this,req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	protected void submitOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("activeuser");
		Orders orders = new Orders();
		orders.setOid(IdUtil.getId());
		orders.setOrdertime(new Date());
		Map<String, String[]> map = req.getParameterMap();
		try {
			BeanUtils.populate(orders, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cart cart =(Cart) req.getSession().getAttribute("cart");
		List<OrderItem> list = new ArrayList<OrderItem>();
		for(CartItem ci : cart.getCartitem()) {
			OrderItem oi = new OrderItem();
			oi.setCount(ci.getCount());
			oi.setSubtotal(ci.getSubtotal());
			oi.setProduct(ci.getProduct());
			list.add(oi);
		}
		orders.setOrderItems(list);
		boolean submitOrder = service.submitOrder(orders, user);
		
		if(submitOrder) {
			resp.sendRedirect(req.getContextPath()+"/success.jsp");
		}else {
			resp.sendRedirect(req.getContextPath()+"/error.jsp");
		}
		
	}
	protected void ordersInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getSession().getAttribute("activeuser");
		List<Orders> list = service.getOrderByUid(user.getUid());
		
		req.getSession().setAttribute("orders",list);
		
		resp.sendRedirect(req.getContextPath()+"/order_list.jsp");
	}
}
