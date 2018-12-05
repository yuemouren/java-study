package com.ujiuye.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ujiuye.bean.Computer;
import com.ujiuye.util.Page;

@Repository
public class ComputerDaoImpl implements ComputerDao {
	
	@Resource
	private HibernateTemplate  hibernateTemplate;
	
	@Override
	public int saveComputer(Computer com) {
		hibernateTemplate.save(com);
		return com.getCid();
	}

	@Override
	public List<Computer> getAllInfo(Page page) {
		Query query = hibernateTemplate.getSessionFactory().openSession().createQuery("from Computer");
		query.setFirstResult((page.getCurrentPage()-1)*page.getPerPageRows());
		query.setMaxResults(page.getPerPageRows());
		List<Computer> list = query.list();
		return list;
	}

	@Override
	public String deleteOneInfo(int cid) {
		Computer com = (Computer)hibernateTemplate.get(Computer.class,cid);
		hibernateTemplate.delete(com);
		return "success";
	}

	@Override
	public Computer getOneInfo(int cid) {
		Computer com = (Computer)hibernateTemplate.get(Computer.class, cid);
		return com;
	}

	@Override
	public boolean updateOneInfo(Computer com) {
		Query query = hibernateTemplate.getSessionFactory().openSession().createQuery("update Computer c set c.name=?,c.bir=?,c.price=? where c.cid=?");
		query.setString(0,com.getName());
		query.setDate(1,com.getBir());
		query.setDouble(2,com.getPrice());
		query.setInteger(3,com.getCid());
		int executeUpdate = query.executeUpdate();
		if(executeUpdate > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getCount() {
		Query query = hibernateTemplate.getSessionFactory().openSession().createQuery("select count(*) from Computer");
		int count = Integer.parseInt((query.list().get(0).toString()));
		return count;
	}

	@Override
	public boolean deleteBatchInfo(String ids) {
		Query query = hibernateTemplate.getSessionFactory().openSession().createQuery("delete Computer where cid in("+ids+")");
		int update = query.executeUpdate();
		if(update > 0) {
			return true;
		}
		return false;
	}

}
