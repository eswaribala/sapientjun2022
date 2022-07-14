package com.ericsson.models;

public class User {
	String name;
	String email;
	
	public User(String name,String email) {
		this.name= name;
		this.email = email;
	}
	
	public String toString() {
		return "Name of user:"+this.name+"\nEmail of User:"+this.email;
	}
}
