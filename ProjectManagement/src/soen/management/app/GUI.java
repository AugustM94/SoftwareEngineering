package soen.management.app;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private ManagementApp managementApp = new ManagementApp();
	JPanel panelCont = new JPanel();
	JPanel panelCont2 = new JPanel();
	JPanel panelCont3 = new JPanel();
	JPanel panelCont4 = new JPanel();
	
	static Project currentProject = null;
	
	
	GUI(){
	    super("Project Management"); 
	    
	    setBounds(200,200,600,400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(null);
	    Container con = this.getContentPane(); 
	    setpanelCont();
	    setpanelCont2();
	    setpanelCont3();
	    setpanelCont4();
	    
	    con.add(panelCont);
	    con.add(panelCont2);
	    con.add(panelCont3);
	    con.add(panelCont4);
	    
	    setVisible(true); // make frame visible
	}
	
	public void setpanelCont(){
		ArrayList<User> users = managementApp.getUserArray();
		
		panelCont.setBackground(new Color(0xb2b2b2));
		panelCont.setBackground(new Color(0xe5e5e5));
		panelCont.setSize(600, 400);
		panelCont.setLocation(0, 0);
		panelCont.setLayout(null);
		panelCont.setVisible(true);
		
		JLabel userHeader = new JLabel("Select a user");
		userHeader.setSize(600,30);
		userHeader.setLocation(0,0);
		userHeader.setBackground(new Color(0x0e2f44));
		userHeader.setForeground(new Color(0xe5e5ff));
		userHeader.setHorizontalAlignment(SwingConstants.CENTER);
		userHeader.setOpaque(true);
		panelCont.add(userHeader);
		
		
		JLabel[] userLabels = new JLabel[users.size()];
		for (int i = 0; i < users.size(); i++){
			userLabels[i] = new JLabel(users.get(i).getName());
			userLabels[i].setSize(140,35);
			userLabels[i].setLocation(15, (i+1)*40);
			userLabels[i].setBackground(new Color(0x8697a1));
			userLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			userLabels[i].setOpaque(true);
			userLabels[i].addMouseListener(new CustomMouseListener(panelCont2, panelCont, users.get(i)));
			panelCont.add(userLabels[i]);
		}
	}
	
	
	public void setpanelCont2(){
		ArrayList<Project> projects = managementApp.getProjectArray();
		
		panelCont2.setBackground(new Color(0xe5e5e5));
		panelCont2.setSize(600, 400);
		panelCont2.setLocation(0, 0);
		panelCont2.setLayout(null);
		panelCont2.setVisible(false);
		
		JButton backButton = new JButton("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener(panelCont, panelCont2));
		panelCont2.add(backButton);
		
		JLabel projectHeader = new JLabel("Select a project");
		projectHeader.setSize(600,30);
		projectHeader.setLocation(0,0);
		projectHeader.setBackground(new Color(0x0e2f44));
		projectHeader.setForeground(new Color(0xe5e5ff));
		projectHeader.setHorizontalAlignment(SwingConstants.CENTER);
		projectHeader.setOpaque(true);
		panelCont2.add(projectHeader);
		
		JLabel[] projectLabels = new JLabel[projects.size()];
		for (int i = 0; i < projects.size(); i++){
			projectLabels[i] = new JLabel(projects.get(i).getName());
			projectLabels[i].setSize(140,35);
			projectLabels[i].setLocation(15, (i+1)*40);
			projectLabels[i].setBackground(new Color(0x8697a1));
			projectLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			projectLabels[i].setOpaque(true);
			projectLabels[i].addMouseListener(new CustomMouseListener(panelCont3, panelCont2, projects.get(i)));
			
			panelCont2.add(projectLabels[i]);
		}    
	}


	public void setpanelCont3(){
		panelCont3.setBackground(new Color(0xe5e5e5));
		panelCont3.setSize(600, 400);
		panelCont3.setLocation(0, 0);
		panelCont3.setLayout(null);
		panelCont3.setVisible(false);
		
		JButton backButton = new JButton("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener(panelCont2, panelCont3));
		panelCont3.add(backButton);
		
		JLabel projectHeader = new JLabel("Select an activity");
		projectHeader.setSize(600,30);
		projectHeader.setLocation(0,0);
		projectHeader.setBackground(new Color(0x0e2f44));
		projectHeader.setForeground(new Color(0xe5e5ff));
		projectHeader.setHorizontalAlignment(SwingConstants.CENTER);
		projectHeader.setOpaque(true);
		panelCont3.add(projectHeader);
	}
	
	public void setpanelCont4(){
		ArrayList<Activity> activities = managementApp.getActivityArray();
		
		panelCont4.setBackground(new Color(0xe5e5e5));
		panelCont4.setSize(600, 400);
		panelCont4.setLocation(0, 0);
		panelCont4.setLayout(null);
		panelCont4.setVisible(false);
		
		JButton backButton = new JButton("Back");
		backButton.setSize(100,24);
		backButton.setBackground(new Color(0x0e2f44));
		backButton.setLocation(15, 3);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener(panelCont3, panelCont4));
		panelCont4.add(backButton);
		
		JLabel projectHeader = new JLabel("Manage activity");
		projectHeader.setSize(600,30);
		projectHeader.setLocation(0,0);
		projectHeader.setBackground(new Color(0x0e2f44));
		projectHeader.setForeground(new Color(0xe5e5ff));
		projectHeader.setHorizontalAlignment(SwingConstants.CENTER);
		projectHeader.setOpaque(true);
		panelCont4.add(projectHeader);	
	}
}
class CustomMouseListener implements MouseListener{
	private ManagementApp managementApp = new ManagementApp();
	User user;
	Project project;
	JPanel viewShow;
	JPanel viewHide;
	static Project selectedProject =  null;
	
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
	
    public void mouseClicked(MouseEvent e) {
    	if (user != null){
        	managementApp.logInUser(user.getUserID());
        	viewShow.setVisible(true);
    		viewHide.setVisible(false);
    	}
    	else if (project != null){
    		System.out.println(project.getName());
    		viewShow.setVisible(true);
    		viewHide.setVisible(false);
    	}
    	else{
    		viewShow.setVisible(true);
    		viewHide.setVisible(false);
    	}
    	//System.out.println(managementApp.getSessionUser());

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
