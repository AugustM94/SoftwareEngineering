package test;

import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;
import soen.management.app.ManagementApp;
import soen.management.app.Project;
import soen.management.app.userNotLoggedInException;

public class TestProjectSummaryPrint {
	private ManagementApp managementApp = new ManagementApp();
	private ArrayList<Project> projects = managementApp.getProjectArray();
	private Project project;
	
	@Test
	public void testProjectSummaryPrint() throws userNotLoggedInException{
		projects = managementApp.getProjectArray();
		managementApp.logInUser(0);
		project = new Project("Project 1",0);
		managementApp.saveProject(project);;
		System.out.println(projects.get(0).getName());
		String s = managementApp.printProjectSummary(0);
		System.out.println(s);
	}
	
	
	
}
