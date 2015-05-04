package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import soen.management.app.Activity;
import soen.management.app.ManagementApp;
import soen.management.app.Project;
import soen.management.app.User;

public class testActivities {

	@Test
	public void testAddActivity(){
		ManagementApp managementApp = new ManagementApp();
		
		ArrayList<Project> projects = managementApp.getProjectArray();
		ArrayList<Project> projectsLeader = new ArrayList<Project>(); 
		ArrayList<Activity> activities = new ArrayList<Activity>();
		User user = new User("test user");
		
		// log in user
		managementApp.logInUser(user.getUserID());
		assertEquals(user.getUserID(), managementApp.getSessionUser());

		// add a new project 
		assertEquals(0, projects.size());
		Project new_project = new Project("test",1);
		projects.add(new_project);
		assertEquals(1, projects.size());
		
		// add a project leader
		projects.get(0).setProjectLeaderId(user.getUserID());
		assertEquals(user.getUserID(),projects.get(0).getProjectLeaderId());
		
		// get all projects with user as project leader
		for (int i = 0; i < projects.size(); i++){
			if (projects.get(i).getProjectLeaderId() == user.getUserID()){
				projectsLeader.add(projects.get(i));
			}
		}
		assertEquals(1, projectsLeader.size());
		
		// add an activity
		assertEquals(0, activities.size());
		Activity new_activity = new Activity("test activity",projectsLeader.get(0).getProjectID());
		new_activity.setActive(true);
		new_activity.setHoursBudgeted(30);
		ArrayList<Integer> assignedUsers = new ArrayList<Integer>();
		assignedUsers.add(user.getUserID());
		
		System.out.println(assignedUsers.get(0));
		new_activity.setAssignedUsers(new_activity.getAssignedUsers());
		
		activities.add(new_activity);
		assertEquals(1, activities.size());
		
	}
}
