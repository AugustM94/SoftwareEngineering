package soen.management.app;

public class User {
	private static int UserID;
	private String name;
	private Activity activties[];
	private int Hours[][];
	
	
	public User(String name){
		this.name = name;
	}
	
	public User() {
		
	}

	public String getName(){
		return this.name;
	}
}
