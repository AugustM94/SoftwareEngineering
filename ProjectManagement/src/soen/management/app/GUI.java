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
	JPanel manageActivityP = new JPanel();
	JPanel editActivityP = new JPanel();
	JPanel addWorkingHours = new JPanel();
	JPanel chooseNPA = new JPanel();
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
	
	JTextField activityAddHours = new JTextField(20);
	JLabel addWorkingHoursSubmit = new JLabel("Submit");
	
	JTextArea projectOverview = new JTextArea();
	JTextArea activityOverview = new JTextArea();
	
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
	    setAddActivityP();
	    setManageActivityP();
	    setaddprojectLeader();
	    setEditActivity();
	    setAddWorkingHours();
	    setChooseNPA();

	    con.add(chooseUser);
	    con.add(assignProject);
	    con.add(Project);
	    con.add(Activity);
	    con.add(addActivityP);
	    con.add(manageActivityP);
	    con.add(addprojectLeader);
	    con.add(editActivityP);
	    con.add(addWorkingHours);
	    con.add(chooseNPA);
	    
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
			userLabels[i].addMouseListener(new CustomMouseListener("showUsers",chooseNPA, chooseUser, users.get(i)));
			chooseUser.add(userLabels[i]);
		}
	}
	public void setassignProject() {
		JLabel userHeader = new JLabel("Assign Project or Non-Project-Activity");
		userHeader.setSize(600,30);
		userHeader.setLocation(0,0);
		userHeader.setBackground(new Color(0x0e2f44));
		userHeader.setForeground(new Color(0xe5e5ff));
		userHeader.setHorizontalAlignment(SwingConstants.CENTER);
		userHeader.setOpaque(true);
		chooseUser.add(userHeader);
	}
	
	public void setChooseNPA(){
		chooseNPA.setBackground(new Color(0xe5e5e5));
		chooseNPA.setSize(600, 400);
		chooseNPA.setLocation(0, 0);
		chooseNPA.setLayout(null);
		chooseNPA.setVisible(false);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
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
			activityLabels[i].addMouseListener(new CustomMouseListener("showActivity",manageActivityP, Activity, activities.get(i)));
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
	
	public void setAddActivityP(){
		
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
		customMouseListener = new CustomMouseListener("addActivitySubmit", Activity, addActivityP);
		activitySubmit.addMouseListener(customMouseListener);
		addActivityP.add(activitySubmit);
	}
	
	public void setManageActivityP(){
		
		manageActivityP.setBackground(new Color(0xe5e5e5));
		manageActivityP.setSize(600, 400);
		manageActivityP.setLocation(0, 0);
		manageActivityP.setLayout(null);
		manageActivityP.setVisible(false);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener("back",Activity, manageActivityP));
		manageActivityP.add(backButton);
		
		JLabel manageActivityHeader = new JLabel("Manage activity");
		manageActivityHeader.setSize(600,30);
		manageActivityHeader.setLocation(0,0);
		manageActivityHeader.setBackground(new Color(0x0e2f44));
		manageActivityHeader.setForeground(new Color(0xe5e5ff));
		manageActivityHeader.setHorizontalAlignment(SwingConstants.CENTER);
		manageActivityHeader.setOpaque(true);
		manageActivityP.add(manageActivityHeader);
		
		activityOverview.setSize(370,310);
		activityOverview.setLocation(200,40);
		activityOverview.setBackground(new Color(0xe5e5e5));
		activityOverview.setOpaque(true);
		String s = managementApp.printActivitySummary(0);
		activityOverview.setText(s);
		System.out.println(s);
		manageActivityP.add(activityOverview);
		
		JLabel addWorkingHoursLabel = new JLabel("Add working hours");
		addWorkingHoursLabel.setSize(140,35);
		addWorkingHoursLabel.setLocation(15,200);
		addWorkingHoursLabel.setBackground(new Color(0x0e2f44));
		addWorkingHoursLabel.setForeground(new Color(0xe5e5ff));
		addWorkingHoursLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addWorkingHoursLabel.setOpaque(true);
		addWorkingHoursLabel.addMouseListener(new CustomMouseListener("back",addWorkingHours, manageActivityP));
		manageActivityP.add(addWorkingHoursLabel);
		
		JLabel editActivity = new JLabel("Edit activity");
		editActivity.setSize(140,35);
		editActivity.setLocation(15,240);
		editActivity.setBackground(new Color(0x0e2f44));
		editActivity.setForeground(new Color(0xe5e5ff));
		editActivity.setHorizontalAlignment(SwingConstants.CENTER);
		editActivity.setOpaque(true);
		editActivity.addMouseListener(new CustomMouseListener("back",editActivityP, manageActivityP));
		manageActivityP.add(editActivity);
	}
	
	public void setEditActivity(){
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
		backButton.addMouseListener(new CustomMouseListener("back",manageActivityP, editActivityP));
		editActivityP.add(backButton);
		
		JLabel editActivityHeader = new JLabel("Manage activity");
		editActivityHeader.setSize(600,30);
		editActivityHeader.setLocation(0,0);
		editActivityHeader.setBackground(new Color(0x0e2f44));
		editActivityHeader.setForeground(new Color(0xe5e5ff));
		editActivityHeader.setHorizontalAlignment(SwingConstants.CENTER);
		editActivityHeader.setOpaque(true);
		editActivityP.add(editActivityHeader);
	}
	
	public void setAddWorkingHours(){
		addWorkingHours.setBackground(new Color(0xe5e5e5));
		addWorkingHours.setSize(600, 400);
		addWorkingHours.setLocation(0, 0);
		addWorkingHours.setLayout(null);
		addWorkingHours.setVisible(false);
		
		JLabel backButton = new JLabel("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setForeground(new Color(0xe5e5ff));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener("back",manageActivityP, addWorkingHours));
		addWorkingHours.add(backButton);
		
		JLabel editActivityHeader = new JLabel("Add working hours");
		editActivityHeader.setSize(600,30);
		editActivityHeader.setLocation(0,0);
		editActivityHeader.setBackground(new Color(0x0e2f44));
		editActivityHeader.setForeground(new Color(0xe5e5ff));
		editActivityHeader.setHorizontalAlignment(SwingConstants.CENTER);
		editActivityHeader.setOpaque(true);
		addWorkingHours.add(editActivityHeader);
		
		JLabel addHoursLabel = new JLabel("Add hours:");
		addHoursLabel.setSize(100,30);
		addHoursLabel.setLocation(30,190);
		addHoursLabel.setBackground(new Color(0xe5e5e5));
		addHoursLabel.setOpaque(true);
		addWorkingHours.add(addHoursLabel);
		
		activityAddHours.setSize(150,30);
		activityAddHours.setLocation(150,190);
		activityAddHours.setOpaque(true);
		addWorkingHours.add(activityAddHours);
		
		addWorkingHoursSubmit.setSize(100,30);
		addWorkingHoursSubmit.setLocation(460,270);
		addWorkingHoursSubmit.setBackground(new Color(0x0e2f44));
		addWorkingHoursSubmit.setForeground(new Color(0xe5e5ff));
		addWorkingHoursSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		addWorkingHoursSubmit.setOpaque(true);
		customMouseListener = new CustomMouseListener("addWorkingHoursSubmit",manageActivityP,addWorkingHours);
		addWorkingHoursSubmit.addMouseListener(customMouseListener);
		addWorkingHours.add(addWorkingHoursSubmit);
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
	    	else if (typeOfListener.equals("showActivity")){
	    		
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

		    managementApp.projects.add(newProject);
		    managementApp.saveProjects();
		    viewShow.setVisible(true);
    		viewHide.setVisible(false);
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
		    	
			    managementApp.activities.add(newActivity);
			    managementApp.saveActivities();
			    viewShow.setVisible(true);
	    		viewHide.setVisible(false);
	    	}
	    	else if (typeOfListener.equals("editProjectLeader")){
	    		managementApp.projects.get(currentProject.getProjectID()).setProjectLeaderId(user.getUserID());
	    		//currentProject.setProjectLeaderId(user.getUserID());
	    		viewShow.setVisible(true);
	    		viewHide.setVisible(false);
	    		managementApp.saveProjects();
	    		System.out.println(currentProject.getProjectLeaderId());
	    	}
	    	
	    	else if (typeOfListener.equals("addWorkingHoursSubmit")){
	    		System.out.println("asdasda");
	    		int hours = 0;
	    		if (activityAddHours.getText().length() > 0){
	    			hours = Integer.parseInt(activityAddHours.getText() );
	    		}
	    		try {
					managementApp.registerWorkingHours(currentActivity.getActivityID(),hours);
				} catch (userNotLoggedInException e1) {
					e1.printStackTrace();
				}
	    		viewShow.setVisible(true);
	    		viewHide.setVisible(false);
	    		managementApp.saveActivities();
	    		
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

