package org.sathyatech.OnlineShoppingBackend.dao;

import java.util.List;

import org.sathyatech.OnlineShoppingBackend.dto.Address;
import org.sathyatech.OnlineShoppingBackend.dto.User;

public interface UserDAO {

	User getByEmail(String email);
	User get(int id);
	
	boolean add(User user);
	
	Address getAddress(int addressId);
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddress(int userId);
}
