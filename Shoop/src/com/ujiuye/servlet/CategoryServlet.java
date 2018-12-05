package com.ujiuye.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ujiuye.bean.Category;
import com.ujiuye.service.CategoryService;
import com.ujiuye.service.impl.CategoryServiceImpl;
import com.ujiuye.util.WriterJsonUtil;

@WebServlet(urlPatterns= {"/servlet/CategoryServlet"})
public class CategoryServlet extends HttpServlet {
	private CategoryService service = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		try {
			Method methods = CategoryServlet.class.getDeclaredMethod(method,HttpServletRequest.class,HttpServletResponse.class);
			methods.invoke(this,req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	protected void getAllInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> allInfo = service.getAllInfo();
		WriterJsonUtil.getJson(allInfo, req, resp);
	}
	
	
}
