package com.ujiuye.util;

import java.util.Random;

public class IdUtil {
	
	public static int getId(){
		Random rd = new Random();
		return rd.nextInt(1000000000);
	}
}
