package org.sathyatech.OnlineShoppingBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.sathyatech.OnlineShoppingBackend.dao.UserDAO;
import org.sathyatech.OnlineShoppingBackend.dto.Address;
import org.sathyatech.OnlineShoppingBackend.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User getByEmail(String email) {
		String query="FROM User WHERE email := email";
		try {
			return sessionFactory.getCurrentSession()
				.createQuery(query,User.class)
					.setParameter("email", email)
						.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(User.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean add(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Address getAddress(int addressId) {
		try {
			return sessionFactory.getCurrentSession().get(Address.class,addressId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().update(address);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Address getBillingAddress(int userId) {
		String query="FROM Address WHERE userId := userId AND billing := isbilling";
		try {
			return sessionFactory.getCurrentSession().createQuery(query,Address.class)
					.setParameter("userId", userId)
					.setParameter("isbilling", true)
						.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddress(int userId) {
		String query="FROM Address WHERE userId := userId AND shipping := shipping ORDER BY id DESC";
		return sessionFactory
				.getCurrentSession()
					.createQuery(query,Address.class)
						.setParameter("userId", userId)
						.setParameter("shipping", true)
							.getResultList();

	}

}
