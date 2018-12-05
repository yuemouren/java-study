package com.ujiuye.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.Cartitem;
import com.ujiuye.bean.User;
import com.ujiuye.service.CartService;

@Controller
@RequestMapping("/cart")
@SessionAttributes(value= {"cart"})
public class CartController {
	
	@Resource
	private CartService cartService;
	
	@RequestMapping("saveCartitem")
	public String saveCartitem(int pid,double price,int count,HttpSession session) {
		
		User user = (User)session.getAttribute("activeuser");
		Cartitem cartitem = new Cartitem();
		Cart one = cartService.getOne(user.getUid());
		cartitem.setCid(one.getCid());
		cartitem.setPid(pid);
		cartitem.setCount(count);
		cartitem.setSubtotal(count*price);
		boolean saveCartitem = cartService.saveCartitem(cartitem);
		if(saveCartitem) {
			return "redirect:../index.jsp";
		}else {
			return "redirect:../error.jsp";
		}
	}
	
	@RequestMapping("getCart")
	public String getCart(HttpSession session,Model model) {
		
		User user = (User)session.getAttribute("activeuser");
		Cart cartByUid = cartService.getCartByUid(user.getUid());
		model.addAttribute("cart",cartByUid);
		if(cartByUid != null) {
			return "redirect:../cart.jsp";
		}else {
			return "redirect:../error.jsp";
		}
	}
	
	@RequestMapping("deleteCartitem")
	public String deleteCartitem(@RequestParam("ids") List<Integer> ids) {
		
		boolean deleteCartitem = cartService.deleteCartitem(ids);
		if(deleteCartitem) {
			return "redirect:getCart";
		}else {
			return "redirect:../error.jsp";
		}
		
	}
	
}
