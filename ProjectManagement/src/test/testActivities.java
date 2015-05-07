package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import soen.management.app.Activity;
import soen.management.app.ManagementApp;
import soen.management.app.Project;
import soen.management.app.User;
import soen.management.app.userNotLoggedInException;

public class testActivities {
	private static ManagementApp managementApp = new ManagementApp();
	private String name = "New project";
	
	//Tests if the exception is thrown if no user is logged in while attempting to save project.
	@Test(expected = userNotLoggedInException.class)
	public void testUserNotLoggedInExceptionAddProject() throws userNotLoggedInException{
		Project project = new Project(name,0);
		managementApp.saveProject(project);
	}
		
	@Test
	public void testAddActivity() throws userNotLoggedInException{
		ArrayList<Project> projects = managementApp.getProjectArray();
		ArrayList<Activity> activities = managementApp.getActivityArray();
		ArrayList<Project> projectsLeader = new ArrayList<Project>(); 
		int projectSize = projects.size();
		int activitiesSize = activities.size();
		
		// log in user
		User user = new User("test user");
		managementApp.logInUser(user.getUserID());
		assertEquals(user.getUserID(), managementApp.getSessionUser());
		
		// add project
		Project project = new Project(name,0);
		managementApp.saveProject(project);
		
		
		//test if project was added
		assertTrue(projects.size() == projectSize+1);
		assertTrue(project.getName() != null);
		
		// add a project leader
		projects.get(0).setProjectLeaderId(user.getUserID());
		assertEquals(user.getUserID(),projects.get(0).getProjectLeaderId());
		
		// get all projects with user as project leader
		for (int i = 0; i < projects.size(); i++){
			if (projects.get(i).getProjectLeaderId() == user.getUserID()){
				projectsLeader.add(projects.get(i));
			}
		}
		
		// check if only the expected project leader is loaded
		assertEquals(1, projectsLeader.size());
		
		// check if there are currently no activities 
		assertEquals(0, activities.size());
		
		// add new activity
		Activity new_activity = new Activity("test activity",projectsLeader.get(0).getProjectID());
		new_activity.setActive(true);
		new_activity.setHoursBudgeted(300);
		new_activity.setStartDate(1425168000);
		new_activity.setEndDate(1443657600);
		
		ArrayList<Integer> assignedUsers = new ArrayList<Integer>();
		assignedUsers.add(user.getUserID());
		new_activity.setAssignedUsers(assignedUsers);
		
		ArrayList<Integer> hoursSpendPerUser = new ArrayList<Integer>();
		hoursSpendPerUser.add(130);
		new_activity.setHoursSpendPerUser(hoursSpendPerUser);
		
		activities.add(new_activity);
		
		// check if the activity have been added
		assertEquals(1, activities.size());
		
		// check if assigned values match expected
		assertEquals("test activity",activities.get(0).getName());
		assertEquals(true, activities.get(0).isActive());
		assertEquals(300, activities.get(0).getHoursBudgeted());
		assertEquals(1425168000, activities.get(0).getStartDate());
		assertEquals(1443657600, activities.get(0).getEndDate());
		assertEquals(user.getUserID(),(int) activities.get(0).getAssignedUsers().get(0));
		assertEquals(130, (int) activities.get(0).getHoursSpendPerUser().get(0));	
	}
}
