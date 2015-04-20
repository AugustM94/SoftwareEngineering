package soen.management.app;

public class ManagementApp {
	public static User user;
	public static User user2;
	static FileReader fileReader = new FileReader();
	
	public static void main(String[] args) {

		User user = new User("Nicki");
		//System.out.println(user.getUserID());
		fileReader.getFileData();
		System.out.println("did this shit");
	}
	
}
