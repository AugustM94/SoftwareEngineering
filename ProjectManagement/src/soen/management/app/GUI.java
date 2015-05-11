//The work with this has been evenly distributed between project members. 

package soen.management.app;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private ManagementApp managementApp = new ManagementApp();
	JPanel chooseUser = new JPanel();
	JPanel assignProject = new JPanel();
	JPanel Project = new JPanel();
	JPanel Activity = new JPanel();
	JPanel addActivityP = new JPanel();
	JPanel addprojectLeader = new JPanel();
	JPanel editActivityP = new JPanel();
	static Project currentProject = null;
	static Activity currentActivity = null;

	JTextField projectProjectName = new JTextField(20);
	JTextField projectStartDate = new JTextField(20);
	JTextField projectEndDate = new JTextField(20);
	JTextField projectProjectLeaderID = new JTextField(20);
	JTextField projectProjectType = new JTextField(20);
	JCheckBox projectActive = new JCheckBox("");
	JLabel projectSubmit = new JLabel("Submit");
	
	JTextField activityActivityName = new JTextField(20);
	JTextField activityStartDate = new JTextField(20);
	JTextField activityEndDate = new JTextField(20);
	JTextField activityHoursBudgetted = new JTextField(20);
	JCheckBox activityActive = new JCheckBox("");
	JLabel activitySubmit = new JLabel("Submit");
	
	JTextArea projectOverview = new JTextArea();
	
	CustomMouseListener customMouseListener = null;
	
	
	GUI(){
	    super("Project Management"); 
	    
	    setBounds(200,200,600,400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(null);
	    Container con = this.getContentPane(); 
	    setchooseUser();
	    setassignProject();
	    setProject();
	    setActivity();
	    setaddActivityP();
	    setaddprojectLeader();
	    setaddActivityP();

	    con.add(chooseUser);
	    con.add(assignProject);
	    con.add(Project);
	    con.add(Activity);
	    con.add(addActivityP);
	    con.add(addprojectLeader);
	    
	    
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
			userLabels[i].addMouseListener(new CustomMouseListener("showUsers",Project, chooseUser, users.get(i)));
			chooseUser.add(userLabels[i]);
		}
	}
	public void setassignProject() {
		
		JLabel assignProjectHeader = new JLabel("Assign Project or Non-Project-Activity");
		assignProjectHeader.setSize(600,30);
		assignProjectHeader.setLocation(0,0);
		assignProjectHeader.setBackground(new Color(0x0e2f44));
		assignProjectHeader.setForeground(new Color(0xe5e5ff));
		assignProjectHeader.setHorizontalAlignment(SwingConstants.CENTER);
		assignProjectHeader.setOpaque(true);
		assignProject.add(assignProjectHeader);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
<<<<<<< HEAD
		backButton.addMouseListener(new CustomMouseListener("back",Activity, chooseNPA));
		chooseNPA.add(backButton);
		
		JLabel chooseNPAHeader = new JLabel("Add Activity to Project");
		chooseNPAHeader.setSize(600,30);
		chooseNPAHeader.setLocation(0,0);
		chooseNPAHeader.setBackground(new Color(0x0e2f44));
		chooseNPAHeader.setForeground(new Color(0xe5e5ff));
		chooseNPAHeader.setHorizontalAlignment(SwingConstants.CENTER);
		chooseNPAHeader.setOpaque(true);
		chooseNPA.add(chooseNPAHeader);
		
		JLabel NPALabel = new JLabel("Non project Activities");
		NPALabel.setSize(140,35);
		NPALabel.setLocation(15,200);
		NPALabel.setBackground(new Color(0x0e2f44));
		NPALabel.setForeground(new Color(0xe5e5ff));
		NPALabel.setHorizontalAlignment(SwingConstants.CENTER);
		NPALabel.setOpaque(true); 
		NPALabel.addMouseListener(new CustomMouseListener("back",Project, chooseNPA));
		chooseNPA.add(NPALabel);
		
		JLabel ProjectLabel = new JLabel("Projects");
		ProjectLabel.setSize(140,35);
		ProjectLabel.setLocation(15,240);
		ProjectLabel.setBackground(new Color(0x0e2f44));
		ProjectLabel.setForeground(new Color(0xe5e5ff));
		ProjectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ProjectLabel.setOpaque(true);
		ProjectLabel.addMouseListener(new CustomMouseListener("back",Project, chooseNPA));
		chooseNPA.add(ProjectLabel);
=======
		backButton.addMouseListener(new CustomMouseListener("back",chooseUser, Project));
		Project.add(backButton);
		
>>>>>>> origin/master
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
		backButton.addMouseListener(new CustomMouseListener("back",chooseUser, Project));
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
			projectLabels[i].addMouseListener(new CustomMouseListener("showProjects",Activity, Project, projects.get(i)));
			
			Project.add(projectLabels[i]);
		}
		
		JLabel textarea = new JLabel("Add Project:");
		textarea.setFont(new Font("serif",Font.BOLD, 20));
		textarea.setSize(200,30);
		textarea.setLocation(180,40);
		textarea.setBackground(new Color(0xe5e5e5));
		textarea.setOpaque(true);
		Project.add(textarea);
		
		JLabel projectNameLabel = new JLabel("Name:");
		projectNameLabel.setSize(100,30);
		projectNameLabel.setLocation(180,70);
		projectNameLabel.setBackground(new Color(0xe5e5e5));
		projectNameLabel.setOpaque(true);
		Project.add(projectNameLabel);
		
		
		projectProjectName.setSize(150,30);
		projectProjectName.setLocation(290,70);
		projectProjectName.setOpaque(true);
		Project.add(projectProjectName);
		
		JLabel startDateLabel = new JLabel("Start Date:");
		startDateLabel.setSize(100,30);
		startDateLabel.setLocation(180,110);
		startDateLabel.setBackground(new Color(0xe5e5e5));
		startDateLabel.setOpaque(true);
		Project.add(startDateLabel);
		
		projectStartDate.setSize(150,30);
		projectStartDate.setLocation(290,110);
		projectStartDate.setOpaque(true);
		Project.add(projectStartDate);
		
		JLabel endDateLabel = new JLabel("End Date:");
		endDateLabel.setSize(100,30);
		endDateLabel.setLocation(180,150);
		endDateLabel.setBackground(new Color(0xe5e5e5));
		endDateLabel.setOpaque(true);
		Project.add(endDateLabel);
		
		
		projectEndDate.setSize(150,30);
		projectEndDate.setLocation(290,150);
		projectEndDate.setOpaque(true);
		Project.add(projectEndDate);
		
		JLabel projectLeaderIDLabel = new JLabel("ProjectLeaderID:");
		projectLeaderIDLabel.setSize(100,30);
		projectLeaderIDLabel.setLocation(180,190);
		projectLeaderIDLabel.setBackground(new Color(0xe5e5e5));
		projectLeaderIDLabel.setOpaque(true);
		Project.add(projectLeaderIDLabel);
		
		
		projectProjectLeaderID.setSize(150,30);
		projectProjectLeaderID.setLocation(290,190);
		projectProjectLeaderID.setOpaque(true);
		Project.add(projectProjectLeaderID);
		
		JLabel projectTypeLabel = new JLabel("Project Type:");
		projectTypeLabel.setSize(100,30);
		projectTypeLabel.setLocation(180,230);
		projectTypeLabel.setBackground(new Color(0xe5e5e5));
		projectTypeLabel.setOpaque(true);
		Project.add(projectTypeLabel);
		
		
		projectProjectType.setSize(150,30);
		projectProjectType.setLocation(290,230);
		projectProjectType.setOpaque(true);
		Project.add(projectProjectType);
		
		JLabel activeLabel = new JLabel("Active:");
		activeLabel.setSize(100,30);
		activeLabel.setLocation(180,270);
		activeLabel.setBackground(new Color(0xe5e5e5));
		activeLabel.setOpaque(true);
		Project.add(activeLabel);

		
		projectActive.setSize(150,30);
		projectActive.setLocation(290,270);
		projectActive.setOpaque(true);
		Project.add(projectActive);
		
		
		
		projectSubmit.setSize(100,30);
		projectSubmit.setLocation(460,270);
		projectSubmit.setBackground(new Color(0x0e2f44));
		projectSubmit.setForeground(new Color(0xe5e5ff));
		projectSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		projectSubmit.setOpaque(true);
		customMouseListener = new CustomMouseListener("addProjectSubmit",chooseUser,Project);
		projectSubmit.addMouseListener(customMouseListener);
		Project.add(projectSubmit);

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
		backButton.addMouseListener(new CustomMouseListener("back",Project, Activity));
		Activity.add(backButton);
		
		JLabel projectHeader = new JLabel("Manage Project");
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
		addActivity.addMouseListener(new CustomMouseListener("back",addActivityP, Activity));
		Activity.add(addActivity);
		
		JLabel addProjectLeader = new JLabel("Add Project leader");
		addProjectLeader.setSize(140,35);
		addProjectLeader.setLocation(15,240);
		addProjectLeader.setBackground(new Color(0x0e2f44));
		addProjectLeader.setForeground(new Color(0xe5e5ff));
		addProjectLeader.setHorizontalAlignment(SwingConstants.CENTER);
		addProjectLeader.setOpaque(true);
		addProjectLeader.addMouseListener(new CustomMouseListener("back",addprojectLeader, Activity));
		Activity.add(addProjectLeader);
		
		JLabel[] activityLabels = new JLabel[activities.size()];
		for (int i = 0; i < activities.size(); i++){
			activityLabels[i] = new JLabel(activities.get(i).getName());
			activityLabels[i].setSize(140,35);
			activityLabels[i].setLocation(15, (i+1)*40);
			activityLabels[i].setBackground(new Color(0x8697a1));
			activityLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			activityLabels[i].setOpaque(true);
			activityLabels[i].addMouseListener(new CustomMouseListener("ShowHideActivity",editActivityP, Activity, activities.get(i)));
			Activity.add(activityLabels[i]);
			
		} 
		projectOverview.setSize(370,310);
		projectOverview.setLocation(200,40);
		projectOverview.setBackground(new Color(0xe5e5e5));
		projectOverview.setOpaque(true);
		String s = managementApp.printProjectSummary(0);
		projectOverview.setText(s);
		System.out.println(s);
		Activity.add(projectOverview);
	}
	
	public void setaddActivityP(){
		
		addActivityP.setBackground(new Color(0xe5e5e5));
		addActivityP.setSize(600, 400);
		addActivityP.setLocation(0, 0);
		addActivityP.setLayout(null);
		addActivityP.setVisible(false);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener("back",Activity, addActivityP));
		addActivityP.add(backButton);
		
		JLabel addActivityHeader = new JLabel("Add Activity to Project");
		addActivityHeader.setSize(600,30);
		addActivityHeader.setLocation(0,0);
		addActivityHeader.setBackground(new Color(0x0e2f44));
		addActivityHeader.setForeground(new Color(0xe5e5ff));
		addActivityHeader.setHorizontalAlignment(SwingConstants.CENTER);
		addActivityHeader.setOpaque(true);
		addActivityP.add(addActivityHeader);
		
		JLabel activityNameLabel = new JLabel("Activity Name:");
		activityNameLabel.setSize(100,30);
		activityNameLabel.setLocation(30,70);
		activityNameLabel.setBackground(new Color(0xe5e5e5));
		activityNameLabel.setOpaque(true);
		addActivityP.add(activityNameLabel);
		
		
		activityActivityName.setSize(150,30);
		activityActivityName.setLocation(150,70);
		activityActivityName.setOpaque(true);
		addActivityP.add(activityActivityName);
		
		JLabel startDateLabel = new JLabel("Start Date:");
		startDateLabel.setSize(100,30);
		startDateLabel.setLocation(30,110);
		startDateLabel.setBackground(new Color(0xe5e5e5));
		startDateLabel.setOpaque(true);
		addActivityP.add(startDateLabel);
		
		activityStartDate.setSize(150,30);
		activityStartDate.setLocation(150,110);
		activityStartDate.setOpaque(true);
		addActivityP.add(activityStartDate);
		
		JLabel endDateLabel = new JLabel("End Date:");
		endDateLabel.setSize(100,30);
		endDateLabel.setLocation(30,150);
		endDateLabel.setBackground(new Color(0xe5e5e5));
		endDateLabel.setOpaque(true);
		addActivityP.add(endDateLabel);
		
		
		activityEndDate.setSize(150,30);
		activityEndDate.setLocation(150,150);
		activityEndDate.setOpaque(true);
		addActivityP.add(activityEndDate);
		
		JLabel hoursBudgettedLabel = new JLabel("Hours Budgetted:");
		hoursBudgettedLabel.setSize(100,30);
		hoursBudgettedLabel.setLocation(30,190);
		hoursBudgettedLabel.setBackground(new Color(0xe5e5e5));
		hoursBudgettedLabel.setOpaque(true);
		addActivityP.add(hoursBudgettedLabel);
		
		
		activityHoursBudgetted.setSize(150,30);
		activityHoursBudgetted.setLocation(150,190);
		activityHoursBudgetted.setOpaque(true);
		addActivityP.add(activityHoursBudgetted);
		
		JLabel activeLabel = new JLabel("Active:");
		activeLabel.setSize(100,30);
		activeLabel.setLocation(30,230);
		activeLabel.setBackground(new Color(0xe5e5e5));
		activeLabel.setOpaque(true);
		addActivityP.add(activeLabel);

		activityActive.setSize(150,30);
		activityActive.setLocation(150,230);
		activityActive.setOpaque(true);
		addActivityP.add(activityActive);

		activitySubmit.setSize(100,30);
		activitySubmit.setLocation(310,230);
		activitySubmit.setBackground(new Color(0x0e2f44));
		activitySubmit.setForeground(new Color(0xe5e5ff));
		activitySubmit.setHorizontalAlignment(SwingConstants.CENTER);
		activitySubmit.setOpaque(true);
		customMouseListener = new CustomMouseListener("addActivitySubmit");
		activitySubmit.addMouseListener(customMouseListener);
		addActivityP.add(activitySubmit);
	}
	
	public void setediActivityP(){
		
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
		backButton.addMouseListener(new CustomMouseListener("back",Activity, editActivityP));
		editActivityP.add(backButton);
		
		JLabel addActivityHeader = new JLabel("Edit activity");
		addActivityHeader.setSize(600,30);
		addActivityHeader.setLocation(0,0);
		addActivityHeader.setBackground(new Color(0x0e2f44));
		addActivityHeader.setForeground(new Color(0xe5e5ff));
		addActivityHeader.setHorizontalAlignment(SwingConstants.CENTER);
		addActivityHeader.setOpaque(true);
		editActivityP.add(addActivityHeader);

	}
	public void setaddprojectLeader(){
		ArrayList<User> users = managementApp.getUserArray();

		addprojectLeader.setBackground(new Color(0xe5e5e5));
		addprojectLeader.setSize(600, 400);
		addprojectLeader.setLocation(0, 0);
		addprojectLeader.setLayout(null);
		addprojectLeader.setVisible(false);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener("back", Activity, addprojectLeader));
		addprojectLeader.add(backButton);
		
		JLabel addActivityHeader = new JLabel("Add Leader");
		addActivityHeader.setSize(600,30);
		addActivityHeader.setLocation(0,0);
		addActivityHeader.setBackground(new Color(0x0e2f44));
		addActivityHeader.setForeground(new Color(0xe5e5ff));
		addActivityHeader.setHorizontalAlignment(SwingConstants.CENTER);
		addActivityHeader.setOpaque(true);
		addprojectLeader.add(addActivityHeader);
		
		JLabel[] userLabels = new JLabel[users.size()];
		for (int i = 0; i < users.size(); i++){
			userLabels[i] = new JLabel(users.get(i).getName());
			userLabels[i].setSize(140,35);
			userLabels[i].setLocation(15, (i+1)*40);
			userLabels[i].setBackground(new Color(0x8697a1));
			userLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			userLabels[i].setOpaque(true);
			customMouseListener = new CustomMouseListener("editProjectLeader",Activity,addprojectLeader,users.get(i));
			userLabels[i].addMouseListener(customMouseListener);
			addprojectLeader.add(userLabels[i]);
		}
		
	}
	
	class CustomMouseListener implements MouseListener{
		User user;
		Project project;
		Activity activity;
		JPanel viewShow;
		JPanel viewHide;
		boolean eproject;
		boolean eactivity;
		String typeOfListener;
		
		CustomMouseListener(String typeOfListener){
			this.typeOfListener=typeOfListener;
			eproject = true;
		}
		CustomMouseListener(String typeOfListener,JPanel viewShow, JPanel viewHide){
			this.typeOfListener=typeOfListener;
			this.viewShow = viewShow;
			this.viewHide = viewHide;	
		}
		
		CustomMouseListener(String typeOfListener,JPanel viewShow, JPanel viewHide, User user){
			this.typeOfListener=typeOfListener;
			this.user = user;
			this.viewShow = viewShow;
			this.viewHide = viewHide;
		}
		CustomMouseListener(String typeOfListener,JPanel viewShow, JPanel viewHide, Project project){
			this.typeOfListener=typeOfListener;
			this.project = project;
			this.viewShow = viewShow;
			this.viewHide = viewHide;
		}
		
		CustomMouseListener(String typeOfListener,JPanel viewShow, JPanel viewHide, Activity activity){
			this.typeOfListener=typeOfListener;
			this.activity = activity;
			this.viewShow = viewShow;
			this.viewHide = viewHide;
		}
		
		
	    public void mouseClicked(MouseEvent e) {

	    	if (typeOfListener.equals("back") ){
	        	viewShow.setVisible(true);
	    		viewHide.setVisible(false);
	    	}
	    	else if(typeOfListener.equals("showUsers")){
	    		viewShow.setVisible(true);
	    		viewHide.setVisible(false);
	    		managementApp.logInUser(user.getUserID());
	    		
	    	}
	    	else if (typeOfListener.equals("showProjects")){
	    		System.out.println(project.getName());
	    		currentProject = project;
	    		projectOverview.setText(managementApp.printProjectSummary(currentProject.getProjectID()));
	    		viewShow.setVisible(true);
	    		viewHide.setVisible(false);
	    		
	    	}
	    	else if (typeOfListener.equals("ShowHideActivities")){
	    		System.out.println(activity.getName());
	    		currentActivity = activity;
	    		viewShow.setVisible(true);
	    		viewHide.setVisible(false);
	    		
	    	}
	    	else if(typeOfListener.equals("addProjectSubmit")){
	    		
	    		Project newProject = new Project(projectProjectName.getText(), Integer.parseInt(projectProjectType.getText()));
	    		
	    		if(projectStartDate.getText().length() > 0){
	    			newProject.setStartDate(Integer.parseInt(projectStartDate.getText()));
	    		}
	    	
		    	if(projectEndDate.getText().length() > 0){
		    		newProject.setEndDate(Integer.parseInt(projectEndDate.getText()));
		    	}
		    	
		    	if(projectProjectLeaderID.getText().length() > 0){
		    		newProject.setProjectLeaderId(Integer.parseInt(projectProjectLeaderID.getText()));
		    	}
		    	
		    	if(projectActive.getText().length() > 0){
		    		newProject.setActive(projectActive.isSelected());
		    		
		    	}
		    System.out.println(managementApp.projects.size());
		    managementApp.projects.add(newProject);
		    System.out.println(managementApp.projects.size());
		    managementApp.saveProjects();
	    	}
	    	else if(typeOfListener.equals("addActivitySubmit")){
	    	 
	    		Activity newActivity = new Activity(activityActivityName.getText(), currentProject.getProjectID());
	    		
	    		if(activityStartDate.getText().length() > 0){
	    			newActivity.setStartDate(Integer.parseInt(activityStartDate.getText()));
	    		}
	    	
		    	if(activityEndDate.getText().length() > 0){
		    		newActivity.setEndDate(Integer.parseInt(activityEndDate.getText()));
		    	}
		    	
		    	if(activityHoursBudgetted.getText().length() > 0){
		    		newActivity.setHoursBudgeted(Integer.parseInt(activityHoursBudgetted.getText()));
		    	}
		    	
		    	if(projectActive.getText().length() > 0){
		    		newActivity.setActive(projectActive.isSelected());
		    		
		    	}
		    System.out.println(managementApp.activities.size());
		    managementApp.activities.add(newActivity);
		    System.out.println(managementApp.activities.size());
		    managementApp.saveActivities();
	    	}
	    	else if (typeOfListener.equals("editProjectLeader")){
	    		managementApp.projects.get(currentProject.getProjectID()).setProjectLeaderId(user.getUserID());
	    		viewShow.setVisible(true);
	    		viewHide.setVisible(false);
	    		managementApp.saveProjects();
	    		System.out.println(currentProject.getProjectLeaderId());
	    	}

	    	if(viewShow == Project && currentProject != null){
	    		
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
}

