package com.ujiuye.service.impl;

import java.util.List;

import com.ujiuye.bean.Category;
import com.ujiuye.dao.CategoryDao;
import com.ujiuye.dao.impl.CategoryDaoImpl;
import com.ujiuye.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao dao = new CategoryDaoImpl();
	@Override
	public List<Category> getAllInfo() {
		
		return dao.getAllInfo();
	}

}
