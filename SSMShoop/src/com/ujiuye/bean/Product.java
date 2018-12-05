package com.ujiuye.bean;

import java.util.Date;
import java.util.List;

public class Product {
    private Integer pid;

    private String pname;

    private Double marketprice;

    private Double shopprice;

    private String pimage;

    private Date pdate;

    private Integer ishot;

    private String pdesc;

    private Integer pflag;

    private Double weight;

    private Double floated;
    
    private List<Productdetail> prodetails;
    
    private List<Evaluate> evaluates;
    
    
    public List<Evaluate> getEvaluates() {
		return evaluates;
	}

	public void setEvaluates(List<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}

	public void setProdetails(List<Productdetail> prodetails) {
		this.prodetails = prodetails;
	}

	public List<Productdetail> getProdetails() {
		return prodetails;
	}

	public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Double getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(Double marketprice) {
        this.marketprice = marketprice;
    }

    public Double getShopprice() {
        return shopprice;
    }

    public void setShopprice(Double shopprice) {
        this.shopprice = shopprice;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage == null ? null : pimage.trim();
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Integer getIshot() {
        return ishot;
    }

    public void setIshot(Integer ishot) {
        this.ishot = ishot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc == null ? null : pdesc.trim();
    }

    public Integer getPflag() {
        return pflag;
    }

    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getFloated() {
        return floated;
    }

    public void setFloated(Double floated) {
        this.floated = floated;
    }
}