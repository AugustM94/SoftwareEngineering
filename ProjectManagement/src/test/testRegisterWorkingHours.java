package test;

import java.util.ArrayList;

import javax.security.auth.login.LoginContext;

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

	// Use case 4 test: Registering hours.

	// Tests if the correct exception is thrown if no user is logged in while
	// attempting to get assigned activities.
	@Test(expected = userNotLoggedInException.class)
	public void testUserNotLoggedInGetAssignedActivties()
			throws userNotLoggedInException {
		managementApp.getAssignedActivitiesForUser(0); // Attempts to get a list
														// of activities for
														// user
														// with ID 0 even though
														// user is not logged
														// in.
	}

	@Test(expected = userNotLoggedInException.class)
	public void testUserNotLoggedInExceptionRegisterHours()
			throws userNotLoggedInException {
		managementApp.registerWorkingHours(0, 1); // Attempts to register 1 hour
													// to activity with ID no.
													// 0. s
	}

	// a) Login user with ID 0.
	// b) Assign the user to some activities.
	// c) Test if user can get a list of activities which the user is assigned.

	@Test
	public void testGetAssignedActivitiesForUser()
			throws userNotLoggedInException {
		// Logins user
		managementApp.logInUser(0);
		// Creates some activities for user to be assigned to.
		Activity activity1 = new Activity("Activity 1", 0);
		activities.add(activity1);
		Activity activity2 = new Activity("Activity 2", 0);
		activities.add(activity2);
		Activity activity3 = new Activity("Activity 3", 0);
		activities.add(activity3);

		// Assigns the session user to activity 1 and activity 3.
		managementApp.assingUserToActivity(0, 0);
		managementApp.assingUserToActivity(2, 0);
		// Test if the user receives the correct activities. User should only
		// receive
		assertEquals("[0, 2]", ManagementApp.getAssignedActivitiesForUser(0)
				.toString());
	}

	// Test registering hours with user logged in. 
	@Test
	public void testRegisterHours() throws userNotLoggedInException {
		// a) Login user with ID no. 0.
		// b) Initializes Activity 1
		// c) Adds new activity to list of activities.
		// d) Register 5 hours for session user. In this case user with ID no.
		// 0.

		managementApp.logInUser(0);	
		Activity activity1 = new Activity("Activity 1", 0);
		activities.add(activity1);
		managementApp.registerWorkingHours(0, 5);
		assertTrue(activity1.getHoursSpendPerUser().get(0)==5);
	}

}
