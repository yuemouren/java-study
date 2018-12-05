package com.ujiuye.bean;

import java.io.Serializable;

public class ProductDetail implements Serializable {
	
	private  int  id;
	private  String  dis;
	private  String imagepath;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDis() {
		return dis;
	}
	public void setDis(String dis) {
		this.dis = dis;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	
}
