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
	
	public Project(String name, int startDate, int endDate, int projectLeaderId, int projectType){
		this.name = name;
		this.projectID = 1; //change to length of project list
		this.startDate = startDate; //unix time of start date
		this.endDate = endDate; // unix time of end date
		this.projectLeaderId = projectLeaderId;
		this.projectType = projectType;
		this.timeStamp = (int) (System.currentTimeMillis() / 1000L);
		this.active = true;
	}
}
