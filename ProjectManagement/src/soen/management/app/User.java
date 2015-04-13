package soen.management.app;

import java.util.ArrayList;

public class User {
	private int userID;
	private static int nextID = 1;
	private String name;
	private int projectID[]; //Projects of the user
	
	
	public User(String name, int userID, int[] projectID){
		this.name = name;
		ArrayList<Integer> projectID = new ArrayList<Integer>();
		this.userID = nextID;
		nextID++;
	}
	

	public int getUserID(){
		return userID;
	}
	
	public String getName(){
		return name;
	}

	
	
//	public String printUserID(){
//		Integer id = userID;
//		String format = "%07d";
//		String result = String.format(format,id); //Adds zeros in front of string.
//		return result;
//	}


}
