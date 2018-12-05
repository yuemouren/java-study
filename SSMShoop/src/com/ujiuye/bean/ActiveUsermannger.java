package com.ujiuye.bean;

import java.io.Serializable;
import java.util.List;

public class ActiveUsermannger implements Serializable {

	private Integer userid;

	private String username;

	private String password;

	private List<Auth> parentes;

	private List<Auth> childs;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Auth> getParentes() {
		return parentes;
	}

	public void setParentes(List<Auth> parentes) {
		this.parentes = parentes;
	}

	public List<Auth> getChilds() {
		return childs;
	}

	public void setChilds(List<Auth> childs) {
		this.childs = childs;
	}
	
	
}
