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

import com.ujiuye.bean.User;

@WebFilter(urlPatterns = {"/servlet/ProductServlet"})
public class HistoryFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		String method = request.getParameter("method");
		if ("getOneInfo".equals(method)) {
			User user = (User) request.getSession().getAttribute("activeuser");
			if (user != null) {
				String value = "";
				int pid = Integer.parseInt(request.getParameter("pid"));
				Cookie[] cookies = request.getCookies();
				for (Cookie cook : cookies) {
					if (cook.getName().equals(user.getUid() + "")) {
						value = cook.getValue();
					}
				}
				
				String[] info = value.split("#");
				if(!info[info.length-1].equals(pid+"")) {
					
					if("".equals(value)) {
						value=pid+"";
					}else {
						String repid="";
						for(int i=0;i<info.length-1;i++) {
							if(info[i].equals(pid+"")) {
								repid=info[i];
							}
							if(!"".equals(repid)) {
								info[i]=info[i+1];
							}
						}
						
						if(info.length<6) {
							value+=("#"+pid);
						}else {
							value="";
							if(repid.equals(pid+"")) {
								value=info[0];
								for(int i=1;i<info.length-1;i++) {
									value+=("#"+info[i]);
								}
							}else {
								value=info[1];
								for(int i=2;i<info.length;i++) {
									value+=("#"+info[i]);
								}
							}
							value+="#"+pid;
						}
					}
				}
				
			
				Cookie ck = new Cookie(user.getUid() + "", value);
				ck.setMaxAge(Integer.MAX_VALUE);
				ck.setPath(request.getContextPath());
				response.addCookie(ck);
			}
		}
		arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
