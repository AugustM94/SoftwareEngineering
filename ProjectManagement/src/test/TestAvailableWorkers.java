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

public class TestAvailableWorkers {
	private String name = "Test Project";
	
	@Test(expected = userNotLoggedInException.class)
	public void testUserNotLoggedInExceptionAddProject() throws userNotLoggedInException{
		Project project = new Project(name,0);
		managementApp.saveProject(project);
	}
	
	private static ManagementApp managementApp = new ManagementApp();
	
	@Test
	public void testAddActivity() throws userNotLoggedInException{
		ArrayList<Project> projects = managementApp.getProjectArray();
		ArrayList<Activity> activities = managementApp.getActivityArray();
		ArrayList<User> users = managementApp.getUserArray();
		int projectSize = projects.size();
		
		// log in user
		User user = new User("test project leader");
		user.setUserID(1);
		users.add(user);
		User user2 = new User("test worker 1");
		user2.setUserID(2);
		users.add(user2);
		User user3 = new User("test worker 1");
		user3.setUserID(3);
		users.add(user3);
		
		
		managementApp.logInUser(user.getUserID());
		assertEquals(user.getUserID(), managementApp.getSessionUser());
		
		// add a project
		Project project = new Project(name,0);
		managementApp.saveProject(project);
		
		//test if project was added
		assertTrue(projects.size() == projectSize+1);
		assertTrue(project.getName() != null);
		
		// add a project leader
		projects.get(0).setProjectLeaderId(user.getUserID());
		assertEquals(user.getUserID(),projects.get(0).getProjectLeaderId());
		
		// get projects with user as project leader
		ArrayList<Integer> projectLeaderProjects = new ArrayList<Integer>();
		for (int i = 0; i < projects.size(); i++){
			if(user.getUserID() == projects.get(i).getProjectLeaderId()){
				projectLeaderProjects.add(projects.get(0).getProjectID());
			}
		}
		
		Project selectedProject;
		// if user is project leader of at least 1 project
		if (projectLeaderProjects.size() > 0){
			selectedProject = projects.get(0);
			
		
			// check if there are currently no activities 
			assertEquals(0, activities.size());
			
			Activity mainActivity = new Activity("Main activity",selectedProject.getProjectID());
			activities.add(mainActivity);
			
			// user 2's activity from February to April
			Activity workingActivity1 = new Activity("worker activity 01.feb-15.apr",selectedProject.getProjectID());
			workingActivity1.setStartDate(1422778500);
			workingActivity1.setEndDate(1429113600);
			ArrayList<Integer> assignedUsers1 = new ArrayList<Integer>();
			assignedUsers1.add(user2.getUserID());
			workingActivity1.setAssignedUsers(assignedUsers1);
			activities.add(workingActivity1);
			
			// user 2's activity from October to December
			Activity workingActivity2 = new Activity("worker activity 01.oct-01.dec",selectedProject.getProjectID());
			workingActivity2.setStartDate(1443687300);
			workingActivity2.setEndDate(1448985600);
			ArrayList<Integer> assignedUsers2 = new ArrayList<Integer>();
			assignedUsers2.add(user2.getUserID());
			workingActivity2.setAssignedUsers(assignedUsers2);
			activities.add(workingActivity2);
			
			// user 3's activity from May to June
			Activity workingActivity3 = new Activity("worker activity 01.may-01.jun",selectedProject.getProjectID());
			workingActivity3.setStartDate(1430468100);
			workingActivity3.setEndDate(1433146500);
			ArrayList<Integer> assignedUsers3 = new ArrayList<Integer>();
			assignedUsers3.add(user3.getUserID());
			workingActivity3.setAssignedUsers(assignedUsers3);
			activities.add(workingActivity3);
		}
		System.out.println( activities.get(0).getAssignedUsers());
	/*
		for (int i = 0; i < activities.size(); i++){
			System.out.println( activities.get(i).getAssignedUsers());
		}
		*/
	}
}
