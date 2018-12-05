package com.ujiuye.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ujiuye.bean.Product;
import com.ujiuye.dao.ProductDao;
import com.ujiuye.util.C3P0DataSource;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> getHotProduct() {
		String sql = "select * from product where ishot=1 limit 0,9";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql,new BeanListHandler<Product>(Product.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getNewProduct() {
		String sql = "SELECT * FROM product  ORDER BY pdate DESC LIMIT 0,9";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql,new BeanListHandler<Product>(Product.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product getOneInfo(int pid) {
		String sql = "SELECT * FROM product where pid=?";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql,new BeanHandler<Product>(Product.class),pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getCount(Integer cid,String like) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		String sql= "select count(*) ct from product";
		if(cid != null) {
			sql += " WHERE pid IN (SELECT pid FROM pro_cat WHERE cid = ?)";
		}else if(like != null){
			sql += " WHERE pname like ?";
		}
		try {
			conn = C3P0DataSource.getDs().getConnection();
			ps = conn.prepareStatement(sql);
			if(cid != null) {
				ps.setInt(1,cid);
			}else if(like != null){
				ps.setString(1,like);
			}
			
			rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Product> getProByCid(int cid, int start, int size) {
		String sql = "SELECT * FROM product WHERE pid IN (SELECT pid FROM pro_cat WHERE cid = ?) LIMIT ?,?";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql,new BeanListHandler<Product>(Product.class),cid,start,size);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getOneInfo(String ids) {
		String sql = "select * from product where pid in("+ids+")";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql,new BeanListHandler<Product>(Product.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> likeSearch(String like,int start,int size) {
		String sql="select * from product where pname like ? limit ?,?";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql, new BeanListHandler<Product>(Product.class),like,start,size);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAllInfo(int start,int size) {
		String sql="select * from product limit ?,?";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql, new BeanListHandler<Product>(Product.class),start,size);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean savePro(Product product, int cid) {
		String sql = "insert into product(pid,pname,marketprice,shopprice,pimage,pdate,ishot,pdesc) values(?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			int count = qr.update(sql,product.getPid(),product.getPname(),product.getMarketprice(),product.getShopprice(),product.getPimage(),product.getPdate(),product.getIshot(),product.getPdesc());
			if(count > 0 ) {
				sql="insert into pro_cat(pid,cid) values(?,?)";
				int update = qr.update(sql,product.getPid(),cid);
				if((update+count) > 1) {
					return true;
				}
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
