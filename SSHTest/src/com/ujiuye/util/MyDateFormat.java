package com.ujiuye.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateFormat {
	
	public static Date getDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
