package soen.management.app;

import java.util.ArrayList;

public class User {
	private int userID;
	private String name;
	private ArrayList<Integer> projectID; //Projects of the user
	static ManagementApp managementApp = new ManagementApp();
	
	//AM
	public User(String name){
		this.name = name;
		this.projectID = new ArrayList<Integer>();
		this.userID = managementApp.getUserArray().size();
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

}
