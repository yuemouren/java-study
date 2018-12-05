package com.ujiuye.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns= {"/servlet/CartItemServlet","/cart.jsp","/servlet/CartServlet","/servlet/OrdersServlet","/order_list.jsp","/order_info.jsp"})
public class BuyLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest  request =  (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		
		Object user = request.getSession().getAttribute("activeuser");
		
		if(user == null) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else {
			arg2.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
