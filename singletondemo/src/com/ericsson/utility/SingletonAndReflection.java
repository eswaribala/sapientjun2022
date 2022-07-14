package com.ericsson.utility;

import java.lang.reflect.Constructor;

/**
 * Java’s Reflection API is very powerful. You can use Reflection 
 * to instantiate a class even if the 
 * class’s constructor is private.
 * 
 * @author Balasubramaniam
 *
 */

/*class MySingleton {
    private static final MySingleton instance = new MySingleton();

    private MySingleton() {}

    public static MySingleton getInstance() {
        return instance;
    }
}*/

/**
 * Protection against singleton
 * @author Balasubramaniam
 *
 */
class MySingleton {
    private static final MySingleton instance = new MySingleton();

    private MySingleton() {
        // protect against instantiation via reflection
        if(instance != null) {
            throw new IllegalStateException("Singleton already initialized");
        }
    }

    public static MySingleton getInstance() {
        return instance;
    }
}

public class SingletonAndReflection {
	public static void main(String[] args) {
        MySingleton singletonInstance = MySingleton.getInstance();
        MySingleton reflectionInstance = null;
        System.out.println("singletonInstance hashCode: " + singletonInstance.hashCode());
        try {
            Constructor[] constructors = MySingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                reflectionInstance = (MySingleton) constructor.newInstance();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

       
        System.out.println("reflectionInstance hashCode: " + reflectionInstance.hashCode());
    }
}
