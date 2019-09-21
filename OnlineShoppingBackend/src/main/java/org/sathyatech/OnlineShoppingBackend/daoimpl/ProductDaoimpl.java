package org.sathyatech.OnlineShoppingBackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.sathyatech.OnlineShoppingBackend.dao.ProductDao;
import org.sathyatech.OnlineShoppingBackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("productDAO")
@Transactional
public class ProductDaoimpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory
						.getCurrentSession()
							.get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> list() {
			return sessionFactory
						.getCurrentSession()
							.createQuery("FROM Product",Product.class)
								.getResultList();

	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory
				.getCurrentSession()
					.update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(true);
			return this.update(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> getProductByParam(String param, int count) {
		String query="FOM Product WHERE active = true ORDER BY "+ param +"DESC";
		return sessionFactory
					.getCurrentSession()
						.createQuery(query,Product.class)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts="FROM Product WHERE active := active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts,Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory="FROM Product WHERE active := active AND categoryId := categoryId";
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectActiveProductsByCategory,Product.class)
							.setParameter("active", true)
								.setParameter("categoryId", categoryId)
									.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProduct(int count) {
		String selectLatestActiveProduct="FROM Product WHERE active :=active ORDER BY id";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectLatestActiveProduct,Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
	}

}
