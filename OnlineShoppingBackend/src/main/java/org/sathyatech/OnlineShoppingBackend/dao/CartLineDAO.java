package org.sathyatech.OnlineShoppingBackend.dao;

import java.util.List;

import org.sathyatech.OnlineShoppingBackend.dto.Cart;
import org.sathyatech.OnlineShoppingBackend.dto.CartLine;
import org.sathyatech.OnlineShoppingBackend.dto.OrderDetail;

public interface CartLineDAO {

	public List<CartLine> list(int cartId);
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean remove(CartLine cartLine);
	
	public CartLine getbyCatAndProduct(int cartId,int productId);
	
	boolean updateCart(Cart cart);
	
	public List<CartLine> listAvailable(int cartId);
	
	boolean addOrderDetail(OrderDetail orderDetail);
}
