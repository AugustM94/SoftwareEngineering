package soen.management.app;

import java.util.ArrayList;

public class NonProjectActivity {
	private int nonProjectActivityID; 
	private String name;
	private int startDate;
	private int endDate;
	private ArrayList<Integer> assignedUsers;
	private int timeStamp;
	private boolean active;
	static ManagementApp managementApp = new ManagementApp();

	public NonProjectActivity(String name){
		this.name = name;
		this.nonProjectActivityID = managementApp.getActivityArray().size();;
		this.timeStamp = (int) (System.currentTimeMillis() / 1000L);
		this.assignedUsers = new ArrayList<Integer>();
	}
	
	private int getNonProjectActivityID() {
		return nonProjectActivityID;
	}

	void setNonProjectActivityID(int nonProjectActivityID) {
		this.nonProjectActivityID = nonProjectActivityID;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getStartDate() {
		return startDate;
	}

	void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	int getEndDate() {
		return endDate;
	}

	void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	ArrayList<Integer> getAssignedUsers() {
		return assignedUsers;
	}

	void setAssignedUsers(ArrayList<Integer> assignedUsers) {
		this.assignedUsers = assignedUsers;
	}

	int getTimeStamp() {
		return timeStamp;
	}

	void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}

	boolean isActive() {
		return active;
	}

	void setActive(boolean active) {
		this.active = active;
	}

}
