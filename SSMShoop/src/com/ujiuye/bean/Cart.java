package com.ujiuye.bean;

import java.util.List;

public class Cart {
    private Integer cid;

    private String cdis;

    private Integer uid;
    
    private List<Cartitem> cartitems;
    
    
    public List<Cartitem> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<Cartitem> cartitems) {
		this.cartitems = cartitems;
	}

	public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCdis() {
        return cdis;
    }

    public void setCdis(String cdis) {
        this.cdis = cdis == null ? null : cdis.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}