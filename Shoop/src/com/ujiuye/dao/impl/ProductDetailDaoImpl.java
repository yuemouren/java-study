package com.ujiuye.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ujiuye.bean.ProductDetail;
import com.ujiuye.dao.ProductDetailDao;
import com.ujiuye.util.C3P0DataSource;

public class ProductDetailDaoImpl implements ProductDetailDao {

	@Override
	public List<ProductDetail> getDetailByUid(int pid) {
		String sql = "select id,dis,imagepath from productdetail where pid=?";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql,new BeanListHandler<ProductDetail>(ProductDetail.class),pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
