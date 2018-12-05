package com.ujiuye.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ujiuye.bean.ActiveUsermannger;
import com.ujiuye.service.UsermanngerService;
import com.ujiuye.util.MessageInfo;

@Controller
@RequestMapping("/usermannger")
@SessionAttributes("activeUsermannger")
public class UsermanngerController {
	
	@Resource
	private UsermanngerService usermanngerService;
	
	@RequestMapping("login")
	@ResponseBody
	public MessageInfo login(@RequestParam("username") String username,@RequestParam("password") String password,Model model) {
		
		ActiveUsermannger login = usermanngerService.login(username, password);
		MessageInfo mi = new MessageInfo();
		if(login != null) {
			model.addAttribute("activeUsermannger",login);
			mi.setFlag(true);
			mi.setMessage("main");
		}else {
			mi.setFlag(false);
			mi.setMessage("index");
		}
		return mi;
	}
}
