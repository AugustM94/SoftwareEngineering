package test;

import static org.junit.Assert.*;

import java.sql.Savepoint;
import java.util.ArrayList;

import org.junit.Test;

import soen.management.app.ManagementApp;
import soen.management.app.Project;
import soen.management.app.User;
import soen.management.app.userNotLoggedInException;

public class testAddProject {
	private ManagementApp managementApp = new ManagementApp();
	private int size;
	private String name = "New project";
	private static ArrayList<Project> projects;
	private User user;

//Test if you the exception is thrown if no user is logged in.
@Test(expected = userNotLoggedInException.class)
public void testUserNotLoggedInException() throws userNotLoggedInException{
	Project project = new Project(name,0);
	managementApp.saveProject(project);
}
	
	
	
@Test
public void testAddProject() throws userNotLoggedInException{
	projects = managementApp.getProjectArray();
	//a) Find amount of projects for reference.
	//b) Login the user.
	size = projects.size();
	managementApp.logInUser(user.getUserID());
	

	//Checks if nothing is yet added to the list of projects. 
	assertFalse(projects.size() == size+1);
	
	//a) Select user.
	//b) Create a project 
	//c) Attempt to save project. Should pass as user i logged in. 
	

	Project project = new Project(name,0);
	managementApp.saveProject(project);
	
	//a) Check if the length of the list is size + 1
	//b) Checks if a name has been added to the project.
	System.out.println(size);
	assertTrue(projects.size() == size+1);
	assertTrue(project.getName() != null);
		
	
	
	
}
	
	
}
