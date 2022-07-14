package com.ericsson.utility;

import java.time.LocalDate;

public class Product {
	
	private int productId;
	private String name;
	private LocalDate dop;
	public Product(int productId, String name, LocalDate dop) {
		super();
		this.productId = productId;
		this.name = name;
		this.dop = dop;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Product Id="+this.productId+"\t"+"Product Name="+this.name+"\t"
				+"DOP="+dop.toString();
	}
	
	
	

}
