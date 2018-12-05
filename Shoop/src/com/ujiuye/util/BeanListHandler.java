package com.ujiuye.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
//运用反射，将取到的对象存到list集合中
public class BeanListHandler implements MyBeanHandler {
	
	private Class cls;
	public BeanListHandler(Class cls) {
		this.cls = cls;
	}
	
	@Override
	public Object getObject(ResultSet rs) {
		
		ResultSetMetaData rsd = null;
		List<Object> list = new ArrayList<>();
		try {
			
			rsd = rs.getMetaData();
			int count = rsd.getColumnCount();
			while(rs.next()){
				Object object = cls.newInstance();
				for(int i = 1;i <= count;i++){
					String columnName = rsd.getColumnName(i);
					Object columnValue = rs.getObject(i);
					Field field = cls.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(object,columnValue);
				}
				list.add(object);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
