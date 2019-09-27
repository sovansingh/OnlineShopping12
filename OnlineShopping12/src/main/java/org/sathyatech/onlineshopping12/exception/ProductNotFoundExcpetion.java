package org.sathyatech.onlineshopping12.exception;

import java.io.Serializable;

public class ProductNotFoundExcpetion extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public ProductNotFoundExcpetion( ) {
		this("product is not avalibale");
	}

	
	public ProductNotFoundExcpetion(String message) {
		this.message = System.currentTimeMillis()+": "+message;
	}


	public String getMessage() {
		return message;
	}
	
	
	
	
}
