package com.ujiuye.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ujiuye.bean.Computer;
import com.ujiuye.dao.ComputerDao;
import com.ujiuye.util.Page;

@Service
public class ComputerServiceImpl implements ComputerService {
	
	@Resource
	private ComputerDao  computerDao;
	
	
	@Override
	@Transactional
	public int saveComputer(Computer com) {
		return computerDao.saveComputer(com);
	}


	@Override
	@Transactional
	public List<Computer> getAllInfo(Page page) {
		
		return computerDao.getAllInfo(page);
	}


	@Override
	@Transactional
	public String deleteOneInfo(int cid) {
		
		return computerDao.deleteOneInfo(cid);
	}


	@Override
	@Transactional
	public Computer getOneInfo(int cid) {
		
		return computerDao.getOneInfo(cid);
	}


	@Override
	@Transactional
	public boolean updateOneInfo(Computer com) {
		
		return computerDao.updateOneInfo(com);
	}


	@Override
	public int getCount() {
		return computerDao.getCount();
	}


	@Override
	public boolean deleteBatchInfo(String ids) {
		
		return computerDao.deleteBatchInfo(ids);
	}

}
