package soen.management.app;

public class User {
	private String name = "test";
	
	public User(String name){
		this.name = name;
	}
	
	public User() {
		
	}

	public String getName(){
		return this.name;
	}
}
