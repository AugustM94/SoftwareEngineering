package test;

import java.lang.management.ManagementPermission;
import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;
import soen.management.app.Activity;
import soen.management.app.ManagementApp;
import soen.management.app.Project;
import soen.management.app.User;
import soen.management.app.userNotLoggedInException;

public class TestProjectSummaryPrint {
	private ManagementApp managementApp = new ManagementApp();
	private ArrayList<Project> projects = managementApp.getProjectArray();
	private ArrayList<User> users = managementApp.getUserArray();
	private ArrayList<Activity> actvities = managementApp.getActivityArray();
	private User user1;
	private User user2;
	private User user3;
	private Activity activity1;
	private Activity activity2;

	private Project project;

	@Test
	public void testPrintProjectSummart() throws userNotLoggedInException {
		// a) Initializes data.
		// b) Adds data to the project and activities.
		// c) Tests if the print statement contains the data.

		// Initializes 3 new users
		user1 = new User("User 1");
		users.add(user1);
		user2 = new User("User 2");
		users.add(user2);
		user3 = new User("User 3");
		users.add(user3);

		// Login user
		managementApp.logInUser(0);

		// Initializes a new project.
		project = new Project("Project 1", 0);
		managementApp.saveProject(project);

		// Initializes two new activities and add them to the project.
		activity1 = new Activity("Activity 1", 0);
		actvities.add(activity1);
		activity2 = new Activity("Acticity 2", 0);
		actvities.add(activity2);

		// Set budget for activity.
		activity1.setHoursBudgeted(25);
		activity2.setHoursBudgeted(30);

		// Assign users to different activities.
		managementApp.assingUserToActivity(0, 0);
		managementApp.assingUserToActivity(1, 0);
		managementApp.assingUserToActivity(0, 1);
		managementApp.assingUserToActivity(1, 2);

		// Register some hours for the users. This is done for the session user.
		// Session user is currently user 1 with ID 0.
		managementApp.registerWorkingHours(0, 5); // Adds 5 hours to activity
													// 1(ID = 0).
		managementApp.registerWorkingHours(1, 5); // Adds 6 hours to activity
													// 2(ID = 1).
		managementApp.logInUser(1); // Logs in user 2.
		managementApp.registerWorkingHours(0, 8); // Adds 8 hours
		managementApp.logInUser(2); // Logs in user 3.
		managementApp.registerWorkingHours(1, 9);// Adds 9 hours.

		// Set some info for the project.
		project.setProjectLeaderId(0);
		int start = 1000000;
		int end = 2000000;
		project.setStartDate(start);
		project.setEndDate(end);

		// Creates the summary string
		String s = managementApp.printProjectSummary(0);
		System.out.println(s);

		// Test
		// a) Tests if projectleader is listed in the string.
		// b) Tests if the project type is listed in the string.
		// c) Tests if start and end date is listed in the string.
		// e) Tests if name is listed in the string is listed in string.
		// d) Tests if spent hours and budget gours is listed in string.

		assertTrue(s.contains("User 1"));
		assertTrue(s.contains("In house"));
		assertTrue(s.contains(Integer.toString(start))
				&& s.contains(Integer.toString(end)));
		assertTrue(s.contains("Project 1"));
		assertTrue(s.contains(Integer.toString(managementApp
				.getTotalHoursBudgetForProject(0)))
				&& s.contains(Integer.toString(managementApp
						.getTotalHoursSpentForProject(0))));

	}

}
