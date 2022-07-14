package com.ericsson.utility;

import java.time.LocalDate;

public class VarargsDemo {

	
	public static void testData(String... skills)
	{
		
		for(String skill : skills)
			System.out.println(skill);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         /*testData();
         testData("C");
         testData("C","Java");
         testData("C","Java","Akka");*/
         
         Product p1 =new Product(1,"Book",LocalDate.of(2019, 2, 1));
         Product p2 =new Product(21,"NotePro",LocalDate.of(2019, 5, 1));
         Product p3 =new Product(22,"Laptop",LocalDate.of(2019, 3, 1));         
         System.out.println(p1);
         
         
         
	}

}
