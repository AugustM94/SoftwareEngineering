package soen.management.app;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.json.JSONArray;

public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private ManagementApp managementApp = new ManagementApp();
	JPanel chooseUser = new JPanel();
	JPanel Project = new JPanel();
	JPanel Activity = new JPanel();
	JPanel addActivityP = new JPanel();
	JPanel addprojectLeader = new JPanel();
	JPanel editActivityP = new JPanel();
//	JPanel ListofEmployees = new JPanel();
//	JPanel deleteActivity = new JPanel();
//	JPanel editName = new JPanel();
//	JPanel duration = new JPanel();
//	JPanel workingHours = new JPanel();
	
	static Project currentProject = null;
	
	GUI(){
	    super("Project Management"); 
	    
	    setBounds(200,200,600,400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(null);
	    Container con = this.getContentPane(); 
	    setchooseUser();
	    setProject();
	    setActivity();
	    setaddActivityP();
	    setaddprojectLeader();
	    seteditActivityP();
//	    setListofEmployees();
//	    setdeleteActivity();
//	    seteditName();
//	    setduration();
//	    setworkingHours();
	    
	    con.add(chooseUser);
	    con.add(Project);
	    con.add(Activity);
	    con.add(addActivityP);
	    con.add(addprojectLeader);
	    con.add(editActivityP);
//	    con.add(ListofEmployees);
//	    con.add(deleteActivity);
//	    con.add(editName);
//	    con.add(duration);
//	    con.add(workingHours);
	    
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
			
		
		
		JLabel textarea = new JLabel("Add Project:");
		textarea.setFont(new Font("serif",Font.BOLD, 20));
		textarea.setSize(200,30);
		textarea.setLocation(180,40);
		textarea.setBackground(new Color(0xe5e5e5));
		textarea.setOpaque(true);
		Project.add(textarea);
		
		JLabel projectNameLabel = new JLabel("Project Name:");
		projectNameLabel.setSize(100,30);
		projectNameLabel.setLocation(180,70);
		projectNameLabel.setBackground(new Color(0xe5e5e5));
		projectNameLabel.setOpaque(true);
		Project.add(projectNameLabel);
		
		JTextField projectName = new JTextField(20);
		projectName.setSize(150,30);
		projectName.setLocation(290,70);
		projectName.setOpaque(true);
		Project.add(projectName);
		
		JLabel startDateLabel = new JLabel("Start Date:");
		startDateLabel.setSize(100,30);
		startDateLabel.setLocation(180,110);
		startDateLabel.setBackground(new Color(0xe5e5e5));
		startDateLabel.setOpaque(true);
		Project.add(startDateLabel);
		
		JTextField startDate = new JTextField(20);
		startDate.setSize(150,30);
		startDate.setLocation(290,110);
		startDate.setOpaque(true);
		startDate.setText(" ");
		Project.add(startDate);
		System.out.println(startDate.getText());
		
		JLabel endDateLabel = new JLabel("End Date:");
		endDateLabel.setSize(100,30);
		endDateLabel.setLocation(180,150);
		endDateLabel.setBackground(new Color(0xe5e5e5));
		endDateLabel.setOpaque(true);
		Project.add(endDateLabel);
		
		JTextField endDate = new JTextField(20);
		endDate.setSize(150,30);
		endDate.setLocation(290,150);
		endDate.setOpaque(true);
		Project.add(endDate);
		
		JLabel projectLeaderIDLabel = new JLabel("ProjectLeaderID:");
		projectLeaderIDLabel.setSize(100,30);
		projectLeaderIDLabel.setLocation(180,190);
		projectLeaderIDLabel.setBackground(new Color(0xe5e5e5));
		projectLeaderIDLabel.setOpaque(true);
		Project.add(projectLeaderIDLabel);
		
		JTextField projectLeaderID = new JTextField(20);
		projectLeaderID.setSize(150,30);
		projectLeaderID.setLocation(290,190);
		projectLeaderID.setOpaque(true);
		Project.add(projectLeaderID);
		
		JLabel projectTypeLabel = new JLabel("Project Type:");
		projectTypeLabel.setSize(100,30);
		projectTypeLabel.setLocation(180,230);
		projectTypeLabel.setBackground(new Color(0xe5e5e5));
		projectTypeLabel.setOpaque(true);
		Project.add(projectTypeLabel);
		
		JTextField projectType = new JTextField(20);
		projectType.setSize(150,30);
		projectType.setLocation(290,230);
		projectType.setOpaque(true);
		Project.add(projectType);
		
//		JLabel timeStamp = new JLabel("Timestamp:");
//		timeStamp.setSize(100,30);
//		timeStamp.setLocation(180,270);
//		timeStamp.setBackground(new Color(0xe5e5e5));
//		timeStamp.setOpaque(true);
//		Project.add(timeStamp);
//		
//		JTextField TimeStamp = new JTextField(20);
//		TimeStamp.setSize(150,30);
//		TimeStamp.setLocation(290,270);
//		TimeStamp.setOpaque(true);
//		Project.add(TimeStamp);
		
		JLabel activeLabel = new JLabel("Active:");
		activeLabel.setSize(100,30);
		activeLabel.setLocation(180,310);
		activeLabel.setBackground(new Color(0xe5e5e5));
		activeLabel.setOpaque(true);
		Project.add(activeLabel);

		JCheckBox active = new JCheckBox("Hej");
		active.setSize(150,30);
		active.setLocation(290,310);
		active.setOpaque(true);
		Project.add(active);
		
		JLabel submit = new JLabel("Submit");
		submit.setSize(100,30);
		submit.setLocation(460,310);
		submit.setBackground(new Color(0x0e2f44));
		submit.setForeground(new Color(0xe5e5ff));
		submit.setHorizontalAlignment(SwingConstants.CENTER);
		submit.setOpaque(true);
		submit.addMouseListener(new CustomMouseListener(projectName.getText(),startDate.getText(),endDate.getText(),projectLeaderID.getText(),projectType.getText(), active.isSelected()));
		Project.add(submit);
		
		}    
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
		addActivity.addMouseListener(new CustomMouseListener(addActivityP, Activity));
		Activity.add(addActivity);
		
		JLabel addProjectLeader = new JLabel("Add Project leader");
		addProjectLeader.setSize(140,35);
		addProjectLeader.setLocation(15,240);
		addProjectLeader.setBackground(new Color(0x0e2f44));
		addProjectLeader.setForeground(new Color(0xe5e5ff));
		addProjectLeader.setHorizontalAlignment(SwingConstants.CENTER);
		addProjectLeader.setOpaque(true);
		addProjectLeader.addMouseListener(new CustomMouseListener(addprojectLeader, Activity));
		Activity.add(addProjectLeader);
		
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
		backButton.addMouseListener(new CustomMouseListener(Activity, addActivityP));
		addActivityP.add(backButton);
		
		JLabel addActivityHeader = new JLabel("Add Activity to Project");
		addActivityHeader.setSize(600,30);
		addActivityHeader.setLocation(0,0);
		addActivityHeader.setBackground(new Color(0x0e2f44));
		addActivityHeader.setForeground(new Color(0xe5e5ff));
		addActivityHeader.setHorizontalAlignment(SwingConstants.CENTER);
		addActivityHeader.setOpaque(true);
		addActivityP.add(addActivityHeader);
		
		JLabel projectName = new JLabel("Activity Name:");
		projectName.setSize(100,30);
		projectName.setLocation(30,70);
		projectName.setBackground(new Color(0xe5e5e5));
		projectName.setOpaque(true);
		addActivityP.add(projectName);
		
		JTextField ProjectName = new JTextField(20);
		ProjectName.setSize(150,30);
		ProjectName.setLocation(150,70);
		ProjectName.setOpaque(true);
		addActivityP.add(ProjectName);
		
		JLabel startDate = new JLabel("Start Date:");
		startDate.setSize(100,30);
		startDate.setLocation(30,110);
		startDate.setBackground(new Color(0xe5e5e5));
		startDate.setOpaque(true);
		addActivityP.add(startDate);
		
		JTextField StartDate = new JTextField(20);
		StartDate.setSize(150,30);
		StartDate.setLocation(150,110);
		StartDate.setOpaque(true);
		addActivityP.add(StartDate);
		
		JLabel endDate = new JLabel("End Date:");
		endDate.setSize(100,30);
		endDate.setLocation(30,150);
		endDate.setBackground(new Color(0xe5e5e5));
		endDate.setOpaque(true);
		addActivityP.add(endDate);
		
		JTextField EndDate = new JTextField(20);
		EndDate.setSize(150,30);
		EndDate.setLocation(150,150);
		EndDate.setOpaque(true);
		addActivityP.add(EndDate);
		
		JLabel hoursBudgetted = new JLabel("Hours Budgetted:");
		hoursBudgetted.setSize(100,30);
		hoursBudgetted.setLocation(30,190);
		hoursBudgetted.setBackground(new Color(0xe5e5e5));
		hoursBudgetted.setOpaque(true);
		addActivityP.add(hoursBudgetted);
		
		JTextField HoursBudgetted = new JTextField(20);
		HoursBudgetted.setSize(150,30);
		HoursBudgetted.setLocation(150,190);
		HoursBudgetted.setOpaque(true);
		addActivityP.add(HoursBudgetted);
		
		JLabel timeStamp = new JLabel("Timestamp:");
		timeStamp.setSize(100,30);
		timeStamp.setLocation(30,230);
		timeStamp.setBackground(new Color(0xe5e5e5));
		timeStamp.setOpaque(true);
		addActivityP.add(timeStamp);
		
		JTextField TimeStamp = new JTextField(20);
		TimeStamp.setSize(150,30);
		TimeStamp.setLocation(150,230);
		TimeStamp.setOpaque(true);
		addActivityP.add(TimeStamp);
		
		JLabel active = new JLabel("Active:");
		active.setSize(100,30);
		active.setLocation(30,270);
		active.setBackground(new Color(0xe5e5e5));
		active.setOpaque(true);
		addActivityP.add(active);

		JTextField Active = new JTextField(20);
		Active.setSize(150,30);
		Active.setLocation(150,270);
		Active.setOpaque(true);
		addActivityP.add(Active);
		
		JLabel Submit = new JLabel("Submit");
		Submit.setSize(100,30);
		Submit.setLocation(310,270);
		Submit.setBackground(new Color(0x0e2f44));
		Submit.setForeground(new Color(0xe5e5ff));
		Submit.setHorizontalAlignment(SwingConstants.CENTER);
		Submit.setOpaque(true);
		addActivityP.add(Submit);
		
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
		backButton.addMouseListener(new CustomMouseListener(Activity, addprojectLeader));
		addprojectLeader.add(backButton);
		
		JLabel addprojectLeaderHeader = new JLabel("Add Project Leader");
		addprojectLeaderHeader.setSize(600,30);
		addprojectLeaderHeader.setLocation(0,0);
		addprojectLeaderHeader.setBackground(new Color(0x0e2f44));
		addprojectLeaderHeader.setForeground(new Color(0xe5e5ff));
		addprojectLeaderHeader.setHorizontalAlignment(SwingConstants.CENTER);
		addprojectLeaderHeader.setOpaque(true);
		addprojectLeader.add(addprojectLeaderHeader);
		
		JLabel[] userLabels = new JLabel[users.size()];
		for (int i = 0; i < users.size(); i++){
			userLabels[i] = new JLabel(users.get(i).getName());
			userLabels[i].setSize(140,35);
			userLabels[i].setLocation(15, (i+1)*40);
			userLabels[i].setBackground(new Color(0x8697a1));
			userLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			userLabels[i].setOpaque(true);
			//userLabels[i].addMouseListener(new CustomMouseListener(Project, chooseUser, users.get(i)));
			addprojectLeader.add(userLabels[i]);
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
		
		JLabel currentWorkingHours = new JLabel("Current Working Hours:");
		currentWorkingHours.setSize(180,30);
		currentWorkingHours.setLocation(30,50);
		currentWorkingHours.setBackground(new Color(0xe5e5e5));
		currentWorkingHours.setOpaque(true);
		editActivityP.add(currentWorkingHours);
		
		JTextArea CurrentWorkingHours = new JTextArea();
		CurrentWorkingHours.setSize(180,30);
		CurrentWorkingHours.setLocation(70,50);
		CurrentWorkingHours.setBackground(new Color(0xe5e5e5));
		CurrentWorkingHours.setOpaque(true);
		
		JLabel hoursBudgetted = new JLabel("Hours Budgetted:");
		hoursBudgetted.setSize(180,30);
		hoursBudgetted.setLocation(30,90);
		hoursBudgetted.setBackground(new Color(0xe5e5e5));
		hoursBudgetted.setOpaque(true);
		editActivityP.add(hoursBudgetted);
		
		JTextArea HoursBudgetted = new JTextArea();
		HoursBudgetted.setSize(180,30);
		HoursBudgetted.setLocation(70,90);
		HoursBudgetted.setBackground(new Color(0xe5e5e5));
		HoursBudgetted.setOpaque(true);
		String st = managementApp.printProjectSummary(0);
		HoursBudgetted.setText(st);
		
		JTextField EditWorkingHours = new JTextField(20);
		EditWorkingHours.setSize(150,30);
		EditWorkingHours.setLocation(30,160);
		EditWorkingHours.setOpaque(true);
		editActivityP.add(EditWorkingHours);
		
		JLabel editWorkingHours = new JLabel("Edit Working Hours:");
		editWorkingHours.setSize(180,30);
		editWorkingHours.setLocation(30,130);
		editWorkingHours.setBackground(new Color(0xe5e5e5));
		editWorkingHours.setOpaque(true);
		editActivityP.add(editWorkingHours);
		
		
		
//		JLabel ListofEmployeesp = new JLabel("List of Employees");
//		ListofEmployeesp.setSize(140,35);
//		ListofEmployeesp.setBackground(new Color(0x0e2f44));
//		ListofEmployeesp.setForeground(new Color(0xe5e5ff));
//		ListofEmployeesp.setLocation(15, 40);
//		ListofEmployeesp.setHorizontalAlignment(SwingConstants.CENTER);
//		ListofEmployeesp.setOpaque(true);
//		ListofEmployeesp.addMouseListener(new CustomMouseListener(ListofEmployees, editActivityP));
//		editActivityP.add(ListofEmployeesp);
//		
//		JLabel deleteActivityL = new JLabel("Delete activity");
//		deleteActivityL.setSize(140,35);
//		deleteActivityL.setBackground(new Color(0x0e2f44));
//		deleteActivityL.setForeground(new Color(0xe5e5ff));
//		deleteActivityL.setLocation(15, 80);
//		deleteActivityL.setHorizontalAlignment(SwingConstants.CENTER);
//		deleteActivityL.setOpaque(true);
//		deleteActivityL.addMouseListener(new CustomMouseListener(deleteActivity, editActivityP));
//		editActivityP.add(deleteActivityL);
//		
//		JLabel editNameL = new JLabel("Edit name");
//		editNameL.setSize(140,35);
//		editNameL.setBackground(new Color(0x0e2f44));
//		editNameL.setForeground(new Color(0xe5e5ff));
//		editNameL.setLocation(15, 120);
//		editNameL.setHorizontalAlignment(SwingConstants.CENTER);
//		editNameL.setOpaque(true);
//		editNameL.addMouseListener(new CustomMouseListener(editName, editActivityP));
//		editActivityP.add(editNameL);
//		
//		JLabel DurationL = new JLabel("Duration");
//		DurationL.setSize(140,35);
//		DurationL.setBackground(new Color(0x0e2f44));
//		DurationL.setForeground(new Color(0xe5e5ff));
//		DurationL.setLocation(15, 160);
//		DurationL.setHorizontalAlignment(SwingConstants.CENTER);
//		DurationL.setOpaque(true);
//		DurationL.addMouseListener(new CustomMouseListener(duration, editActivityP));
//		editActivityP.add(DurationL);
//		
//		JLabel workingHoursL = new JLabel("Working Hours");
//		workingHoursL.setSize(140,35);
//		workingHoursL.setBackground(new Color(0x0e2f44));
//		workingHoursL.setForeground(new Color(0xe5e5ff));
//		workingHoursL.setLocation(15, 200);
//		workingHoursL.setHorizontalAlignment(SwingConstants.CENTER);
//		workingHoursL.setOpaque(true);
//		workingHoursL.addMouseListener(new CustomMouseListener(workingHours, editActivityP));
//		editActivityP.add(workingHoursL);
//		
//	}
//	public void setListofEmployees(){
//		
//		ListofEmployees.setBackground(new Color(0xe5e5e5));
//		ListofEmployees.setSize(600, 400);
//		ListofEmployees.setLocation(0, 0);
//		ListofEmployees.setLayout(null);
//		ListofEmployees.setVisible(true);
//		
//		JLabel ListofEmployeesHeader = new JLabel("List of Employees");
//		ListofEmployeesHeader.setSize(600,30);
//		ListofEmployeesHeader.setLocation(0,0);
//		ListofEmployeesHeader.setBackground(new Color(0x0e2f44));
//		ListofEmployeesHeader.setForeground(new Color(0xe5e5ff));
//		ListofEmployeesHeader.setHorizontalAlignment(SwingConstants.CENTER);
//		ListofEmployeesHeader.setOpaque(true);
//		ListofEmployees.add(ListofEmployeesHeader);
//		
//		JLabel backButton = new JLabel("Back");
//		backButton.setSize(100,24);
//		backButton.setBackground(new Color(0x0e2f44));
//		backButton.setForeground(new Color(0xe5e5ff));
//		backButton.setLocation(15, 3);
//		backButton.setHorizontalAlignment(SwingConstants.CENTER);
//		backButton.setOpaque(true);
//		backButton.addMouseListener(new CustomMouseListener(editActivityP, ListofEmployees));
//		ListofEmployees.add(backButton);
//		
//	}
//	public void setdeleteActivity(){
//		
//		deleteActivity.setBackground(new Color(0xe5e5e5));
//		deleteActivity.setSize(600, 400);
//		deleteActivity.setLocation(0, 0);
//		deleteActivity.setLayout(null);
//		deleteActivity.setVisible(true);
//		
//		JLabel deleteActivityHeader = new JLabel("Delete Activity");
//		deleteActivityHeader.setSize(600,30);
//		deleteActivityHeader.setLocation(0,0);
//		deleteActivityHeader.setBackground(new Color(0x0e2f44));
//		deleteActivityHeader.setForeground(new Color(0xe5e5ff));
//		deleteActivityHeader.setHorizontalAlignment(SwingConstants.CENTER);
//		deleteActivityHeader.setOpaque(true);
//		deleteActivity.add(deleteActivityHeader);
//		
//		JLabel backButton = new JLabel("Back");
//		backButton.setSize(100,24);
//		backButton.setBackground(new Color(0x0e2f44));
//		backButton.setForeground(new Color(0xe5e5ff));
//		backButton.setLocation(15, 3);
//		backButton.setHorizontalAlignment(SwingConstants.CENTER);
//		backButton.setOpaque(true);
//		backButton.addMouseListener(new CustomMouseListener(editActivityP, deleteActivity));
//		deleteActivity.add(backButton);
//	}
//	public void seteditName(){
//		
//		editName.setBackground(new Color(0xe5e5e5));
//		editName.setSize(600, 400);
//		editName.setLocation(0, 0);
//		editName.setLayout(null);
//		editName.setVisible(true);
//		
//		JLabel editNameHeader = new JLabel("Edit name");
//		editNameHeader.setSize(600,30);
//		editNameHeader.setLocation(0,0);
//		editNameHeader.setBackground(new Color(0x0e2f44));
//		editNameHeader.setForeground(new Color(0xe5e5ff));
//		editNameHeader.setHorizontalAlignment(SwingConstants.CENTER);
//		editNameHeader.setOpaque(true);
//		editName.add(editNameHeader);
//		
//		JLabel backButton = new JLabel("Back");
//		backButton.setSize(100,24);
//		backButton.setBackground(new Color(0x0e2f44));
//		backButton.setForeground(new Color(0xe5e5ff));
//		backButton.setLocation(15, 3);
//		backButton.setHorizontalAlignment(SwingConstants.CENTER);
//		backButton.setOpaque(true);
//		backButton.addMouseListener(new CustomMouseListener(editActivityP, editName));
//		editName.add(backButton);
//	}
//	public void setduration(){
//		
//		duration.setBackground(new Color(0xe5e5e5));
//		duration.setSize(600, 400);
//		duration.setLocation(0, 0);
//		duration.setLayout(null);
//		duration.setVisible(true);
//		
//		JLabel durationHeader = new JLabel("Edit name");
//		durationHeader.setSize(600,30);
//		durationHeader.setLocation(0,0);
//		durationHeader.setBackground(new Color(0x0e2f44));
//		durationHeader.setForeground(new Color(0xe5e5ff));
//		durationHeader.setHorizontalAlignment(SwingConstants.CENTER);
//		durationHeader.setOpaque(true);
//		duration.add(durationHeader);
//		
//		JLabel backButton = new JLabel("Back");
//		backButton.setSize(100,24);
//		backButton.setBackground(new Color(0x0e2f44));
//		backButton.setForeground(new Color(0xe5e5ff));
//		backButton.setLocation(15, 3);
//		backButton.setHorizontalAlignment(SwingConstants.CENTER);
//		backButton.setOpaque(true);
//		backButton.addMouseListener(new CustomMouseListener(editActivityP, duration));
//		duration.add(backButton);
//	}
//	public void setworkingHours(){
//		
//		workingHours.setBackground(new Color(0xe5e5e5));
//		workingHours.setSize(600, 400);
//		workingHours.setLocation(0, 0);
//		workingHours.setLayout(null);
//		workingHours.setVisible(true);
//		
//		JLabel workingHoursHeader = new JLabel("Edit name");
//		workingHoursHeader.setSize(600,30);
//		workingHoursHeader.setLocation(0,0);
//		workingHoursHeader.setBackground(new Color(0x0e2f44));
//		workingHoursHeader.setForeground(new Color(0xe5e5ff));
//		workingHoursHeader.setHorizontalAlignment(SwingConstants.CENTER);
//		workingHoursHeader.setOpaque(true);
//		workingHours.add(workingHoursHeader);
//		
//		JLabel backButton = new JLabel("Back");
//		backButton.setSize(100,24);
//		backButton.setBackground(new Color(0x0e2f44));
//		backButton.setForeground(new Color(0xe5e5ff));
//		backButton.setLocation(15, 3);
//		backButton.setHorizontalAlignment(SwingConstants.CENTER);
//		backButton.setOpaque(true);
//		backButton.addMouseListener(new CustomMouseListener(editActivityP, workingHours));
//		workingHours.add(backButton);
//	}
}
class CustomMouseListener implements MouseListener{

	User user;
	Project project;
	Activity activity;
	JPanel viewShow;
	JPanel viewHide;
	boolean eproject=false;
	String projectName;
	int startDate=-1; int endDate=-1; int projectLeaderID=-1; int projectType=-1; 
	boolean active;
	String teststring = "";
	
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
	CustomMouseListener(String projectName, String startDate, String endDate, String projectLeaderID, String projectType, boolean active){
		eproject=true;
		this.projectName=projectName;
		this.teststring=startDate;
//		this.startDate=Integer.parseInt(startDate);
//		this.endDate=Integer.parseInt(endDate);
//		this.projectLeaderID=Integer.parseInt(projectLeaderID);
//		this.projectType=Integer.parseInt(projectType);
//		this.active=active;
		
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
    	else if(eproject) {
    		System.out.println(teststring);
    		Project new_project = new Project(projectName,projectType);
    		new_project.setStartDate(startDate);
    		new_project.setEndDate(endDate);
    		new_project.setProjectLeaderId(projectLeaderID);
    		new_project.setActive(active);
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
}}
