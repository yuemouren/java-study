package com.ujiuye.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujiuye.bean.Category;
import com.ujiuye.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Resource
	private CategoryService  categoryService;
	
	
	@RequestMapping("getCategory")
	@ResponseBody
	public  List<Category> getCategory(){
		
		return categoryService.getAll();
	}
}
