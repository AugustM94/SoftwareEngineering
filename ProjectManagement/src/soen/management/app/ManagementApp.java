package soen.management.app;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


public class ManagementApp {
	static ArrayList<Project> projects = new ArrayList<Project>();
	static ArrayList<User> users = new ArrayList<User>();
	static ArrayList<Activity> activities = new ArrayList<Activity>();
	static FileReader fileReader = new FileReader();
	private boolean userLoggedIn = false;
	static int sessionUser = 0;
	
	public static void main(String[] args) {
		loadProjects();
		loadUsers();
		loadActivities();
		
		
		System.out.println(activities.get(0).getName());
		//User new_user = new User("Berit");
		//users.add(new_user);
	
		//adds a new project
		//Project new_project = new Project("test",1);
		//projects.add(new_project);
		System.out.println("Amount of projects: " + projects.size());
		System.out.println("Amount of users: " + users.size());
		System.out.println(printProjectSummary(0));
		System.out.println("Amount of activities: "+ activities.size());
		new GUI();
		
		//saveUsers();
	    //saveProjects();
		
	}
	
	public void logInUser(int userID){
		userLoggedIn = true;
		this.sessionUser = userID;
	}
	
	public void saveProject(Project project)throws userNotLoggedInException{
		if(userLoggedIn==true){
			projects.add(project);
		}else{
			throw new userNotLoggedInException("You are not logged in, please select a user.");
		}
			
	}
	
	public void addProjectLeader(int userID, int projectID)throws userNotLoggedInException{
		if(userLoggedIn == true){
			projects.get(projectID).setProjectLeaderId(userID);
		}else{
			throw new userNotLoggedInException("You are not logged in, please select a user.");
		}
		
	}
	
	public static void loadActivities() throws NumberFormatException{
		String jsonString = fileReader.getFileData("activities");
		JSONArray jsonArray = new JSONArray(jsonString);
		
		for (int i=0; i < jsonArray.length(); i++){
			int activityID = 0;
			int projectID = 0;
			String name = "";
			int startDate = 0;
			int endDate = 0;
			int hoursBudgeted = 0;
			ArrayList<Integer> assignedUsers = new ArrayList<Integer>();
			ArrayList<Integer> hoursSpendPerUser = new ArrayList<Integer>();
			int timeStamp = 0;
			boolean active = false;
			
			
			JSONArray JSONAssignedUsers = new JSONArray();
			JSONArray JSONHoursSpendPerUser = new JSONArray();
			
			JSONObject activity = jsonArray.getJSONObject(i);
		
			try{
				activityID = activity.getInt("activityID");
				projectID = activity.getInt("projectID");
				startDate = activity.getInt("projectID");
				endDate = activity.getInt("endDate");
				timeStamp = activity.getInt("timeStamp");
				hoursBudgeted = activity.getInt("hoursBudgeted");
        	}catch (NumberFormatException e){
     	       System.out.println("not a number"); 
     	   	}
			
			try {
        		name = activity.getString("name");
        	}catch(NumberFormatException e){
       	       System.out.println("not a valid string"); 
       	    }
			
			try{
        		JSONAssignedUsers = activity.getJSONArray("assignedUsers");
        		JSONHoursSpendPerUser = activity.getJSONArray("hoursSpendPerUser");
        	}catch(NumberFormatException e){
        		System.out.println("not a valid array"); 
        	}
			
			try{
				active = activity.getBoolean("active");
        	}catch(NumberFormatException e){
       	       System.out.println("not a valid boolean"); 
       	    }
			
			for (int j = 0; j < JSONHoursSpendPerUser.length(); j++){
        		int hoursSpend = 0;
        		try{
        			hoursSpend = JSONHoursSpendPerUser.getInt(j);
            	}catch (NumberFormatException e){
         	       System.out.println("not a number"); 
         	   	}
        		hoursSpendPerUser.add(hoursSpend);
        	}
			
			for (int j = 0; j < JSONAssignedUsers.length(); j++){
        		int assignedUser = 0;
        		try{
        			assignedUser =  JSONAssignedUsers.getInt(j);
            	}catch (NumberFormatException e){
         	       System.out.println("not a number"); 
         	   	}
        		assignedUsers.add(assignedUser);
        	}
			
			System.out.println(hoursSpendPerUser.get(0));
			
			Activity activityElement = new Activity(name, projectID);
			activityElement.setName(name);
			activityElement.setEndDate(endDate);
			activityElement.setStartDate(startDate);
			activityElement.setProjectID(projectID);
			activityElement.setTimeStamp(timeStamp);
			activityElement.setHoursSpendPerUser(hoursSpendPerUser);	
			activityElement.setAssignedUsers(assignedUsers);
			activityElement.setActive(active);
			activityElement.setHoursBudgeted(hoursBudgeted);
			
        	activities.add(activityElement);
		}
	}
	public static void loadUsers() throws NumberFormatException{
		String jsonString = fileReader.getFileData("users");
        JSONArray jsonArray = new JSONArray(jsonString);
        
        for (int i=0; i<jsonArray.length(); i++){
        	int userID = 0;
        	String name = "";
        	ArrayList<Integer> projectIDs = new ArrayList<Integer>();
        	JSONArray JSONProjectIDs = new JSONArray();
        	
        	JSONObject user = jsonArray.getJSONObject(i);
        	
        	try{
        		userID = user.getInt("userID");
        	}catch (NumberFormatException e){
     	       System.out.println("not a number"); 
     	   	}
        	
        	try {
        		name = user.getString("name");
        	}catch(NumberFormatException e){
       	       System.out.println("not a valid string"); 
       	     }
        	
        	try{
        		JSONProjectIDs = user.getJSONArray("projectIDs");
        	}catch(NumberFormatException e){
        		System.out.println("not a valid array"); 
        	}

        	for (int j = 0; j < JSONProjectIDs.length(); j++){
        		int projectIDNumber = 0;
        		try{
        			projectIDNumber = JSONProjectIDs.getInt(j);
            	}catch (NumberFormatException e){
         	       System.out.println("not a number"); 
         	   	}
        		projectIDs.add(projectIDNumber);
        	}
        	User userElement = new User(name);
        	userElement.setName(name);
        	userElement.setUserID(userID);
        	userElement.setProjectID(projectIDs);
        	
        	users.add(userElement);
        }
	}
	public static void loadProjects() throws NumberFormatException{
		String jsonString = fileReader.getFileData("projects");
        JSONArray jsonArray = new JSONArray(jsonString);
        
        for (int i=0; i<jsonArray.length(); i++) {
        	int projectID = 0;
        	String name = "";
        	int startDate = 0;
        	int endDate = 0;
        	int projectLeaderId = 0;
        	int projectType = 0;
        	int timeStamp = 0;
        	boolean active = false;
        	
        	 JSONObject project = jsonArray.getJSONObject(i);
        	 try {
        		 projectID = project.getInt("projectID");
                 startDate = project.getInt("startDate");
                 endDate = project.getInt("endDate");
                 projectLeaderId = project.getInt("projectLeaderId");
                 projectType = project.getInt("projectType");
                 timeStamp = project.getInt("timeStamp");
        	   }catch (NumberFormatException e){
        	       System.out.println("not a number"); 
        	   }
        	 
        	 try{
        		 name = project.getString("name");
        	 }catch   (NumberFormatException e){
      	       System.out.println("not a valid string"); 
      	     }
        
        	 try{
                 active = project.getBoolean("active");
        	 }catch   (NumberFormatException e){
      	       System.out.println("not a valid boolean value"); 
      	     }
        	 
             Project projectElement = new Project(name,projectID);
             projectElement.setStartDate(startDate);
             projectElement.setEndDate(endDate);
             projectElement.setProjectLeaderId(projectLeaderId);
             projectElement.setProjectType(projectType);
             projectElement.setTimeStamp(timeStamp);
             projectElement.setActive(active);
             
     		 projects.add(projectElement);      
        }
        System.out.println("finished loading projects");
	}
	
	public static void saveActivities() {
		JSONArray jsArray = new JSONArray(activities.toArray());
		
		fileReader.saveFileData(jsArray.toString(), "activities");
	}
	
	public static void saveProjects() {
		JSONArray jsArray = new JSONArray(projects.toArray());
		
		fileReader.saveFileData(jsArray.toString(), "projects");
	}
	
	public static void saveUsers() {
		JSONArray jsArray = new JSONArray(users.toArray());
		
		fileReader.saveFileData(jsArray.toString(), "users");
	}
	
	public static String printProjectSummary(int ID){
		Project p = projects.get(ID);
		String type;
		
		if(p.getProjectType() == 0){
			type = "In house";
		}else{
			type = "Out of house";
		}
		
		String s = "Project summary:"+"\n"+
		"Name: "+p.getName()+"\n"+
		"Project leader: " + users.get(p.getProjectLeaderId()).getName() + "\n" +
		"Project type: "+type+"\n"+
		"Start date: " + p.getStartDate()+"\n"+
		"End date: " + p.getEndDate() + "\n"+
		"Spent/budgeted hours: " +"Noget her!!"+"\n"+
		""
		;
					
		
		
		return s;
	}
	

	
	public int nextUserID(){
		return users.size();
	}

	public ArrayList<User> getUserArray() {
		// TODO Auto-generated method stub
		return users;
	}

	public int getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(int sessionUser) {
		this.sessionUser = sessionUser;
	}
	
	public ArrayList<Project> getProjectArray() {
		// TODO Auto-generated method stub
		return projects;
	}
	
	
}
