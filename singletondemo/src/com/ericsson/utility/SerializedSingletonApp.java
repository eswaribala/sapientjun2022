package com.ericsson.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializedSingletonApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
        { 
			SerializedSingleton instance1 = SerializedSingleton.instance; 
            ObjectOutput out 
                = new ObjectOutputStream(new FileOutputStream("file.txt")); 
            out.writeObject(instance1); 
            out.close(); 
      
            // deserialize from file to object 
            ObjectInput in  
                = new ObjectInputStream(new FileInputStream("file.txt")); 
              
            SerializedSingleton instance2 = (SerializedSingleton) in.readObject(); 
            in.close(); 
      
            System.out.println("instance1 hashCode:- "
                                                 + instance1.hashCode()); 
            System.out.println("instance2 hashCode:- " 
                                                 + instance2.hashCode()); 
        }  
          
        catch (Exception e)  
        { 
            e.printStackTrace(); 
        } 
	}

}
