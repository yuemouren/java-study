package com.ujiuye.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ujiuye.bean.Category;
import com.ujiuye.dao.CategoryDao;
import com.ujiuye.util.C3P0DataSource;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> getAllInfo() {
		String sql = "select cid,cname from category";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql,new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
