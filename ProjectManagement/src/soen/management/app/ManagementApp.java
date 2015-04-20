package soen.management.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ManagementApp {
	public static User user;
	public static User user2;
	
	public static void main(String[] args) throws FileNotFoundException {

		User user = new User("Nicki");
		//System.out.println(user.getUserID());
		
		Scanner input;
		
		input = new Scanner(new File("src/hej.txt"));
		while (input.hasNext()){
			String something = (String)input.nextLine();
			System.out.println(something);
		}
	}
}
