package com.ujiuye.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ujiuye.bean.Product;
import com.ujiuye.bean.User;
import com.ujiuye.service.PageService;
import com.ujiuye.service.ProductService;
import com.ujiuye.service.impl.ProductServiceImpl;
import com.ujiuye.util.WriterJsonUtil;

@WebServlet(urlPatterns= {"/servlet/ProductServlet"})
public class ProductServlet extends HttpServlet {
	private ProductService service = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		try {
			Method methods = ProductServlet.class.getDeclaredMethod(method,HttpServletRequest.class,HttpServletResponse.class);
			methods.invoke(this,req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	protected void getIndexProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, List<Product>> indexProduct = service.getIndexProduct();
		
		WriterJsonUtil.getJson(indexProduct, req, resp);
	}
	protected void getOneInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid = Integer.parseInt(req.getParameter("pid"));
		Product pro = service.getOneInfo(pid);
		req.getSession().setAttribute("onePro",pro);
		resp.sendRedirect(req.getContextPath()+"/product_info.jsp");
	}
	protected void getProByCid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cid = Integer.parseInt(req.getParameter("cid"));
		int size = 12;
		int currentPage = 0;
		//System.out.println(req.getParameter("currentPage"));
		try {
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		} catch (Exception e) {
			currentPage = 1;
		}
		PageService pservice = new PageService(size, currentPage,cid,null);
		List<Product> proByCid = pservice.getProByCid();
		req.getSession().setAttribute("newPro",proByCid);
		req.getSession().setAttribute("pservice",pservice);
		User user =(User) req.getSession().getAttribute("activeuser");
		String ids="";
		if(user != null) {
			Cookie[] cookies = req.getCookies();
			for(Cookie cook : cookies) {
				if (cook.getName().equals(user.getUid() + "")) {
					ids = cook.getValue();
				}
			}
		}
		if(!("".equals(ids))) {
			String newids = ids.replaceAll("#",",");
			List<Product> oneInfo = service.getOneInfo(newids);
			System.out.println(oneInfo);
			req.getSession().setAttribute("hisPro",oneInfo);
		}
		resp.sendRedirect(req.getContextPath()+"/product_list.jsp");
	}
	protected void likeSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String search = req.getParameter("searchinfo");
		int size = 12;
		int currentPage = 0;
		//System.out.println(req.getParameter("currentPage"));
		try {
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		} catch (Exception e) {
			currentPage = 1;
		}
		
		PageService pservice = new PageService(size, currentPage,null,search);
		List<Product> likeSearch = pservice.likeSearch();
		req.getSession().setAttribute("newPro",likeSearch);
		req.getSession().setAttribute("pservice",pservice);
		resp.sendRedirect(req.getContextPath()+"/product_list.jsp");
	}
}
