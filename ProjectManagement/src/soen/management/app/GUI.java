package soen.management.app;

import java.awt.Color;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private ManagementApp managementApp = new ManagementApp();
	JPanel chooseUser = new JPanel();
	JPanel Project = new JPanel();
	JPanel Activity = new JPanel();
	JPanel editActivityP = new JPanel();
	JPanel adProject = new JPanel();
	JPanel ListofEmployees = new JPanel();
	JPanel deleteActivity = new JPanel();
	JPanel editName = new JPanel();
	JPanel duration = new JPanel();
	JPanel workingHours = new JPanel();
	
	static Project currentProject = null;
	
	
	/**
	 * 
	 */
	GUI(){
	    super("Project Management"); 
	    
	    setBounds(200,200,600,400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(null);
	    Container con = this.getContentPane(); 
	    setchooseUser();
	    setProject();
	    setActivity();
	    seteditActivityP();
	    setadProject();
	    setListofEmployees();
	    setdeleteActivity();
	    seteditName();
	    setduration();
	    setworkingHours();
	    
	    con.add(chooseUser);
	    con.add(Project);
	    con.add(Activity);
	    con.add(editActivityP);
	    con.add(adProject);
	    con.add(ListofEmployees);
	    con.add(deleteActivity);
	    con.add(editName);
	    con.add(duration);
	    con.add(workingHours);
	    
	    setVisible(true); // make frame visible
	}
	
	public void setchooseUser(){
		ArrayList<User> users = managementApp.getUserArray();
		
		chooseUser.setBackground(new Color(0xe5e5e5));
		chooseUser.setSize(600, 400);
		chooseUser.setLocation(0, 0);
		chooseUser.setLayout(null);
		chooseUser.setVisible(true);
		
		JLabel userHeader = new JLabel("Select a user");
		userHeader.setSize(600,30);
		userHeader.setLocation(0,0);
		userHeader.setBackground(new Color(0x0e2f44));
		userHeader.setForeground(new Color(0xe5e5ff));
		userHeader.setHorizontalAlignment(SwingConstants.CENTER);
		userHeader.setOpaque(true);
		chooseUser.add(userHeader);
		
		
		JLabel[] userLabels = new JLabel[users.size()];
		for (int i = 0; i < users.size(); i++){
			userLabels[i] = new JLabel(users.get(i).getName());
			userLabels[i].setSize(140,35);
			userLabels[i].setLocation(15, (i+1)*40);
			userLabels[i].setBackground(new Color(0x8697a1));
			userLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			userLabels[i].setOpaque(true);
			userLabels[i].addMouseListener(new CustomMouseListener(Project, chooseUser, users.get(i)));
			chooseUser.add(userLabels[i]);
		}
	}
	
	
	public void setProject(){
		ArrayList<Project> projects = managementApp.getProjectArray();
		
		Project.setBackground(new Color(0xe5e5e5));
		Project.setSize(600, 400);
		Project.setLocation(0, 0);
		Project.setLayout(null);
		Project.setVisible(false);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener(chooseUser, Project));
		Project.add(backButton);
		
		JLabel projectHeader = new JLabel("Select a project");
		projectHeader.setSize(600,30);
		projectHeader.setLocation(0,0);
		projectHeader.setBackground(new Color(0x0e2f44));
		projectHeader.setForeground(new Color(0xe5e5ff));
		projectHeader.setHorizontalAlignment(SwingConstants.CENTER);
		projectHeader.setOpaque(true);
		Project.add(projectHeader);
		
		JLabel[] projectLabels = new JLabel[projects.size()];
		for (int i = 0; i < projects.size(); i++){
			projectLabels[i] = new JLabel(projects.get(i).getName());
			projectLabels[i].setSize(140,35);
			projectLabels[i].setLocation(15, (i+1)*40);
			projectLabels[i].setBackground(new Color(0x8697a1));
			projectLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			projectLabels[i].setOpaque(true);
			projectLabels[i].addMouseListener(new CustomMouseListener(Activity, Project, projects.get(i)));
			
			Project.add(projectLabels[i]);
			
		JLabel addProject = new JLabel("Add project");
		addProject.setSize(140,35);
		addProject.setLocation(15,200);
		addProject.setBackground(new Color(0x0e2f44));
		addProject.setForeground(new Color(0xe5e5ff));
		addProject.setHorizontalAlignment(SwingConstants.CENTER);
		addProject.setOpaque(true);
		addProject.addMouseListener(new CustomMouseListener(adProject, Project));
		Project.add(addProject);
		}    
	}
	
	public void setadProject(){
		
		adProject.setBackground(new Color(0xe5e5e5));
		adProject.setSize(600, 400);
		adProject.setLocation(0, 0);
		adProject.setLayout(null);
		adProject.setVisible(true);
		
		JLabel adProjectHeader = new JLabel("Add project");
		adProjectHeader.setSize(600,30);
		adProjectHeader.setLocation(0,0);
		adProjectHeader.setBackground(new Color(0x0e2f44));
		adProjectHeader.setForeground(new Color(0xe5e5ff));
		adProjectHeader.setHorizontalAlignment(SwingConstants.CENTER);
		adProjectHeader.setOpaque(true);
		adProject.add(adProjectHeader);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener(Project, adProject));
		adProject.add(backButton);

	}

	public void setActivity(){
		ArrayList<Activity> activities = managementApp.getActivityArray();
		
		Activity.setBackground(new Color(0xe5e5e5));
		Activity.setSize(600, 400);
		Activity.setLocation(0, 0);
		Activity.setLayout(null);
		Activity.setVisible(false);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener(Project, Activity));
		Activity.add(backButton);
		
		JLabel projectHeader = new JLabel("Select an activity");
		projectHeader.setSize(600,30);
		projectHeader.setLocation(0,0);
		projectHeader.setBackground(new Color(0x0e2f44));
		projectHeader.setForeground(new Color(0xe5e5ff));
		projectHeader.setHorizontalAlignment(SwingConstants.CENTER);
		projectHeader.setOpaque(true);
		Activity.add(projectHeader);
		
		JLabel addActivity = new JLabel("Add activity to project");
		addActivity.setSize(140,35);
		addActivity.setLocation(15,200);
		addActivity.setBackground(new Color(0x0e2f44));
		addActivity.setForeground(new Color(0xe5e5ff));
		addActivity.setHorizontalAlignment(SwingConstants.CENTER);
		addActivity.setOpaque(true);
		addActivity.addMouseListener(new CustomMouseListener(Project, Activity));
		Activity.add(addActivity);
		
		JLabel[] activityLabels = new JLabel[activities.size()];
		for (int i = 0; i < activities.size(); i++){
			activityLabels[i] = new JLabel(activities.get(i).getName());
			activityLabels[i].setSize(140,35);
			activityLabels[i].setLocation(15, (i+1)*40);
			activityLabels[i].setBackground(new Color(0x8697a1));
			activityLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			activityLabels[i].setOpaque(true);
			activityLabels[i].addMouseListener(new CustomMouseListener(editActivityP, Activity, activities.get(i)));
			Activity.add(activityLabels[i]);
			
			
			JTextArea projectOverview = new JTextArea();
			projectOverview.setSize(370,310);
			projectOverview.setLocation(200,40);
			projectOverview.setBackground(new Color(0xe5e5e5));
			projectOverview.setOpaque(true);
			String s = managementApp.printProjectSummary(0);
			projectOverview.setText(s);
			Activity.add(projectOverview);
		}    
	}
	
	public void seteditActivityP(){
		
		editActivityP.setBackground(new Color(0xe5e5e5));
		editActivityP.setSize(600, 400);
		editActivityP.setLocation(0, 0);
		editActivityP.setLayout(null);
		editActivityP.setVisible(false);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener(Activity, editActivityP));
		editActivityP.add(backButton);
		
		JLabel editActivityHeader = new JLabel("Edit activity");
		editActivityHeader.setSize(600,30);
		editActivityHeader.setLocation(0,0);
		editActivityHeader.setBackground(new Color(0x0e2f44));
		editActivityHeader.setForeground(new Color(0xe5e5ff));
		editActivityHeader.setHorizontalAlignment(SwingConstants.CENTER);
		editActivityHeader.setOpaque(true);
		editActivityP.add(editActivityHeader);
		
		JLabel ListofEmployeesp = new JLabel("List of Employees");
		ListofEmployeesp.setSize(140,35);
		ListofEmployeesp.setBackground(new Color(0x0e2f44));
		ListofEmployeesp.setForeground(new Color(0xe5e5ff));
		ListofEmployeesp.setLocation(15, 40);
		ListofEmployeesp.setHorizontalAlignment(SwingConstants.CENTER);
		ListofEmployeesp.setOpaque(true);
		ListofEmployeesp.addMouseListener(new CustomMouseListener(ListofEmployees, editActivityP));
		editActivityP.add(ListofEmployeesp);
		
		JLabel deleteActivityL = new JLabel("Delete activity");
		deleteActivityL.setSize(140,35);
		deleteActivityL.setBackground(new Color(0x0e2f44));
		deleteActivityL.setForeground(new Color(0xe5e5ff));
		deleteActivityL.setLocation(15, 80);
		deleteActivityL.setHorizontalAlignment(SwingConstants.CENTER);
		deleteActivityL.setOpaque(true);
		deleteActivityL.addMouseListener(new CustomMouseListener(deleteActivity, editActivityP));
		editActivityP.add(deleteActivityL);
		
		JLabel editNameL = new JLabel("Edit name");
		editNameL.setSize(140,35);
		editNameL.setBackground(new Color(0x0e2f44));
		editNameL.setForeground(new Color(0xe5e5ff));
		editNameL.setLocation(15, 120);
		editNameL.setHorizontalAlignment(SwingConstants.CENTER);
		editNameL.setOpaque(true);
		editNameL.addMouseListener(new CustomMouseListener(editName, editActivityP));
		editActivityP.add(editNameL);
		
		JLabel DurationL = new JLabel("Duration");
		DurationL.setSize(140,35);
		DurationL.setBackground(new Color(0x0e2f44));
		DurationL.setForeground(new Color(0xe5e5ff));
		DurationL.setLocation(15, 160);
		DurationL.setHorizontalAlignment(SwingConstants.CENTER);
		DurationL.setOpaque(true);
		DurationL.addMouseListener(new CustomMouseListener(duration, editActivityP));
		editActivityP.add(DurationL);
		
		JLabel workingHoursL = new JLabel("Working Hours");
		workingHoursL.setSize(140,35);
		workingHoursL.setBackground(new Color(0x0e2f44));
		workingHoursL.setForeground(new Color(0xe5e5ff));
		workingHoursL.setLocation(15, 200);
		workingHoursL.setHorizontalAlignment(SwingConstants.CENTER);
		workingHoursL.setOpaque(true);
		workingHoursL.addMouseListener(new CustomMouseListener(workingHours, editActivityP));
		editActivityP.add(workingHoursL);
		
	}
	public void setListofEmployees(){
		
		ListofEmployees.setBackground(new Color(0xe5e5e5));
		ListofEmployees.setSize(600, 400);
		ListofEmployees.setLocation(0, 0);
		ListofEmployees.setLayout(null);
		ListofEmployees.setVisible(true);
		
		JLabel ListofEmployeesHeader = new JLabel("List of Employees");
		ListofEmployeesHeader.setSize(600,30);
		ListofEmployeesHeader.setLocation(0,0);
		ListofEmployeesHeader.setBackground(new Color(0x0e2f44));
		ListofEmployeesHeader.setForeground(new Color(0xe5e5ff));
		ListofEmployeesHeader.setHorizontalAlignment(SwingConstants.CENTER);
		ListofEmployeesHeader.setOpaque(true);
		ListofEmployees.add(ListofEmployeesHeader);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener(editActivityP, ListofEmployees));
		ListofEmployees.add(backButton);
		
	}
	public void setdeleteActivity(){
		
		deleteActivity.setBackground(new Color(0xe5e5e5));
		deleteActivity.setSize(600, 400);
		deleteActivity.setLocation(0, 0);
		deleteActivity.setLayout(null);
		deleteActivity.setVisible(true);
		
		JLabel deleteActivityHeader = new JLabel("Delete Activity");
		deleteActivityHeader.setSize(600,30);
		deleteActivityHeader.setLocation(0,0);
		deleteActivityHeader.setBackground(new Color(0x0e2f44));
		deleteActivityHeader.setForeground(new Color(0xe5e5ff));
		deleteActivityHeader.setHorizontalAlignment(SwingConstants.CENTER);
		deleteActivityHeader.setOpaque(true);
		deleteActivity.add(deleteActivityHeader);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener(editActivityP, deleteActivity));
		deleteActivity.add(backButton);
	}
	public void seteditName(){
		
		editName.setBackground(new Color(0xe5e5e5));
		editName.setSize(600, 400);
		editName.setLocation(0, 0);
		editName.setLayout(null);
		editName.setVisible(true);
		
		JLabel editNameHeader = new JLabel("Edit name");
		editNameHeader.setSize(600,30);
		editNameHeader.setLocation(0,0);
		editNameHeader.setBackground(new Color(0x0e2f44));
		editNameHeader.setForeground(new Color(0xe5e5ff));
		editNameHeader.setHorizontalAlignment(SwingConstants.CENTER);
		editNameHeader.setOpaque(true);
		editName.add(editNameHeader);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener(editActivityP, editName));
		editName.add(backButton);
	}
	public void setduration(){
		
		duration.setBackground(new Color(0xe5e5e5));
		duration.setSize(600, 400);
		duration.setLocation(0, 0);
		duration.setLayout(null);
		duration.setVisible(true);
		
		JLabel durationHeader = new JLabel("Edit name");
		durationHeader.setSize(600,30);
		durationHeader.setLocation(0,0);
		durationHeader.setBackground(new Color(0x0e2f44));
		durationHeader.setForeground(new Color(0xe5e5ff));
		durationHeader.setHorizontalAlignment(SwingConstants.CENTER);
		durationHeader.setOpaque(true);
		duration.add(durationHeader);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener(editActivityP, duration));
		duration.add(backButton);
	}
	public void setworkingHours(){
		
		workingHours.setBackground(new Color(0xe5e5e5));
		workingHours.setSize(600, 400);
		workingHours.setLocation(0, 0);
		workingHours.setLayout(null);
		workingHours.setVisible(true);
		
		JLabel workingHoursHeader = new JLabel("Edit name");
		workingHoursHeader.setSize(600,30);
		workingHoursHeader.setLocation(0,0);
		workingHoursHeader.setBackground(new Color(0x0e2f44));
		workingHoursHeader.setForeground(new Color(0xe5e5ff));
		workingHoursHeader.setHorizontalAlignment(SwingConstants.CENTER);
		workingHoursHeader.setOpaque(true);
		workingHours.add(workingHoursHeader);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener(editActivityP, workingHours));
		workingHours.add(backButton);
	}
}
class CustomMouseListener implements MouseListener{

	User user;
	Project project;
	Activity activity;
	JPanel viewShow;
	JPanel viewHide;

	CustomMouseListener(){
		
	}
	CustomMouseListener(JPanel viewShow, JPanel viewHide){
		this.viewShow = viewShow;
		this.viewHide = viewHide;	
	}
	
	CustomMouseListener(JPanel viewShow, JPanel viewHide, User user){
		this.user = user;
		this.viewShow = viewShow;
		this.viewHide = viewHide;
	}
	CustomMouseListener(JPanel viewShow, JPanel viewHide, Project project){
		this.project = project;
		this.viewShow = viewShow;
		this.viewHide = viewHide;
	}
	CustomMouseListener(JPanel viewShow, JPanel viewHide, Activity activity){
		this.activity = activity;
		this.viewShow = viewShow;
		this.viewHide = viewHide;
	}
	
	
    public void mouseClicked(MouseEvent e) {

    	if (user != null){
        	viewShow.setVisible(true);
    		viewHide.setVisible(false);
    	}
    	else if (project != null){
    		System.out.println(project.getName());
    		viewShow.setVisible(true);
    		viewHide.setVisible(false);
    	}
    	else if (activity !=null){
    		System.out.println(activity.getName());
    		viewShow.setVisible(true);
    		viewHide.setVisible(false);
    		
    	}
    	else {
    		viewShow.setVisible(true);
    		viewHide.setVisible(false);
    	}

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
