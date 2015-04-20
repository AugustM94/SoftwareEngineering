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
}
