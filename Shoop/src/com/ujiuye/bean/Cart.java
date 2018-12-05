package com.ujiuye.bean;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {
	
	private int cid;
	private String cdis;
    private List<CartItem> cartitem;
	
    
	public List<CartItem> getCartitem() {
		return cartitem;
	}

	public void setCartitem(List<CartItem> cartitem) {
		this.cartitem = cartitem;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCdis() {
		return cdis;
	}

	public void setCdis(String cdis) {
		this.cdis = cdis;
	}

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", cdis=" + cdis + ", cartitem=" + cartitem + "]";
	}
	
	
}
