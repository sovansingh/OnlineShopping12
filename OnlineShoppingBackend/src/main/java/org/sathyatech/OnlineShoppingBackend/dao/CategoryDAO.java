package org.sathyatech.OnlineShoppingBackend.dao;

import java.util.List;

import org.sathyatech.OnlineShoppingBackend.dto.Category;

public interface CategoryDAO {


	List<Category> list();
	Category get(int id);
	boolean add(Category category);	
	boolean update (Category category);
	boolean delete(Category category);
	
}
