package com.ujiuye.bean;

import java.io.Serializable;
import java.util.Date;

public class Computer implements Serializable {
	
	private int cid;
	private String name;
	private double price;
	private Date bir;
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getBir() {
		return bir;
	}
	public void setBir(Date bir) {
		this.bir = bir;
	}
	@Override
	public String toString() {
		return "Computer [cid=" + cid + ", name=" + name + ", price=" + price + ", bir=" + bir + "]";
	}
	
	
}
