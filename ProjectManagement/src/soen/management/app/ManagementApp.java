// August Moebius (s144461) = AM, Niki Jensen (s144216) = NJ, Martin Meincke (s123883) = MM

package soen.management.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;

//Methods used only in GUI is marked with comment //GUIONLY and is not included in code coverage. 

//MM
public class ManagementApp {
	static ArrayList<Project> projects = new ArrayList<Project>();
	static ArrayList<User> users = new ArrayList<User>();
	static ArrayList<Activity> activities = new ArrayList<Activity>();
	static ArrayList<NonProjectActivity> nonProjectActivities = new ArrayList<NonProjectActivity>();
	
	private static ArrayList<NonProjectActivity> getNonProjectActivities() {
		return nonProjectActivities;
	}
	private static void setNonProjectActivities(ArrayList<NonProjectActivity> nonProjectActivities) {
		ManagementApp.nonProjectActivities = nonProjectActivities;
	}

	static FileReader fileReader = new FileReader();
	private static boolean userLoggedIn = false;
	static int sessionUser = 0;

<<<<<<< HEAD

=======
>>>>>>> origin/master
	public static void main(String[] args) throws userNotLoggedInException {
		loadProjects();
		loadUsers();
		loadActivities();
<<<<<<< HEAD

		
		logInUser(1);
		System.out.println(activities.size());
		System.out.println(activities.get(0).getActivityID());
//		assingUserToActivity(0, 1);
		System.out.println(activities.get(0).getAssignedUsers());
		registerWorkingHours(0, 5);
		System.out.println(activities.get(0).getHoursSpendPerUser());
		System.out.println(printProjectSummary(0));
		
		try {
			System.out.println("loebenummer: " + projectNumberGenerator(10));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
//		System.out.println(getAssignedActivitiesForUser(sessionUser).toString());
//		registerWorkingHours(0, 5);
//		registerWorkingHours(0, 10);
//		System.out.println(activities.get(0).getHoursSpendPerUser().get(1));
	//	System.out.println(activities.get(0).getHoursSpendPerUser().toString());

		// System.out.println(activities.get(0).getName());
		// //User new_user = new User("Berit");
		// //users.add(new_user);
		//
		// //adds a new project
		// //Project new_project = new Project("test",1);
		// //projects.add(new_project);
		// System.out.println("Amount of projects: " + projects.size());
		// System.out.println("Amount of users: " + users.size());
		// System.out.println(printProjectSummary(0));
		// System.out.println("Amount of activities: "+ activities.size());


		new GUI();
		
		/*
		try {
			System.out.println(dateToUnix("January 2, 2010"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		// saveUsers();
		// saveProjects();

=======
		
		NonProjectActivity newNonProjectActivity = new  NonProjectActivity("test npa");
		nonProjectActivities.add(newNonProjectActivity);
		System.out.println(nonProjectActivities.get(0).getName());
		new GUI();
>>>>>>> origin/master
	}
	// AM
	public static void logInUser(int userID) {
		userLoggedIn = true;
		sessionUser = userID;
	}

	// NJ
	public static void logOutUser(){
		userLoggedIn = false;
	}


	public void saveProject(Project project) throws userNotLoggedInException {
		if (userLoggedIn == true) {
			projects.add(project);
			//saveProjects();
		} else {
			throw new userNotLoggedInException(
					"You are not logged in, please select a user.");
		}

	}
	//MM
	public static String unixToDate(int unixTime) {
		Date time=new Date((long)unixTime*1000);
		SimpleDateFormat ft = new SimpleDateFormat("dd. MMMM yyyy 'kl 'HH:mm");
		return ft.format(time);
	}
	//MM
	public static int dateToUnix(String dateTime) throws ParseException{
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date = format.parse(dateTime);
		return (int) (date.getTime()/1000);
	}
	
	public static int projectNumberGenerator(int projectId) throws ParseException{

		Date date = new Date();
		long year = date.getTime();
		SimpleDateFormat ft = new SimpleDateFormat("yy");
		
		return Integer.parseInt( ft.format(year) + ""+projectId);
	}
	
	//AM
	public void addProjectLeader(int userID, int projectID)
			throws userNotLoggedInException {
		if (userLoggedIn == true) {
			projects.get(projectID).setProjectLeaderId(userID);
		} else {
			throw new userNotLoggedInException(
					"You are not logged in, please select a user.");
		}

	}
	//NJ
	public static void registerWorkingHours(int activityID, int hours)
			throws userNotLoggedInException {
		if (userLoggedIn == true) {
			activities.get(activityID).regeisterHours(hours);
		} else {
			throw new userNotLoggedInException(
					"You are not logged in, please select a user.");
		}
	}
	//AM
	public static void assingUserToActivity(int activityID, int userID){
		activities.get(activityID).setNewAssignedUsers(userID);
		
	}
	//MM
	public static ArrayList<Integer> getProjectLeaderProjects(int userID){
		ArrayList<Integer> projectLeaderProjects = new ArrayList<Integer>();
		for (int i = 0; i < projects.size(); i++){
			if(userID == projects.get(i).getProjectLeaderId()){
				projectLeaderProjects.add(projects.get(0).getProjectID());
			}
		}
		
		return projectLeaderProjects;
	}
	//NJ
	public static int getTotalHoursSpentForProject(int projectID){
		int total = 0;
		ArrayList<Integer> a = getActivitiesForProject(projectID);
		for(int i = 0; i < a.size(); i++){
			total+=activities.get(i).getTotalHoursSpend();
		}
		
		return total;
		
	}
	//NJ
	public static int getTotalHoursBudgetForProject(int projectID){
		int total = 0;
		ArrayList<Integer> a = getActivitiesForProject(projectID);
		for(int i = 0; i < a.size(); i++){
			total+=activities.get(i).getHoursBudgeted();
		}
		
		return total;
		
	}
	//MM
	public static ArrayList<Integer> getActivitiesForProject(int projectID){
		ArrayList<Integer> returnArray = new ArrayList<Integer>();
		for (int i = 0; i < activities.size(); i++) {
			if (activities.get(i).getProjectID() == projectID) {
				returnArray.add(i);
			}
		}
		return returnArray;
	}
	//MM
	//Return the IDs of activites which a user is assigned. 
	public static ArrayList<Integer> getAssignedActivitiesForUser(int user)
			throws userNotLoggedInException {
		ArrayList<Integer> returnArray = new ArrayList<Integer>();
		if (userLoggedIn == true) {
			for (int i = 0; i < activities.size(); i++) {
				if (activities.get(i).getAssignedUsers().contains(user)) {
					returnArray.add(i);
				}
			}
		} else {
			throw new userNotLoggedInException(
					"You are not logged in, please select a user.");
		}
		return returnArray;
	}
	//AM
	public static void loadActivities() throws NumberFormatException {
		String jsonString = fileReader.getFileData("activities");
		JSONArray jsonArray = new JSONArray(jsonString);

		for (int i = 0; i < jsonArray.length(); i++) {
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

			try {
				activityID = activity.getInt("activityID");
				projectID = activity.getInt("projectID");
				startDate = activity.getInt("projectID");
				endDate = activity.getInt("endDate");
				timeStamp = activity.getInt("timeStamp");
				hoursBudgeted = activity.getInt("hoursBudgeted");
			} catch (NumberFormatException e) {
				System.out.println("not a number");
			}

			try {
				name = activity.getString("name");
			} catch (NumberFormatException e) {
				System.out.println("not a valid string");
			}

			try {
				JSONAssignedUsers = activity.getJSONArray("assignedUsers");
				JSONHoursSpendPerUser = activity
						.getJSONArray("hoursSpendPerUser");
			} catch (NumberFormatException e) {
				System.out.println("not a valid array");
			}

			try {
				active = activity.getBoolean("active");
			} catch (NumberFormatException e) {
				System.out.println("not a valid boolean");
			}

			for (int j = 0; j < JSONHoursSpendPerUser.length(); j++) {
				int hoursSpend = 0;
				try {
					hoursSpend = JSONHoursSpendPerUser.getInt(j);
				} catch (NumberFormatException e) {
					System.out.println("not a number");
				}
				hoursSpendPerUser.add(hoursSpend);
			}

			for (int j = 0; j < JSONAssignedUsers.length(); j++) {
				int assignedUser = 0;
				try {
					assignedUser = JSONAssignedUsers.getInt(j);
				} catch (NumberFormatException e) {
					System.out.println("not a number");
				}
				assignedUsers.add(assignedUser);
			}

		//	System.out.println(hoursSpendPerUser.get(0));

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
	
	// MM
	public static void loadNonProjectActivities() throws NumberFormatException {
		String jsonString = fileReader.getFileData("nonProjectActivities");
		JSONArray jsonArray = new JSONArray(jsonString);
		
		for (int i = 0; i < jsonArray.length(); i++) {
			int nonProjectActivityID = 0;
			String name = "";
			int startDate = 0;
			int endDate = 0;
			ArrayList<Integer> assignedUsers = new ArrayList<Integer>();
			ArrayList<Integer> hoursSpendPerUser = new ArrayList<Integer>();
			int timeStamp = 0;
			boolean active = false;

			JSONArray JSONAssignedUsers = new JSONArray();
			JSONArray JSONHoursSpendPerUser = new JSONArray();

			JSONObject activity = jsonArray.getJSONObject(i);

			try {
				nonProjectActivityID = activity.getInt("activityID");
				startDate = activity.getInt("projectID");
				endDate = activity.getInt("endDate");
				timeStamp = activity.getInt("timeStamp");
			} catch (NumberFormatException e) {
				System.out.println("not a number");
			}

			try {
				name = activity.getString("name");
			} catch (NumberFormatException e) {
				System.out.println("not a valid string");
			}

			try {
				JSONAssignedUsers = activity.getJSONArray("assignedUsers");
			} catch (NumberFormatException e) {
				System.out.println("not a valid array");
			}

			try {
				active = activity.getBoolean("active");
			} catch (NumberFormatException e) {
				System.out.println("not a valid boolean");
			}


			for (int j = 0; j < JSONAssignedUsers.length(); j++) {
				int assignedUser = 0;
				try {
					assignedUser = JSONAssignedUsers.getInt(j);
				} catch (NumberFormatException e) {
					System.out.println("not a number");
				}
				assignedUsers.add(assignedUser);
			}

			NonProjectActivity activityElement = new NonProjectActivity(name);
			activityElement.setName(name);
			activityElement.setEndDate(endDate);
			activityElement.setStartDate(startDate);
			activityElement.setNonProjectActivityID(nonProjectActivityID);
			activityElement.setTimeStamp(timeStamp);
			activityElement.setAssignedUsers(assignedUsers);
			activityElement.setActive(active);

			nonProjectActivities.add(activityElement);
		}
	}
	//MM
	public static void loadUsers() throws NumberFormatException {
		String jsonString = fileReader.getFileData("users");
		JSONArray jsonArray = new JSONArray(jsonString);

		for (int i = 0; i < jsonArray.length(); i++) {
			int userID = 0;
			String name = "";
			ArrayList<Integer> projectIDs = new ArrayList<Integer>();
			JSONArray JSONProjectIDs = new JSONArray();

			JSONObject user = jsonArray.getJSONObject(i);

			try {
				userID = user.getInt("userID");
			} catch (NumberFormatException e) {
				System.out.println("not a number");
			}

			try {
				name = user.getString("name");
			} catch (NumberFormatException e) {
				System.out.println("not a valid string");
			}

			try {
				JSONProjectIDs = user.getJSONArray("projectIDs");
			} catch (NumberFormatException e) {
				System.out.println("not a valid array");
			}

			for (int j = 0; j < JSONProjectIDs.length(); j++) {
				int projectIDNumber = 0;
				try {
					projectIDNumber = JSONProjectIDs.getInt(j);
				} catch (NumberFormatException e) {
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
	//NJ
	public static void loadProjects() throws NumberFormatException {
		String jsonString = fileReader.getFileData("projects");
		JSONArray jsonArray = new JSONArray(jsonString);

		for (int i = 0; i < jsonArray.length(); i++) {
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
			} catch (NumberFormatException e) {
				System.out.println("not a number");
			}

			try {
				name = project.getString("name");
			} catch (NumberFormatException e) {
				System.out.println("not a valid string");
			}

			try {
				active = project.getBoolean("active");
			} catch (NumberFormatException e) {
				System.out.println("not a valid boolean value");
			}

			Project projectElement = new Project(name, projectID);
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
	//NJ
	public static void saveActivities() {
		JSONArray jsArray = new JSONArray(activities.toArray());

		fileReader.saveFileData(jsArray.toString(), "activities");
	}
	//NJ
	public static void saveProjects() {
		JSONArray jsArray = new JSONArray(projects.toArray());

		fileReader.saveFileData(jsArray.toString(), "projects");
	}
	//NJ
	public static void saveUsers() {
		JSONArray jsArray = new JSONArray(users.toArray());

		fileReader.saveFileData(jsArray.toString(), "users");
	}
	
	public static void saveNonProjectActivities() {
		JSONArray jsArray = new JSONArray(nonProjectActivities.toArray());

		fileReader.saveFileData(jsArray.toString(), "nonProjectActivities");
	}
	
	

//	public String printProjectSummary(int ID) {
//		System.out.println(projects.size());
	//AM



	public static String printProjectSummary(int ID) {

		Project p = projects.get(ID);
		String type;


		if (p.getProjectType() == 0) {
			type = "In house";
		} else {
			type = "Out of house";
		}

		String s = "Project summary:" + "\n" + "Name: " + p.getName() + "\n"
				+ "ProjectLeader: " + getProjectLeaderName(ID) + "\n"
				+ "Project type: " + type + "\n" + "Start date: "
				+ p.getStartDate() + "\n" + "End date: " + p.getEndDate()
				+ "\n" + "Spent/budgeted hours: " + getTotalHoursSpentForProject(ID) + "/"+ getTotalHoursBudgetForProject(ID) ;

		return s;
	}

	//MM	
	public static String printActivitySummary(int ID){
		Activity a = activities.get(ID);
		
		String s = "Activity summary:" + "\n" + "Name: " + a.getName() + "\n"
				+ "Assigned users: " + a.getAssignedUsers() + "\n";

		return s;
	}

	public static String getProjectLeaderName(int projectID){
		String s = "No project leader assigned";
		int projectLeader = projects.get(projectID).getProjectLeaderId();
		if(projectLeader != -1){
			s = users.get(projectLeader).getName();
		}
		
		return s;
	}
	//AM
	public int nextUserID() {
		return users.size();
	}
	//MM
	public ArrayList<User> getUserArray() {
		return users;
	}
	//AM
	public int getSessionUser() {
		return sessionUser;
	}


	//NH
	public ArrayList<Project> getProjectArray() {
		return projects;
	}
	//NH
	public ArrayList<Activity> getActivityArray() {
		return activities;
	}
	
	public boolean getUserStatus(){
		return userLoggedIn;
		
	}

}
