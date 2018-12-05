package com.ujiuye.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ujiuye.bean.User;
import com.ujiuye.service.UserService;

@SessionAttributes(value= {"activeuser"})
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("register")
	public String register(User user) {
		boolean saveUser = userService.saveUser(user);
		
		if(saveUser) {
			return "redirect:../login.jsp";
		}else {
			return "redirect:../error.jsp";
		}
	}
	
	@RequestMapping("getOne")
	public String  getOne(User user,Map<String,Object> map) {
		
		User one = userService.getOne(user);
		map.put("activeuser",one);
		if(one != null) {
			return "redirect:../index.jsp";
		}else {
			return "redirect:../login.jsp";
		}
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:../index.jsp";
	}
	
}
