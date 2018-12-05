package com.ujiuye.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujiuye.bean.ActiveUsermannger;
import com.ujiuye.bean.Auth;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@RequestMapping("createTree")
	@ResponseBody
	public List<Map<String,Object>>  createTree(HttpSession session) {
		
		ActiveUsermannger au = (ActiveUsermannger)session.getAttribute("activeUsermannger");
		List<Auth> parentes = au.getParentes();
		List<Auth> childs = au.getChilds();
		List<Map<String,Object>> tree = new ArrayList<Map<String,Object>>();
		Map<String,Object> parmap = null;
		int i = 0;
		for(Auth parAu : parentes) {
			parmap = new HashMap<String,Object>();
			parmap.put("id",parAu.getAuthid());
			parmap.put("text",parAu.getAuthname());
			parmap.put("state",parAu.getState());
			
			List<Map<String,Object>> child = new ArrayList<Map<String,Object>>();
			Map<String,Object> childmap = null;
			Map<String,Object> attrmap = null;
			for(Auth childAu : childs) {
				if(childAu.getParentid() == parAu.getAuthid()) {
					i = 1;
					childmap = new HashMap<String,Object>();
					childmap.put("text",childAu.getAuthname());
					childmap.put("state",childAu.getState());
					attrmap = new HashMap<String,Object>();
					attrmap.put("url",childAu.getAuthpath());
					childmap.put("attributes",attrmap);
					child.add(childmap);
				}
			}
			if(i == 1) {
				parmap.put("children",child);
			}
			tree.add(parmap);
		}
		return tree;
	}
}
