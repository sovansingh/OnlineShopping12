package org.sathyatech.OnlineShoppingBackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.sathyatech.OnlineShoppingBackend.dao.CategoryDAO;
import org.sathyatech.OnlineShoppingBackend.dto.Category;
import org.springframework.stereotype.Repository;

@Repository("categoryDAO")
//@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<Category>();

	static {
		Category category = new Category();
		// adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("this is some description for television");
		category.setImageURL("CAT_1.jpg");
		// category.setActive(true);
		categories.add(category);

		// adding second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("this is some description for mobile");
		category.setImageURL("CAT_2.jpg");
		// category.setActive(true);
		categories.add(category);

		// adding third category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("this is some description for laptop");
		category.setImageURL("CAT_3.jpg");
		// category.setActive(true);
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		//enhanced for loop
		for (Category category : categories) {
			if(category.getId() == id) 
				return category;
			
		}
		return null;
	}

	/*
	 * @Autowired private SessionFactory sessionFactory;
	 * 
	 * @Override public Category get(int id) { return sessionFactory
	 * .getCurrentSession() .get(Category.class, Integer.valueOf(id)); }
	 * 
	 * @Override public List<Category> list() { String
	 * selectActiveCategory="FROM Category WHERE active := active"; Query
	 * query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
	 * query.setParameter("active", true); return query.getResultList(); }
	 * 
	 * @Override public boolean add(Category category) { try {
	 * sessionFactory.getCurrentSession().persist(category); return true; } catch
	 * (Exception e) { e.printStackTrace(); return false; } }
	 * 
	 * @Override public boolean update(Category category) { try {
	 * sessionFactory.getCurrentSession().update(category); return true; } catch
	 * (Exception e) { e.printStackTrace(); return false; } }
	 * 
	 * @Override public boolean delete(Category category) {
	 * category.setActive(true); try {
	 * sessionFactory.getCurrentSession().update(category); return true; } catch
	 * (Exception e) { e.printStackTrace(); return false; } }
	 */

}
