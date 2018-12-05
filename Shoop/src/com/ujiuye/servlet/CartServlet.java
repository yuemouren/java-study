package com.ujiuye.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.User;
import com.ujiuye.service.CartService;
import com.ujiuye.service.impl.CartServiceImpl;

@WebServlet(urlPatterns= {"/servlet/CartServlet"})
public class CartServlet extends HttpServlet {
	
	private CartService service = new CartServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		try {
			Method methods = CartServlet.class.getDeclaredMethod(method,HttpServletRequest.class,HttpServletResponse.class);
			methods.invoke(this,req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	protected void getProCartByCid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = (User)req.getSession().getAttribute("activeuser");
		Cart proCartByCid = service.getProCartByCid(user.getCart());
		req.getSession().setAttribute("cart",proCartByCid);
		resp.sendRedirect(req.getContextPath()+"/cart.jsp");
	}
}
