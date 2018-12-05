package com.ujiuye.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



public class WriterJsonUtil {
	
	public static  void getJson(Object obj,HttpServletRequest req,HttpServletResponse resp) {
		resp.setContentType("application/json;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.write(json);
		out.flush();
		out.close();
	}
}
