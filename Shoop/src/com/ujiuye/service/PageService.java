package com.ujiuye.service;

import java.util.List;

import com.ujiuye.bean.Product;
import com.ujiuye.dao.ProductDao;
import com.ujiuye.dao.impl.ProductDaoImpl;

public class PageService {
	
	private int start;//开始位置
	private int size;//显示的个数
	private int total;//
	private int count;
	private int currentPage;
	private Integer cid;
	private String like;
	
	private ProductDao dao = new ProductDaoImpl();
	
	public PageService() {
		super();
	}
	public PageService(int size, int currentPage,Integer cid,String like) {
		this.cid = cid;
		this.size = size;
		this.like = like;
		this.currentPage = currentPage;
		this.count = dao.getCount(cid,"%"+like+"%");
		this.start = (currentPage-1)*size;
		this.total = (count%size) == 0 ?(count/size) :(count/size)+1;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public ProductDao getDao() {
		return dao;
	}
	public void setDao(ProductDao dao) {
		this.dao = dao;
	}
	public List<Product> getProByCid(){
		return dao.getProByCid(cid, start, size);
	}
	public List<Product> likeSearch(){
		return dao.likeSearch("%"+like+"%", start, size);
	}
}
