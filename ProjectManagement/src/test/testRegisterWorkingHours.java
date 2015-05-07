package test;

import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Test;

import soen.management.app.Activity;
import soen.management.app.ManagementApp;
import soen.management.app.Project;
import soen.management.app.userNotLoggedInException;

public class testRegisterWorkingHours {
	private static ManagementApp managementApp = new ManagementApp();
	private static ArrayList<Activity> activities = managementApp
			.getActivityArray();
	private Activity activity1;
	private Activity activity2;
	private Activity activity3;

	// Use case 4 test: Registering hours.

	// Tests if the correct exception is thrown if no user is logged in while
	// attempting to register hours.
	@Test(expected = userNotLoggedInException.class)
	public void testUserNotLoggedInExceptionRegisterHours()
			throws userNotLoggedInException {
		ManagementApp.getAssignedActivitiesForUser(0); // Attempts to get a list
														// of activities for user
														// with ID 0 even though
														// user is not logged
														// in.
	}
	
	//a) Login user with ID 0.
	//b) Assign the user to some activities. 
	//c) Test if user can get a list of activities which the user is assigned. 
	
	@Test
	public void testGetAssignedActivitiesForUser() throws userNotLoggedInException{
		//Logins user
		ManagementApp.logInUser(0);
		//Creates some activities for user to be assigned to. 
		this.activity1 = new Activity("Activity 1", 0);
		this.activity2 = new Activity("Activity 2", 0);
		this.activity3 = new Activity("Activity 3", 0);
		activities.add(activity1);
		activities.add(activity2);
		activities.add(activity3);

		
		
		//Assigns the session user to activity 1 and activity 3.
		ManagementApp.assingUserToActivity(0, 1);
		ManagementApp.assingUserToActivity(2, 1);
		System.out.println(activities.get(0).getAssignedUsers().toString());
		System.out.println(activities.get(1).getAssignedUsers().toString());
		System.out.println(activities.get(2).getAssignedUsers().toString());
		//Test if the user receives the correct activities.
		assertEquals("[0,2]", ManagementApp.getAssignedActivitiesForUser(0).toString());
	}
	

}
