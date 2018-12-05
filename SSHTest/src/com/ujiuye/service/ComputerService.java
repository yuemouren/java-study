package com.ujiuye.service;

import java.util.List;

import com.ujiuye.bean.Computer;
import com.ujiuye.util.Page;

public interface ComputerService {
	
	public int saveComputer(Computer com);
	
	public List<Computer> getAllInfo(Page page);
	
	public String deleteOneInfo(int cid);
	
	public Computer getOneInfo(int cid);
	
	public boolean updateOneInfo(Computer com);
	
	public int getCount();
	
	public boolean deleteBatchInfo(String ids);
}
