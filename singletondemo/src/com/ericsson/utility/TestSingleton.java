package com.ericsson.utility;

public class TestSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		EagerStaticBlockSingleton eagerStaticBlockSingletonInstance1 =EagerStaticBlockSingleton.getInstance(); 
	
		System.out.println(eagerStaticBlockSingletonInstance1.hashCode());
		EagerStaticBlockSingleton eagerStaticBlockSingletonInstance2 =EagerStaticBlockSingleton.getInstance(); 
		System.out.println(eagerStaticBlockSingletonInstance2.hashCode());
	}

}
