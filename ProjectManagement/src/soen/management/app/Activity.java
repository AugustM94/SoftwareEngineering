// August Moebius (s144461) = AM, Niki Jensen (s144216) = NJ, Martin Meincke (s123883) = MM

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
	static ManagementApp managementApp = new ManagementApp();
	
	public Activity(String name, int projectID){
		this.name = name;
		this.activityID = managementApp.getActivityArray().size();
		this.projectID = projectID;
		this.timeStamp = (int) (System.currentTimeMillis() / 1000L);
		this.assignedUsers = new ArrayList<Integer>();
		this.hoursSpendPerUser = new ArrayList<Integer>();
	}
	
	
	//MM
	// Getters and setters	
	public int getAssignedUserIndex(int target){
			int index = -1;
			for(int i = 0; i < assignedUsers.size();i++){
				if(assignedUsers.get(i)==target){
					index = i;
					break;
				}
				
			}
		
		return index;
	}
	//AM
	public int getTotalHoursSpend(){
		int counter = 0;
		for(int i = 0; i < hoursSpendPerUser.size(); i++){
			counter += hoursSpendPerUser.get(i);
		}
		return counter;
	}
	
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

	public void setAssignedUsers(ArrayList<Integer> assignedUsers) {
		this.assignedUsers = assignedUsers;
	}

	public void setNewAssignedUsers(int userID) {
		assignedUsers.add(userID);
		hoursSpendPerUser.add(0);
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
	//NH
	public void regeisterHours(int hours){
		int index = getAssignedUserIndex(managementApp.getSessionUser());
		
		if(index != -1){
			hoursSpendPerUser.set(index, hoursSpendPerUser.get(index)+hours);
		}else{
			setNewAssignedUsers(managementApp.getSessionUser());
			hoursSpendPerUser.set(getAssignedUserIndex(managementApp.getSessionUser()), hours);
		}
		
		
	}
	
	
	
	
}
