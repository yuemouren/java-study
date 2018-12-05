package com.ujiuye.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Product implements Serializable {
	
	private int pid;
	private String pname;
	private double marketprice;
	private double shopprice;
	private String pimage;
	private Date pdate;
	private int ishot;
	private String pdesc;
	private int pflag;
	private double weight;
	private double floated;
	private List<ProductDetail> prodetail;
	private List<EvaluateVo> evaluates;
	
	
	public List<EvaluateVo> getEvaluates() {
		return evaluates;
	}
	public void setEvaluates(List<EvaluateVo> evaluates) {
		this.evaluates = evaluates;
	}
	public List<ProductDetail> getProdetail() {
		return prodetail;
	}
	public void setProdetail(List<ProductDetail> prodetail) {
		this.prodetail = prodetail;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(double marketprice) {
		this.marketprice = marketprice;
	}
	public double getShopprice() {
		return shopprice;
	}
	public void setShopprice(double shopprice) {
		this.shopprice = shopprice;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getIshot() {
		return ishot;
	}
	public void setIshot(int ishot) {
		this.ishot = ishot;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public int getPflag() {
		return pflag;
	}
	public void setPflag(int pflag) {
		this.pflag = pflag;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getFloated() {
		return floated;
	}
	public void setFloated(double floated) {
		this.floated = floated;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", marketprice=" + marketprice + ", shopprice=" + shopprice
				+ ", pimage=" + pimage + ", pdate=" + pdate + ", ishot=" + ishot + ", pdesc=" + pdesc + ", pflag="
				+ pflag + ", weight=" + weight + ", floated=" + floated + ", prodetail=" + prodetail + ", evaluates="
				+ evaluates + "]";
	}
	
	
}
