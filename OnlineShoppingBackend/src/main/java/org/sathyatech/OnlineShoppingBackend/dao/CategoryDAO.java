package org.sathyatech.OnlineShoppingBackend.dao;

import java.util.List;

import org.sathyatech.OnlineShoppingBackend.dto.Category;

public interface CategoryDAO {

	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
}
