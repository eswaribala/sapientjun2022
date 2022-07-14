package com.ericsson.services;

import java.util.ArrayList;

import com.ericsson.models.User;


public class UserService {
	ArrayList<User> users;
	
	public UserService() {
		users = new ArrayList<>();
		users.add(new User("Albert","albert@gmail.com"));
		users.add(new User("Bob","bob@gmail.com"));
		users.add(new User("Gary","gary@gmail.com"));
		users.add(new User("Geno","geno@gmail.com"));
	}
	public ArrayList<User> getUsers(){
		return users;
	}
}
