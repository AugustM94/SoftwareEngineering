package soen.management.app;

import org.json.JSONObject;


public class ManagementApp {
	public static User user;
	public static User user2;
	static FileReader fileReader = new FileReader();
	
	public static void main(String[] args) {

		User user = new User("Nicki");
		//System.out.println(user.getUserID());
		
		
		//JSONObject jsonObject = new JSONObject(fileReader.getFileData());
		String jsonString = fileReader.getFileData();
		//System.out.println(jsonString);
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject newJSON = jsonObject.getJSONObject("projects");
        //System.out.println(newJSON.toString());
        jsonObject = new JSONObject(newJSON.toString());
        System.out.println("ProjectID = "+jsonObject.getString("ProjectID"));
        System.out.println("Project name = "+jsonObject.getString("name")); 
        

        //this is it
	}
	
}
