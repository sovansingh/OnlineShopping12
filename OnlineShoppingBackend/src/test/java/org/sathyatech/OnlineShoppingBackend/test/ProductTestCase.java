package org.sathyatech.OnlineShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.sathyatech.OnlineShoppingBackend.dao.ProductDAO;
import org.sathyatech.OnlineShoppingBackend.dto.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO dao;
	
	private static Product p;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("org.sathyatech.OnlineShoppingBackend");
		context.refresh();
		dao=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testCRUDProduct() {
		//create operation
		p=new Product();
		p.setName("oppo Selfie S53");
		p.setBrand("oppo");
		p.setDescription("This is a description of oppo mobile");
		p.setUnitPrice(25000);
		p.setActive(true);
		p.setCategoryId(3);
		p.setSupplierId(3);
		
		assertEquals("Something went wrong when inserting a new product!", true, dao.add(p));
		
		//reading or updating the category
		p=dao.get(2);
		p.setName("Samsung Galaxy S7");
		assertEquals("Something went wrong while updating the new record!", true, dao.update(p));
		assertEquals("Something went wrong while deleting the existing record!", true, dao.delete(p));
		
		//list
		assertEquals("Something went wrong while fetching the list of products!", 6, dao.list().size());
	}
	
	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products", 5, dao.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products", 3,dao.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products", 2,dao.listActiveProductsByCategory(1).size());
	}
	
	@Test
	public void testGetLatestActiveProducts() {
		assertEquals("Something went wrong while fetchiing the list of products", 3,dao.getLatestActiveProducts(3).size());
	}
}
