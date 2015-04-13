package soen.management.app;

import java.util.ArrayList;

public class User {
	private int userID;
	private static int nextID = 1;
	private String name;
	private Activity activties[];
	private int Hours[][];
	
	
	public User(String name){
		this.name = name;
		ArrayList<Activity> activites = new ArrayList<Activity>();
		this.userID = nextID;
		nextID++;
	}
	
	public int getUserID(){
		String id = ""+userID;
		id = id.format("%03d",userID); //Adds zeros in front of string.
		return Integer.parseInt(id);
	}

	public String getName(){
		return this.name;
	}
}
