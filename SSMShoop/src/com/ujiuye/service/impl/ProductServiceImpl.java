package com.ujiuye.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ujiuye.bean.EvaluateExample;
import com.ujiuye.bean.ProCatExample;
import com.ujiuye.bean.ProCatKey;
import com.ujiuye.bean.Product;
import com.ujiuye.bean.ProductExample;
import com.ujiuye.bean.ProductdetailExample;
import com.ujiuye.bean.ProductdetailExample.Criteria;
import com.ujiuye.mapper.EvaluateMapper;
import com.ujiuye.mapper.ProCatMapper;
import com.ujiuye.mapper.ProductMapper;
import com.ujiuye.mapper.ProductdetailMapper;
import com.ujiuye.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductMapper productMapper;
	@Resource
	private ProCatMapper proCatMapper;
	
	@Override
	public List<Product> getHot() {
		
		return productMapper.getHot();
	}

	@Override
	public List<Product> getNew() {
		
		return productMapper.getNew();
	}

	@Override
	public Product getPro(int pid) {
		return productMapper.selectByPrimaryKey(pid);
	}

	@Override
	public List<Product> getProByCid(int cid) {
		
		return productMapper.getProByCid(cid);
	}

	@Override
	public List<Product> likeSerach(String name) {
		ProductExample pe = new ProductExample();
		com.ujiuye.bean.ProductExample.Criteria criteria = pe.createCriteria();
		criteria.andPnameLike("%"+name+"%");
		return productMapper.selectByExample(pe);
	}

	@Override
	public List<Product> getAllPro(int start,int pagesize) {
		return productMapper.getAllPro((start-1)*pagesize, pagesize);
	}

	@Override
	public int getCount(ProductExample example) {
		
		return productMapper.countByExample(example);
	}

	@Override
	@Transactional
	public boolean addProduct(Product product, int cid) {
		
		int insert = productMapper.insert(product);
		ProCatKey pk = new  ProCatKey();
		pk.setPid(product.getPid());
		pk.setCid(cid);
		int insert2 = proCatMapper.insert(pk);
		if(insert > 0 && insert2 > 0) {
			return true;
		}
		return false;
	}
  
}
