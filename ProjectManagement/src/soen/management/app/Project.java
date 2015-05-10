package soen.management.app;


public class Project {
	private int projectID;
	private String name;
	private int startDate;
	private int endDate;
	private int projectLeaderId;
	private int projectType;
	private int timeStamp;
	private boolean active;
	static ManagementApp managementApp = new ManagementApp();
	
	public Project(String name, int projectType){
		this.name = name;
		this.projectID = managementApp.getProjectArray().size();
		this.projectType = projectType;
		this.timeStamp = (int) (System.currentTimeMillis() / 1000L);
		this.projectLeaderId = -1;
	}
	
	public void activateProject(int projectID){
		
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
