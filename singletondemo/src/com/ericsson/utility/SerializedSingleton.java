package com.ericsson.utility;

import java.io.Serializable;

public class SerializedSingleton  implements Serializable{
	 // public instance initialized when loading the class 
    public static SerializedSingleton instance = new SerializedSingleton(); 
      
    private SerializedSingleton()  
    { 
        // private constructor 
    }     
	
	  Object readResolve() 
	  {
	  
	  return instance; 
	  }
	 
}
