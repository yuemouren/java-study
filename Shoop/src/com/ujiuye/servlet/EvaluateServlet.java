package com.ujiuye.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ujiuye.bean.EvaluateVo;
import com.ujiuye.bean.User;
import com.ujiuye.service.EvaluateService;
import com.ujiuye.service.impl.EvaluateServiceImpl;

@WebServlet(urlPatterns= {"/servlet/EvaluateServlet"})
public class EvaluateServlet extends HttpServlet {
	private EvaluateService service = new EvaluateServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		try {
			Method methods = EvaluateServlet.class.getDeclaredMethod(method,HttpServletRequest.class,HttpServletResponse.class);
			methods.invoke(this,req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	protected void saveEvaluate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid = Integer.parseInt(req.getParameter("pid"));
		User user = (User)req.getSession().getAttribute("activeuser");
		String dis = req.getParameter("upfile");
		EvaluateVo ev = new EvaluateVo();
		ev.setPid(pid);
		ev.setUid(user.getUid());
		ev.setDis(dis);
		boolean saveEvaluate = service.saveEvaluate(ev);
		if(saveEvaluate) {
			resp.sendRedirect(req.getContextPath()+"/success.jsp");
		}else {
			resp.sendRedirect(req.getContextPath()+"/error.jsp");
		}
		
	}
	
}
