package org.sathyatech.onlineshopping12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting", "Welcome to Spring WEB MVC");
		return mv;
	}
	
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false) String greeting) {
		if(greeting == null) {
			greeting="hello there!";
		}
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
	
	@RequestMapping(value="/test1/{greeting}")
	public ModelAndView test1(@PathVariable("greeting") String greeting) {
		if(greeting == null) {
			greeting="Hello There !";
		}
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
		
	}
	/*
	 * @Autowired private CategoryDAO dao;
	 * 
	 * @RequestMapping(value= {"/","home","index"}) public ModelAndView index() {
	 * ModelAndView mav=new ModelAndView("page"); mav.addObject("title", "Home");
	 * mav.addObject("categories", dao.list()); mav.addObject("userClickHome",
	 * true); return mav; }
	 * 
	 * @RequestMapping(value= "/about") public ModelAndView about() { ModelAndView
	 * mav=new ModelAndView("page"); mav.addObject("title", "About Us");
	 * mav.addObject("userClickAbout", true); return mav; }
	 * 
	 * @RequestMapping(value= "/contact") public ModelAndView contact() {
	 * ModelAndView mav=new ModelAndView("page"); mav.addObject("title",
	 * "Contact Us"); mav.addObject("userClickContact", true); return mav; }
	 * 
	 * 
	 * Method to Load All Products and based on category
	 * 
	 * @RequestMapping(value= "/show/all/products") public ModelAndView
	 * showAllProducts() { ModelAndView mav=new ModelAndView("page");
	 * mav.addObject("title", "All Products"); mav.addObject("categories",
	 * dao.list()); mav.addObject("userClickAllProducts", true); return mav; }
	 * 
	 * @RequestMapping(value= "/show/category/{id}/products") public ModelAndView
	 * showcategoryProducts(@PathVariable("id") int id) { //category DAO to fetch a
	 * single category Category category=null; category=dao.get(id); ModelAndView
	 * mav=new ModelAndView("page"); mav.addObject("title", category.getName());
	 * mav.addObject("categories", dao.list()); mav.addObject("category", category);
	 * mav.addObject("userClickCategoryProducts", true); return mav; }
	 */}
