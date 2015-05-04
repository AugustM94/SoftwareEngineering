package soen.management.app;

import java.util.ArrayList;

public class Activity {

	private int activityID; 
	private int projectID;
	private String name;
	private int startDate;
	private int endDate;
	private ArrayList<Integer> assignedUsers;
	private ArrayList<Integer> hoursSpendPerUser;
	private int hoursBudgeted;

	private int timeStamp;
	private boolean active;
	
	public Activity(String name, int projectID){
		this.name = name;
		this.activityID = 1;
		this.projectID = 1;
		this.timeStamp = (int) (System.currentTimeMillis() / 1000L);
	}

	

	
	// Getters and setters
	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public ArrayList<Integer> getAssignedUsers() {
		return assignedUsers;
	}

	public void setAssignedUsers(ArrayList<Integer> assignedUsers2) {
		this.assignedUsers = assignedUsers2;
	}

	public ArrayList<Integer> getHoursSpendPerUser() {
		return hoursSpendPerUser;
	}

	public void setHoursSpendPerUser(ArrayList<Integer> hoursSpendPerUser2) {
		this.hoursSpendPerUser = hoursSpendPerUser2;
	}

	public int getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getActivityID() {
		return activityID;
	}
	
	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}

	public int getHoursBudgeted() {
		return hoursBudgeted;
	}
	
	public void setHoursBudgeted(int hoursBudgeted) {
		this.hoursBudgeted = hoursBudgeted;
	}
	
	
	
	
	
	
}
