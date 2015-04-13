package soen.management.app;

import java.util.ArrayList;

public class User {
	private int userID;
	private static int nextID = 1;
	private String name;
	private int activityID[];
	private int Hours[][];
	
	
	public User(String name){
		this.name = name;
		ArrayList<Integer> activityID = new ArrayList<Integer>();
		this.userID = nextID;
		nextID++;
	}
	
	public int getUserID(){
		Integer id = userID;
		String format = "%07d";
		String result = String.format(format,id); //Adds zeros in front of string.
		return Integer.parseInt(result);
	}

	public String getName(){
		return this.name;
	}
}
