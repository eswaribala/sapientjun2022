package com.ericsson.utility;

public class LazySingleton {
	private static LazySingleton instance;
	//=new LazySingleton();

    /** Don't let anyone else instantiate this class */
    private LazySingleton() {
		/*
		 * if(instance != null) { throw new
		 * IllegalStateException("Singleton already initialized"); }
		 */
    }

    /** Lazily create the instance when it is accessed for the first time */
    public static synchronized LazySingleton getInstance() {
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
