package com.ujiuye.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ujiuye.bean.User;
import com.ujiuye.dao.UserDao;
import com.ujiuye.util.C3P0DataSource;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean saveUser(User user) {
		String sql = "insert into user(uid,username,password,name,email,telephone,birthday,sex) values (?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			int update = qr.update(sql, user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex());
			if(update > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User login(String username, String password) {
		String sql = "select * from user where username=? and password=?";
		
		QueryRunner qr = new QueryRunner(C3P0DataSource.getDs());
		try {
			return qr.query(sql,new BeanHandler<User>(User.class),username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
