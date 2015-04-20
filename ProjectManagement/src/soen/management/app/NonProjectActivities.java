package soen.management.app;

public class NonProjectActivities {
	private int NonProjectActivitiesID;
	private String name;
	private int startDate;
	private int endDate;
	private int timeStamp;
	private boolean active;
	
	
	public NonProjectActivities(String name){
		this.name = name;
		this.NonProjectActivitiesID = 1;
		this.timeStamp = (int) (System.currentTimeMillis() / 1000L);
	}
}
