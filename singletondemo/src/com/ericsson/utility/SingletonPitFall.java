package com.ericsson.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonPitFall {

	public static void main(String[] args) {
		//reflection
		LazySingleton instance1 = LazySingleton.getInstance();
		LazySingleton instance2 = null; 
    Constructor[] constructors=LazySingleton.class.getDeclaredConstructors();  
    
    for(Constructor constructor : constructors)
    {
    	constructor.setAccessible(true);//changing private to public
    	 try {
			instance2 = (LazySingleton) constructor.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		} 
         break; 
    }
    System.out.println("instance1.hashCode():- " 
            + instance1.hashCode()); 
System.out.println("instance2.hashCode():- " 
            + instance2.hashCode()); 
} 
		
		
		
	

}
