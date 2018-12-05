package com.ujiuye.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class BeanHandler implements MyBeanHandler {
	//获取单个对象
	private Class cls;
	public BeanHandler(Class cls){
		this.cls = cls;
	}
	@Override
	public Object getObject(ResultSet rs) {
		
		ResultSetMetaData rsd = null;
		try {
			rs.next();
			rsd = rs.getMetaData();
			int count = rsd.getColumnCount();
			Object obj = cls.newInstance();
			for(int i = 1;i <= count;i++){
				Object columnValue = rs.getObject(i);
				String  columnName = rsd.getColumnName(i);
				Field field =  cls.getDeclaredField(columnName);
				field.setAccessible(true);
				field.set(obj, columnValue);
			}
			return obj;
		} catch (Exception e) {
			// TODO: handle exception
		}
        return null;	
	}
}
