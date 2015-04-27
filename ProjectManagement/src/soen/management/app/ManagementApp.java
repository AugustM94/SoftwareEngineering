package soen.management.app;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


public class ManagementApp {
	static ArrayList<Project> projects = new ArrayList<Project>();
	static ArrayList<User> users = new ArrayList<User>();
	public static User user;
	public static User user2;
	static FileReader fileReader = new FileReader();
	
	public static void main(String[] args) {
		loadProjects();
		loadUsers();
	
		//adds a new project
		//Project new_project = new Project("test",1);
		//projects.add(new_project);
		System.out.println("Amount of projects: " + projects.size());
		System.out.println("Amount of users: " + users.size());
		
	    //saveProjects();
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

        	for (int j = 0; j < JSONProjectIDs.getJSONObject(0).length(); j++){
        		
        		int projectIDNumber = 0;
        		try{
        			projectIDNumber = JSONProjectIDs.getJSONObject(0).getInt(""+j);
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
	
	public static void saveProjects() {
		JSONArray jsArray = new JSONArray(projects.toArray());
		
		fileReader.saveFileData(jsArray.toString(), "projects");
	}
	
	public int nextUserID(){
		return users.size();
	}
	
}
