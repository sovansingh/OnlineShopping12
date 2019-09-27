package org.sathyatech.OnlineShoppingBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.sathyatech.OnlineShoppingBackend.dao.CategoryDAO;
import org.sathyatech.OnlineShoppingBackend.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * private static List<Category> categories = new ArrayList<Category>();
	 * 
	 * static { Category category = new Category(); // adding first category
	 * category.setId(1); category.setName("Television");
	 * category.setDescription("this is some description for television");
	 * category.setImageURL("CAT_1.jpg"); // category.setActive(true);
	 * categories.add(category);
	 * 
	 * // adding second category category = new Category(); category.setId(2);
	 * category.setName("Mobile");
	 * category.setDescription("this is some description for mobile");
	 * category.setImageURL("CAT_2.jpg"); // category.setActive(true);
	 * categories.add(category);
	 * 
	 * // adding third category category = new Category(); category.setId(3);
	 * category.setName("Laptop");
	 * category.setDescription("this is some description for laptop");
	 * category.setImageURL("CAT_3.jpg"); // category.setActive(true);
	 * categories.add(category); }
	 */
	@Override
	public List<Category> list() {
		String selectActiveCategory="FROM Category WHERE active = :active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	/**
	 * Getting single category based on id
	 * 
	 */
	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		try {
			//add category to the database
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Updating a single category
	 */
	@Override
	public boolean update(Category category) {
		try {
			//update the category to the databae table.
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Deleting the category
	 */
	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


}
