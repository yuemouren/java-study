package com.ujiuye.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.CartItem;
import com.ujiuye.bean.User;
import com.ujiuye.service.CartItemService;
import com.ujiuye.service.impl.CartItemServiceImpl;
import com.ujiuye.service.impl.CartServiceImpl;
import com.ujiuye.util.MessageInfo;
import com.ujiuye.util.WriterJsonUtil;

@WebServlet(urlPatterns = { "/servlet/CartItemServlet" })
public class CartItemServlet extends HttpServlet {

	private CartItemService service = new CartItemServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		try {
			Method methods = CartItemServlet.class.getDeclaredMethod(method, HttpServletRequest.class,
					HttpServletResponse.class);
			methods.invoke(this, req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void saveCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = (User) req.getSession().getAttribute("activeuser");
		int count = Integer.parseInt(req.getParameter("count"));
		double price = Double.parseDouble(req.getParameter("price"));
		int pid = Integer.parseInt(req.getParameter("pid"));
		CartItem cart = service.ifExists(pid);
		if (cart != null) {
			int count2 = cart.getCount();
			double subtotal = cart.getSubtotal();
			cart.setCount((count2 + count));
			cart.setSubtotal(subtotal + (count * price));
			boolean flag = service.updateCartItem(cart);
			if (flag) {
				resp.sendRedirect(req.getContextPath() + "/product_info.jsp");
			} else {
				resp.sendRedirect(req.getContextPath() + "/error.jsp");
			}
		} else {
			CartItem ci = new CartItem();
			ci.setCount(count);
			ci.setSubtotal((count * price));
			boolean flag = service.saveCartItem(ci, pid, user.getCart().getCid());
			if (flag) {
				resp.sendRedirect(req.getContextPath() + "/product_info.jsp");
			} else {
				resp.sendRedirect(req.getContextPath() + "/error.jsp");
			}
		}
	}
	
	protected void deleteCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		User user = (User)req.getSession().getAttribute("activeuser");
		boolean flag = false;
		if(id != null) {
			int itemid = Integer.parseInt(id);
			flag = service.deleteCartItem(itemid,user.getCart().getCid());
		}else {
			flag = service.deleteCartItem(null,user.getCart().getCid());
		}
		MessageInfo mi = new MessageInfo();
		if(flag) {
			mi.setFlag(true);
			mi.setMessage("删除成功");
		}else {
			mi.setFlag(false);
			mi.setMessage("删除失败");
		}
		Cart proCartByCid = new CartServiceImpl().getProCartByCid(user.getCart());
		req.getSession().setAttribute("cart",proCartByCid);
		
		WriterJsonUtil.getJson(mi, req, resp);
		/*if(flag) {
			resp.sendRedirect(req.getContextPath()+"/servlet/CartServlet?method=getProCartByCid");
		}else {
			resp.sendRedirect(req.getContextPath()+"error.jsp");
		}*/
	}

}
