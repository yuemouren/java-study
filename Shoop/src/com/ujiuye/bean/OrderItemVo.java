package com.ujiuye.bean;

import java.io.Serializable;

public class OrderItemVo implements Serializable {
	
	private String pname;
	private int count;
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
