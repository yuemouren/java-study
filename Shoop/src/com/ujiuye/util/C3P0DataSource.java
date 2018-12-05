package com.ujiuye.util;



import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class C3P0DataSource {
	
	static ComboPooledDataSource ds = null;
	static {
		ds = new ComboPooledDataSource();
	}
	public static DataSource getDs() {
		return ds;
	}
	
}
