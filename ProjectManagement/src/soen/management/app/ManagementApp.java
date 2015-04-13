package soen.management.app;

import soen.management.app.User;

public class ManagementApp {
	public static User user;
	public static User user2;
	
	public static void main(String[] args) {
		user = new User("Niki");
		user2 = new User("Martin");
		System.out.println(user2.getUserID());

	}
}
