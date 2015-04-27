package soen.management.app;

import java.util.ArrayList;

public class Project {
	private int projectID;
	private String name;
	private int startDate;
	private int endDate;
	private int projectLeaderId;
	private int projectType;
	private int timeStamp;
	private boolean active;
	
	public Project(String name, int projectType){
		this.name = name;
		this.projectID = 1; //change to length of project list
		this.projectType = projectType;
		this.timeStamp = (int) (System.currentTimeMillis() / 1000L);
	}
	
	public void activateProject(int projectID){
		
	}
	
	public String printProjectSummary(int projectID){

		
		return "hej";
	}

	
	
	
//Get setters
	public int getProjectID() {
		return projectID; 
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

	public int getProjectLeaderId() {
		return projectLeaderId;
	}

	public void setProjectLeaderId(int projectLeaderId) {
		this.projectLeaderId = projectLeaderId;
	}

	public int getProjectType() {
		return projectType;
	}

	public void setProjectType(int projectType) {
		this.projectType = projectType;
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
