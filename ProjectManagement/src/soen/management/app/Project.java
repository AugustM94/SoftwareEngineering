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
	
	public Project(String name){
		this.name = name;
		this.projectID = 1; //

	}
}
