package com.ujiuye.bean;

import java.io.Serializable;
import java.sql.Timestamp;


public class Evaluate implements Serializable {
	private int eid;
	private String dis;
	private Timestamp etime;
	
	
	
	public Timestamp getEtime() {
		return etime;
	}
	public void setEtime(Timestamp etime) {
		this.etime = etime;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getDis() {
		return dis;
	}
	public void setDis(String dis) {
		this.dis = dis;
	}
	
}
