package org.sathyatech.OnlineShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.sathyatech.OnlineShoppingBackend.dao.CategoryDAO;
import org.sathyatech.OnlineShoppingBackend.dto.Category;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.sathyatech.OnlineShoppingBackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() { category=new Category();
	 * 
	 * 
	 * category.setName("Television");
	 * category.setDescription("This is some description for television");
	 * category.setImageURL("CAT_1.jpg");
	 * 
	 * category.setName("Laptop");
	 * category.setDescription("This is some description for laptop");
	 * category.setImageURL("CAT_2.jpg");
	 * assertEquals("Successfully added a category inside the table", true,
	 * categoryDAO.add(category)); }
	 */
	
	/*
	 * @Test public void testGetCategory() { category=categoryDAO.get(1);
	 * assertEquals("Successfully fetched single category from the table"
	 * ,"Television" ,category.getName()); }
	 */
	
	/*
	 * @Test public void testUpdateCategory() { category=categoryDAO.get(1);
	 * category.setName("TV");
	 * assertEquals("Successfuly update a single category in the table", true,
	 * categoryDAO.update(category)); }
	 */
	
	/*
	 * @Test public void testDeleteCategory() { category=categoryDAO.get(1);
	 * assertEquals("Successfully deleted a single category in the table", true,
	 * categoryDAO.delete(category)); }
	 */
	
	/*
	 * @Test public void testListCategory() {
	 * assertEquals("Successfully fetched the list of categories from the table", 1,
	 * categoryDAO.list().size()); }
	 */
	
	@Test
	public void testCURDCategory() {
		//add operations
		category =new Category();
		
		category.setName("Mobile");
		category.setDescription("This is some description for Mobile!");
		category.setImageURL("CAT_3.jpg");
		
		category.setName("Television");
		category.setDescription("This is some description for Television!");
		category.setImageURL("CAT_4.jpg");
		
		assertEquals("Succesfully added a category inside a table", true, categoryDAO.add(category));
		
		//fetchin and Updating operations
		category=categoryDAO.get(1);
		category.getName();
		assertEquals("Successfully updated a single category in the table", true, categoryDAO.update(category));
		
		//delete the category
		assertEquals("Successfully deleted a single category in the table", true, categoryDAO.delete(category));
		
		//fetching the list
		assertEquals("Successfully added the list of categories from the table", 1, categoryDAO.list().size());
	}
}  
