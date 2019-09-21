package org.sathyatech.OnlineShoppingBackend.dao;

import java.util.List;

import org.sathyatech.OnlineShoppingBackend.dto.Product;

public interface ProductDao {

	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	List<Product> getProductByParam(String param,int count);
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProduct(int count);
}
