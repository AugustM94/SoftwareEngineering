//These test is made by August Moebius (s144461)

package test;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

import soen.management.app.ManagementApp;
import soen.management.app.Project;
import soen.management.app.User;
import soen.management.app.userNotLoggedInException;

public class testAddProject {
	private static ManagementApp managementApp = new ManagementApp();
	private int size;
	private String name = "New project";
	private static ArrayList<Project> projects = managementApp.getProjectArray();
	private static ArrayList<User> users = managementApp.getUserArray();
	private User user;
	private User projectLeader;

//Use case 1 tests: Adding a project	
	
//Tests if the exception is thrown if no user is logged in while attempting to save project.
@Test(expected = userNotLoggedInException.class)
public void testUserNotLoggedInExceptionAddProject() throws userNotLoggedInException{
	Project project = new Project(name,0); 
	managementApp.saveProject(project);
}
	
	
	
@Test
public void testAddProject() throws userNotLoggedInException{
	//a) Find amount of projects for reference.
	//b) Login the user.
	size = projects.size();
	

	//Checks if nothing is yet added to the list of projects. 
	assertFalse(projects.size() == size+1);
	
	//a) Login user.
	//b) Create a project 
	//c) Save the project. Should pass as user is now logged in. 
	user = new User("Henrik");
	managementApp.logInUser(user.getUserID());
	Project project = new Project(name,0);
	managementApp.saveProject(project);
	
	
	//a) Check if the length of the list is size + 1
	//b) Checks if a name has been added to the project.
	assertTrue(projects.size() == size+1);
	assertTrue(project.getName() != null);
		
	
}

//Test use case 2: Adding a project leader to e

//Test if you the exception is thrown if no user is logged in while attempting to add a project leader.
@Test(expected = userNotLoggedInException.class)
public void testUserNotLoggedInExceptionAddProjectLeader() throws userNotLoggedInException{
	user = new User("Henrik");
	projectLeader = new User("Per");
	Project project = new Project(name,0);
	managementApp.addProjectLeader(projectLeader.getUserID(),project.getProjectID());
}

//Test if you the exception is thrown if no user is logged in while attempting to save project to array.
@Test(expected = userNotLoggedInException.class)
public void testUserNotLoggedInExceptionSaveProject() throws userNotLoggedInException{
	managementApp.logOutUser();
	assertEquals(managementApp.getUserStatus(), false);
	Project project = new Project(name,0);
	managementApp.saveProject(project);
	assertFalse(projects.contains(project));

}


//Test for adding project leader. 
// a) Create project
// b) Login user
// c) Add project leader to the project
// d) Check if the project leader has been added.

@Test
public void testAddProjectLeaderToProject() throws userNotLoggedInException{
	users = managementApp.getUserArray(); //Initializes users ArrayList.
	user = new User("Henrik"); //Initializes user named "Henrik".
	users.add(user); // Adds user to the user array.
	projectLeader = new User("Per"); // Initializes user named "per". He will be project leader.
	users.add(projectLeader); //Adds "Per" to ArrayList. 
	Project project = new Project(name,0); 
	managementApp.logInUser(user.getUserID());
	managementApp.saveProject(project);
	managementApp.logInUser(user.getUserID());
	managementApp.addProjectLeader(projectLeader.getUserID(),project.getProjectID());
	assertEquals("Per", users.get(project.getProjectLeaderId()).getName());	
}


@Test
public void testSaveProjectToArray() throws userNotLoggedInException{
	managementApp.logInUser(0);
	Project project = new Project(name,0); 
	managementApp.saveProject(project);
	assertTrue(projects.contains(project));
}
	
}
