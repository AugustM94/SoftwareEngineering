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
}
