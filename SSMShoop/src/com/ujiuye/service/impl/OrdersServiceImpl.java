package com.ujiuye.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.Cartitem;
import com.ujiuye.bean.CartitemExample;
import com.ujiuye.bean.CartitemExample.Criteria;
import com.ujiuye.bean.Orderitem;
import com.ujiuye.bean.OrderitemExample;
import com.ujiuye.bean.OrderitemVo;
import com.ujiuye.bean.Orders;
import com.ujiuye.bean.OrdersExample;
import com.ujiuye.bean.Product;
import com.ujiuye.bean.ProductExample;
import com.ujiuye.mapper.CartitemMapper;
import com.ujiuye.mapper.OrderitemMapper;
import com.ujiuye.mapper.OrdersMapper;
import com.ujiuye.mapper.ProductMapper;
import com.ujiuye.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Resource
	private OrdersMapper ordersmapper;
	@Resource
	private OrderitemMapper orderitemMapper;
	@Resource
	private CartitemMapper cartitemMapper;
	@Resource
	private ProductMapper productMapper;
	
	@Override
	@Transactional
	public boolean saveOrders(Orders orders,Cart cart) {
		
		int insert = ordersmapper.insert(orders);
		
		boolean flag = true;
		for(Cartitem ci : cart.getCartitems()) {
			Product product = ci.getProduct();
			Orderitem oi = new Orderitem();
			oi.setPid(product.getPid());
			oi.setCount(ci.getCount());
			oi.setOid(orders.getOid());
			oi.setSubtotal(ci.getSubtotal());
			int insert2 = orderitemMapper.insert(oi);
			if(insert2 <= 0) {
				flag = false;
			}
		}
		CartitemExample ce = new CartitemExample();
		Criteria criteria = ce.createCriteria();
		criteria.andCidEqualTo(cart.getCid());
		int deleteByExample = cartitemMapper.deleteByExample(ce);
		if(insert > 0&&deleteByExample > 0 && flag==true) {
			return true;
		}
		return false;
	}

	@Override
	public List<Orders> getAllOrders(int uid) {
		
		OrdersExample oe = new OrdersExample();
		com.ujiuye.bean.OrdersExample.Criteria criteria = oe.createCriteria();
		criteria.andUidEqualTo(uid);
		List<Orders> list = ordersmapper.selectByExample(oe);
		
		/*for(Orders os : list) {
			OrderitemExample oie = new OrderitemExample();
			com.ujiuye.bean.OrderitemExample.Criteria criteria2 = oie.createCriteria();
			criteria2.andOidEqualTo(os.getOid());
			List<Orderitem> selectByExample = orderitemMapper.selectByExample(oie);
			for(Orderitem oi : selectByExample) {
				oi.setProduct(productMapper.selectByPrimaryKey(oi.getPid()));
			}
			os.setOrderitems(selectByExample);
		}*/
		return list;
	}

	@Override
	public List<Orders> getAllOrders() {
		List<Orders> list = ordersmapper.selectByExample(null);
		/*for(Orders os : list) {
			OrderitemExample oie = new OrderitemExample();
			com.ujiuye.bean.OrderitemExample.Criteria criteria2 = oie.createCriteria();
			criteria2.andOidEqualTo(os.getOid());
			List<Orderitem> selectByExample = orderitemMapper.selectByExample(oie);
			for(Orderitem oi : selectByExample) {
				oi.setProduct(productMapper.selectByPrimaryKey(oi.getPid()));
			}
			os.setOrderitems(selectByExample);
		}*/
		return list;
	}

	@Override
	public List<OrderitemVo> getOrderitemVo() {
		
		return orderitemMapper.getOrderitemVo();
	}

}
