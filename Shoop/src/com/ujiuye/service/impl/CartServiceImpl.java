package com.ujiuye.service.impl;

import java.util.List;

import com.ujiuye.bean.Cart;
import com.ujiuye.bean.CartItem;
import com.ujiuye.bean.Product;
import com.ujiuye.dao.CartItemDao;
import com.ujiuye.dao.ProductDao;
import com.ujiuye.dao.impl.CartItemDaoImpl;
import com.ujiuye.dao.impl.ProductDaoImpl;
import com.ujiuye.service.CartService;

public class CartServiceImpl implements CartService {
	
	private CartItemDao dao = new CartItemDaoImpl();
	private ProductDao pdao = new ProductDaoImpl();
	@Override
	public Cart getProCartByCid(Cart cart) {
		List<CartItem> cartItems = dao.getCartItem(cart.getCid());
		for(CartItem item : cartItems) {
			Product product = pdao.getOneInfo(item.getPid());
			item.setProduct(product);
		}
		cart.setCartitem(cartItems);
		return cart;
	}

}
