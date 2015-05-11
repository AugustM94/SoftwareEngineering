//This file is for various tests regarding project management. 
//These tests are created to increase code coverage.

package test;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import soen.management.app.ManagementApp;
import soen.management.app.Project;

public class TestVariousProject {
	private static ManagementApp managementApp = new ManagementApp();
	private Project project = new Project("Name",0);
	private static ArrayList<Project> projects = managementApp.getProjectArray();
		
	@Test
	public void testGetProjectId(){
		projects.add(project);
		assertEquals(0,project.getProjectID());
		}
	
	
}
