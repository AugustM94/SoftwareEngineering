package test;

import static org.junit.Assert.*;

import org.junit.Test;

import soen.management.app.ManagementApp;

public class testActivities {

	@Test
	public void testAddActivity(){
		ManagementApp managementApp = new ManagementApp();
			
		// log in user
		managementApp.logInUser(1);
		assertEquals(1, managementApp.getSessionUser());

		// 
		

	}
}
