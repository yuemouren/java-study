package com.ujiuye.bean;

import java.io.Serializable;

public class CartItem implements Serializable {
	
	private int id;
	private double subtotal;
	private int count;
	private Product product;
	private int pid;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", subtotal=" + subtotal + ", count=" + count + ", product=" + product + ", pid="
				+ pid + "]";
	}
	
}
