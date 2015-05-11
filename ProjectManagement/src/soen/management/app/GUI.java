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
	JPanel Project = new JPanel();
	JPanel Activity = new JPanel();

	JPanel addActivityP = new JPanel();
	JPanel addprojectLeader = new JPanel();
	
	static Project currentProject = null;
	
	JPanel editActivityP = new JPanel();

	JTextField projectProjectName = new JTextField(20);
	JTextField projectStartDate = new JTextField(20);
	JTextField projectEndDate = new JTextField(20);
	JTextField projectProjectLeaderID = new JTextField(20);
	JTextField projectProjectType = new JTextField(20);
	JCheckBox projectActive = new JCheckBox("");
	JLabel projectSubmit = new JLabel("Submit");
	
	CustomMouseListener customMouseListener = null;
	
	

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
	    setaddActivityP();
	    //seteditActivityP();

	    con.add(chooseUser);
	    con.add(Project);
	    con.add(Activity);
	    con.add(addActivityP);
	    con.add(addprojectLeader);
	    con.add(editActivityP);

	    
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
		}
		
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
		
		
		JLabel submit = new JLabel("Submit");
		submit.setSize(100,30);
		submit.setLocation(460,270);
		submit.setBackground(new Color(0x0e2f44));
		submit.setForeground(new Color(0xe5e5ff));
		submit.setHorizontalAlignment(SwingConstants.CENTER);
		submit.setOpaque(true);
		customMouseListener = new CustomMouseListener();
		submit.addMouseListener(customMouseListener);
		Project.add(submit);

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
		
		JLabel activityNameLabel = new JLabel("Activity Name:");
		activityNameLabel.setSize(100,30);
		activityNameLabel.setLocation(30,70);
		activityNameLabel.setBackground(new Color(0xe5e5e5));
		activityNameLabel.setOpaque(true);
		addActivityP.add(activityNameLabel);
		
		JTextField activityName = new JTextField(20);
		activityName.setSize(150,30);
		activityName.setLocation(150,70);
		activityName.setOpaque(true);
		addActivityP.add(activityName);
		
		JLabel startDateLabel = new JLabel("Start Date:");
		startDateLabel.setSize(100,30);
		startDateLabel.setLocation(30,110);
		startDateLabel.setBackground(new Color(0xe5e5e5));
		startDateLabel.setOpaque(true);
		addActivityP.add(startDateLabel);
		
		JTextField startDate = new JTextField(20);
		startDate.setSize(150,30);
		startDate.setLocation(150,110);
		startDate.setOpaque(true);
		addActivityP.add(startDate);
		
		JLabel endDateLabel = new JLabel("End Date:");
		endDateLabel.setSize(100,30);
		endDateLabel.setLocation(30,150);
		endDateLabel.setBackground(new Color(0xe5e5e5));
		endDateLabel.setOpaque(true);
		addActivityP.add(endDateLabel);
		
		JTextField endDate = new JTextField(20);
		endDate.setSize(150,30);
		endDate.setLocation(150,150);
		endDate.setOpaque(true);
		addActivityP.add(endDate);
		
		JLabel hoursBudgettedLabel = new JLabel("Hours Budgetted:");
		hoursBudgettedLabel.setSize(100,30);
		hoursBudgettedLabel.setLocation(30,190);
		hoursBudgettedLabel.setBackground(new Color(0xe5e5e5));
		hoursBudgettedLabel.setOpaque(true);
		addActivityP.add(hoursBudgettedLabel);
		
		JTextField hoursBudgetted = new JTextField(20);
		hoursBudgetted.setSize(150,30);
		hoursBudgetted.setLocation(150,190);
		hoursBudgetted.setOpaque(true);
		addActivityP.add(hoursBudgetted);
		
		JLabel activeLabel = new JLabel("Active:");
		activeLabel.setSize(100,30);
		activeLabel.setLocation(30,230);
		activeLabel.setBackground(new Color(0xe5e5e5));
		activeLabel.setOpaque(true);
		addActivityP.add(activeLabel);

		JCheckBox active = new JCheckBox("");
		active.setSize(150,30);
		active.setLocation(150,230);
		active.setOpaque(true);
		addActivityP.add(active);

		
		
		JLabel submitButton = new JLabel("Submit");
		submitButton.setSize(100,30);
		submitButton.setLocation(310,230);
		submitButton.setBackground(new Color(0x0e2f44));
		submitButton.setForeground(new Color(0xe5e5ff));
		submitButton.setHorizontalAlignment(SwingConstants.CENTER);
		submitButton.setOpaque(true);
		addActivityP.add(submitButton);
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
		backButton.addMouseListener(new CustomMouseListener(Activity, editActivityP));
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
		backButton.addMouseListener(new CustomMouseListener(Activity, addprojectLeader));
		addprojectLeader.add(backButton);
		
		JLabel addActivityHeader = new JLabel("Edit activity");
		addActivityHeader.setSize(600,30);
		addActivityHeader.setLocation(0,0);
		addActivityHeader.setBackground(new Color(0x0e2f44));
		addActivityHeader.setForeground(new Color(0xe5e5ff));
		addActivityHeader.setHorizontalAlignment(SwingConstants.CENTER);
		addActivityHeader.setOpaque(true);
		addprojectLeader.add(addActivityHeader);
		
	}
	
	class CustomMouseListener implements MouseListener{
		User user;
		Project project;
		Activity activity;
		JPanel viewShow;
		JPanel viewHide;
		boolean eproject;
		
		CustomMouseListener(){
			eproject = true;
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
	    	else if(eproject){
	    		if (e.getSource() == projectSubmit) {
				}
	    		Project newProject = new Project(projectProjectName.getText(), Integer.parseInt(projectProjectType.getText()));
	    		
	    		if(projectStartDate.getText().length() > 0){
	    			newProject.setStartDate(Integer.parseInt(projectStartDate.getText()));
	    		}
	    	
		    	if(projectEndDate.getText().length() > 0){
		    		newProject.setStartDate(Integer.parseInt(projectEndDate.getText()));
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
}

