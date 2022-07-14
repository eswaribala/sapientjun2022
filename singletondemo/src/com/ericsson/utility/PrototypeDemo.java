package com.ericsson.utility;

import java.util.List;

import com.ericsson.models.User;
import com.ericsson.models.UserDetails;


public class PrototypeDemo {
	public static void main(String[] args) {
		UserDetails users = new UserDetails();
		users.getUsers();

		System.out.println("users List before clone: " + users.getUsersList());
		// Use the clone method to get the Employee object
		UserDetails usersNew;
		try {
			usersNew = (UserDetails) users.clone();
			UserDetails usersNew1 = (UserDetails) users.clone();
			List<User> list = usersNew.getUsersList();
			list.add(new User("Tim", "tim@gmail.com"));
			List<User> list1 = usersNew1.getUsersList();
			list1.remove(new User("steve", "steve@gmail.com"));

			System.out.println("users List: " + users.getUsersList());
			System.out.println("usersNew List: " + list);
			System.out.println("usersNew1 List: " + list1);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
