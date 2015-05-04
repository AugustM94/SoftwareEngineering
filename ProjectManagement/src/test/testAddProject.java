package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import soen.management.app.ManagementApp;
import soen.management.app.Project;
import soen.management.app.User;

public class testAddProject {
	private ManagementApp managementApp;
	private int size;
	private String name;
	static ArrayList<Project> projects;
	
	
@Test
public void testAddProject(){
	managementApp = new ManagementApp();
	projects = managementApp.getProjectArray();
	//Find amount of projects for reference.
	size = projects.size();
	//Create a name for the project
	name = "New project";
	
	//Checks if nothing is yet added to the list of projects. 
	assertFalse(projects.size() == size+1);
	
	//a) Create a project 
	//b) Add it to the list of projects
	
	Project project = new Project(name,0);
	projects.add(project);
	
	//a) Check if the length of the list is size + 1
	//b) Checks if a name has been added to the project.
	assertTrue(projects.size() == size+1);
	assertTrue(project.getName() != null);
}
	
}
