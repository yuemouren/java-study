package com.ujiuye.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ujiuye.bean.EvaluateVo;
import com.ujiuye.bean.Product;
import com.ujiuye.bean.ProductDetail;
import com.ujiuye.dao.EvaluateDao;
import com.ujiuye.dao.ProductDao;
import com.ujiuye.dao.ProductDetailDao;
import com.ujiuye.dao.impl.EvaluateDaoImpl;
import com.ujiuye.dao.impl.ProductDaoImpl;
import com.ujiuye.dao.impl.ProductDetailDaoImpl;
import com.ujiuye.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDao dao = new ProductDaoImpl();
	private ProductDetailDao pdao = new ProductDetailDaoImpl();
	private EvaluateDao edao = new EvaluateDaoImpl();
	@Override
	public Map<String,List<Product>>  getIndexProduct() {
		List<Product> hotProduct = dao.getHotProduct();
		List<Product> newProduct = dao.getNewProduct();
		
		Map<String,List<Product>> map = new HashMap<String,List<Product>>();
		map.put("hot",hotProduct);
		map.put("newPro", newProduct);
		return map;
	}
	@Override
	public Product getOneInfo(int pid) {
		Product product = dao.getOneInfo(pid);
		List<ProductDetail> detailByUid = pdao.getDetailByUid(pid);
		product.setProdetail(detailByUid);
		List<EvaluateVo> evalByPid = edao.getEvalByPid(pid);
		product.setEvaluates(evalByPid);
		return product;
	}
	@Override
	public List<Product> getOneInfo(String ids) {
		
		return dao.getOneInfo(ids);
	}
	@Override
	public List<Product> getAllInfo(int pagesize, int size) {
		
		return dao.getAllInfo(((pagesize-1)*size), size);
	}
	@Override
	public int getCount(Integer cid, String like) {
		// TODO Auto-generated method stub
		return dao.getCount(cid, like);
	}
	@Override
	public boolean savePro(Product product, int cid) {
		
		return dao.savePro(product, cid);
	}
}
