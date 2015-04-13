package soen.management.app;

import soen.management.app.User;

public class ManagementApp {
	public static User user;
	public static User user2;
	
	public static void main(String[] args) {
		User user = new User("Nikki");
		System.out.println(user.getUserID());
	}
}
