package soen.management.app;

public class Activity {

	private int activityID; 
	private int projectID;
	private String name;
	private int startDate;
	private int endDate;
	private int assignedUsers[];
	private int hoursSpendPerUser[][];
	private int hoursBudgeted;
	private int timeStamp;
	private boolean active;
	
	public Activity(String name, int projectID){
		this.name = name;
		this.activityID = 1;
		this.projectID = 1;
		this.timeStamp = (int) (System.currentTimeMillis() / 1000L);
	}
	
	
}
