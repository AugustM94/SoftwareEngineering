package soen.management.app;

import soen.management.app.User;

public class Main {
	public static User user;
	
	public static void main(String[] args) {
		user = new User();
		System.out.println(user.getName());
		

	}
	
}
