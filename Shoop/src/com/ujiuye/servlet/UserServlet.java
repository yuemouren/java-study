package com.ujiuye.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.User;
import com.ujiuye.service.UserService;
import com.ujiuye.service.impl.UserServiceImpl;
import com.ujiuye.util.IdUtil;
import com.ujiuye.util.MessageInfo;
import com.ujiuye.util.MyDateFormat;
import com.ujiuye.util.WriterJsonUtil;

@WebServlet(urlPatterns= {"/servlet/UserServlet"})
public class UserServlet extends HttpServlet {
	
	private UserService service = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		try {
			Method methods = UserServlet.class.getDeclaredMethod(method,HttpServletRequest.class,HttpServletResponse.class);
			methods.invoke(this,req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = new User();
		user.setUid(IdUtil.getId());
		Map<String, String[]> map = req.getParameterMap();
		
		try {
			BeanUtils.populate(user, map);
		} catch (Exception e) {
			user.setBirthday(MyDateFormat.getDate(req.getParameter("birthday")));
		} 
		boolean saveUser = service.saveUser(user);
		//MessageInfo mi = new MessageInfo();
		if(saveUser) {
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
			/*mi.setMessage("注册成功");
			mi.setFlag(true);*/
		}else {
			resp.sendRedirect(req.getContextPath()+"/register.jsp");
			/*mi.setMessage("注册失败");
			mi.setFlag(false);*/
		}
		//WriterJsonUtil.getJson(mi, req, resp);
	}
	
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String  username= req.getParameter("username");
		String  password = req.getParameter("password");
		String  code = req.getParameter("code");
		System.out.println(username+":"+password+":"+code);
		String  newCode =(String)req.getSession().getAttribute("code");
		
		MessageInfo mi = new MessageInfo();
		if(newCode.equals(code)) {
			User user = service.login(username, password);
			if(user != null) {
				
				Cart cart = service.getInfo(user.getUid());
				if(cart == null) {
					Cart newCart = new Cart();
					newCart.setCdis(user.getName()+"的购物车");
					boolean saveCart = service.saveCart(newCart, user.getUid());
					if(!saveCart) {
						mi.setMessage("购物车添加失败");
						mi.setFlag(false);
					}
					user.setCart(newCart);
				}else {
					user.setCart(cart);
				}
				req.getSession().setAttribute("activeuser",user);
				
				if("rem".equals(req.getParameter("rem"))) {
					Cookie cookie = new Cookie("activeInfo",username+":"+password);
					cookie.setMaxAge(Integer.MAX_VALUE);
					cookie.setPath(req.getContextPath());
					resp.addCookie(cookie);
				}else {
					Cookie cookie = new Cookie("activeInfo","");
					cookie.setMaxAge(0);
					cookie.setPath(req.getContextPath());
					resp.addCookie(cookie);
				}
				if("autoLogin".equals(req.getParameter("autoLogin"))) {
					Cookie cookie = new Cookie("autoLogin","true");
					cookie.setMaxAge(Integer.MAX_VALUE);
					cookie.setPath(req.getContextPath());
					resp.addCookie(cookie);
				}
				mi.setMessage("登录成功");
				mi.setFlag(true);
			}else {
				mi.setMessage("用户名或密码错误，登录失败");
				mi.setFlag(false);
			}
		}else {
			mi.setMessage("验证码错误，登录失败");
			mi.setFlag(false);
		}
		WriterJsonUtil.getJson(mi, req, resp);
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getSession().removeAttribute("activeuser");
		Cookie cookie = new Cookie("autoLogin","");
		cookie.setMaxAge(0);
		cookie.setPath(req.getContextPath());
		resp.addCookie(cookie);
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
		
	}
	
}
