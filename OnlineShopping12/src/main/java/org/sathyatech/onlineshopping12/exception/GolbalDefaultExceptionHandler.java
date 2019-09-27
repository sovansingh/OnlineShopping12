package org.sathyatech.onlineshopping12.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GolbalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNohandlerFoundException() {
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is not constructed!");
		
		mv.addObject("errorDescription", "the Page you are looking for is not available now!");
		
		mv.addObject("title", "404 Error Page");
		
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundExcpetion.class)
	public ModelAndView  handlerProductNotFoundException() {
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle", "Product Nt Availbale!");
		
		mv.addObject("errorDescription", "The Product you are looking for is not available right now!");
		
		mv.addObject("title", "Product Unavailable");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView  handlerException(Exception ex) {
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle", "Contact Your Administrator!");
		
		/**
		 * Only for Debugging your Application
		 */
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription", sw.toString());
		
		mv.addObject("title", "Error");
		
		return mv;
	}
	
	
}
