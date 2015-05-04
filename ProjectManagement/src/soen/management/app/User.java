package soen.management.app;

import java.util.ArrayList;

public class User {
	private int userID;
	private String name;
	private ArrayList<Integer> projectID; //Projects of the user
	static ManagementApp managementApp = new ManagementApp();
	
	public User(String name){
		this.name = name;
		this.projectID = new ArrayList<Integer>();
		this.userID = managementApp.getUserArray().size()+1;
	}

	public int getUserID(){
		return userID;
	}
	
	public String getName(){
		return name;
	}

	public ArrayList<Integer> getProjects(){
		return projectID;
	}

	public ArrayList<Integer> getProjectID() {
		return projectID;
	}

	public void setProjectID(ArrayList<Integer> projectID) {
		this.projectID = projectID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
//	public String printUserID(){
//		Integer id = userID;
//		String format = "%07d";
//		String result = String.format(format,id); //Adds zeros in front of string.
//		return result;
//	}


}
