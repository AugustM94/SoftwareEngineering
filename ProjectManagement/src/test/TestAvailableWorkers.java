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
		int startRequestTime = 1430438400; // 1. may 2015
		int endRequestTime = 1431648000;  // 15. may 2015
		
		
		// log in user
		User user = new User("test project leader");
		user.setUserID(1);
		users.add(user);
		User user2 = new User("test worker 1");
		user2.setUserID(2);
		users.add(user2);
		User user3 = new User("test worker 2");
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
		
		// test if correctly returned project with user as projectLeader
		assertEquals(0, (int)projectLeaderProjects.get(0));
		
		
		Project selectedProject;
		// if user is project leader of at least 1 project
		if (projectLeaderProjects.size() > 0){
			selectedProject = projects.get(0);
		
			// check if there are currently no activities 
			assertEquals(0, activities.size());
			
			// new activity to search for users for
			Activity mainActivity = new Activity("Main activity",selectedProject.getProjectID());
			activities.add(mainActivity);
			
			
			// adding activities to have something to search among
			// user 2's activity from February to April
			Activity workingActivity1 = new Activity("worker activity 01.feb-15.apr",selectedProject.getProjectID());
			workingActivity1.setStartDate(1422748800);
			workingActivity1.setEndDate(1429056000);
			ArrayList<Integer> assignedUsers1 = workingActivity1.getAssignedUsers();
			assignedUsers1.add(user2.getUserID());
			workingActivity1.setAssignedUsers(assignedUsers1);
			activities.add(workingActivity1);
			
			// user 2's activity from October to December
			Activity workingActivity2 = new Activity("worker activity 01.oct-01.dec",selectedProject.getProjectID());
			workingActivity2.setStartDate(1443657600);
			workingActivity2.setEndDate(1448928000);
			ArrayList<Integer> assignedUsers2 = workingActivity2.getAssignedUsers();
			assignedUsers2.add(user2.getUserID());
			workingActivity2.setAssignedUsers(assignedUsers2);
			activities.add(workingActivity2);

			
			// user 3's activity from May to June
			Activity workingActivity3 = new Activity("worker activity 01.may-01.jun",selectedProject.getProjectID());
			workingActivity3.setStartDate(1430438400);
			workingActivity3.setEndDate(1433116800);
			ArrayList<Integer> assignedUsers3 =  workingActivity3.getAssignedUsers();
			assignedUsers3.add(user3.getUserID());
			workingActivity3.setAssignedUsers(assignedUsers3);
			activities.add(workingActivity3);
		}
		
		
		
		int[] availableUsers = new int[users.size()];
	
		for (int i = 0; i < users.size(); i++){
			for (int j = 0; j < activities.size(); j++){
				for (int k = 0; k < activities.get(j).getAssignedUsers().size(); k++)
				{		
					if (activities.get(j).getAssignedUsers().get(k) == users.get(i).getUserID()){
						if ( (activities.get(j).getStartDate() < startRequestTime && activities.get(j).getEndDate() > startRequestTime) ||
								(activities.get(j).getStartDate() < endRequestTime && activities.get(j).getEndDate() > endRequestTime)){
								availableUsers[i] = 1;
						}
					}
				}
			}
		}
		
		// create array of expected outputs
		int[] expectedAvailableUsers =  new int[users.size()];
		expectedAvailableUsers[0] = 0;
		expectedAvailableUsers[1] = 0;
		expectedAvailableUsers[2] = 1;	
		
		// check if expected available users
		for (int i = 0; i < availableUsers.length; i++){
			assertEquals(expectedAvailableUsers[i], availableUsers[i]);
		}
		
		
	}
}
