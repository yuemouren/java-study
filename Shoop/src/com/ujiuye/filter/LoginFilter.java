package com.ujiuye.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.User;
import com.ujiuye.service.UserService;
import com.ujiuye.service.impl.UserServiceImpl;

@WebFilter(urlPatterns= {"/login.jsp"})
public class LoginFilter implements Filter {
	private UserService service = new UserServiceImpl();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest  request =  (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		
	
		Cookie[] cookies = request.getCookies();
		String value = "";
		String login = "";
		
		for(Cookie cook : cookies) {
			if("activeInfo".equals(cook.getName())) {
				value = cook.getValue();
			}
			
			if("autoLogin".equals(cook.getName())) {
				login = cook.getValue();
			}
			
		}
		User user = null;
		if(value.length()>0) {
			String[] info = value.split(":");
			UserService service = new UserServiceImpl();
			user = service.login(info[0],info[1]);
		}
		
		if(user != null&&"true".equals(login)) {
			Cart cart = service.getInfo(user.getUid());
			user.setCart(cart);
			request.getSession().setAttribute("activeuser",user);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else {
			chain.doFilter(request, response);
		}
		
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
