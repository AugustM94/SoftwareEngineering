package soen.management.app;

import java.awt.CardLayout;
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
	
	
	GUI(){
	    super("Project Management"); 
	    
	    setBounds(200,200,600,400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(null);
	    Container con = this.getContentPane(); 
	    setpanelCont();
	    setpanelCont2();
	    
	    con.add(panelCont);
	    con.add(panelCont2);
	    
	    setVisible(true); // make frame visible
	}
	
	public void setpanelCont(){
		
		panelCont.setBackground(new Color(0xb2b2b2));
		panelCont.setSize(600, 400);
		panelCont.setLocation(0, 0);
		panelCont.setLayout(null);
		panelCont.setVisible(true);
		
		JLabel userHeader = new JLabel("Select a user");
		
		userHeader.setSize(200,50);
		userHeader.setLocation(0,0);
		userHeader.setHorizontalAlignment(SwingConstants.CENTER);
		userHeader.setOpaque(true);
		
		ArrayList<User> users = managementApp.getUserArray();
		JLabel[] userLabels = new JLabel[users.size()];
		
		for (int i = 0; i < users.size(); i++){
			userLabels[i] = new JLabel(users.get(i).getName());
			userLabels[i].setSize(190,50);
			userLabels[i].setLocation(5, (i+2)*55);
			userLabels[i].setBackground(new Color(0xEFEFEF));
			userLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			userLabels[i].setOpaque(true);
			userLabels[i].addMouseListener(new CustomMouseListener(panelCont2, panelCont, users.get(i)));
			panelCont.add(userLabels[i]);
		}
		
	    panelCont.add(userHeader);

	}
	
	
	public void setpanelCont2(){
		
		panelCont2.setBackground(new Color(0xb2b2b2));
		panelCont2.setSize(600, 400);
		panelCont2.setLocation(0, 0);
		panelCont2.setLayout(null);
		panelCont2.setVisible(false);
		
		JLabel backButton = new JLabel("Back");
		
		backButton.setSize(100,25);
		backButton.setBackground(new Color(0xffffff));
		backButton.setLocation(0, 0);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setOpaque(true);
		backButton.addMouseListener(new CustomMouseListener(panelCont, panelCont2));
		
		panelCont2.add(backButton);
		
		JLabel projectHeader = new JLabel("Select a project");
		
		projectHeader.setSize(500,25);
		projectHeader.setLocation(100,0);
		projectHeader.setHorizontalAlignment(SwingConstants.CENTER);
		projectHeader.setOpaque(true);
		
		ArrayList<Project> projects = managementApp.getProjectArray();
		JLabel[] projectLabels = new JLabel[projects.size()];
		
		for (int i = 0; i < projects.size(); i++){
			projectLabels[i] = new JLabel(projects.get(i).getName());
			projectLabels[i].setSize(100,30);
			projectLabels[i].setLocation(5, (i+1)*35);
			projectLabels[i].setBackground(new Color(0xEFEFEF));
			projectLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			projectLabels[i].setOpaque(true);
			projectLabels[i].addMouseListener(new CustomMouseListener(projects.get(i)));
			
			panelCont2.add(projectLabels[i]);
		}
		
	    panelCont2.add(projectHeader);
	}
}

class CustomMouseListener implements MouseListener{
	private ManagementApp managementApp = new ManagementApp();
	User user;
	Project project;
	JPanel viewShow;
	JPanel viewHide;
	static JPanel lastView;
	
	CustomMouseListener(){
		
	}
	CustomMouseListener(JPanel viewShow, JPanel viewHide){
		this.viewShow=viewShow;
		this.viewHide=viewHide;
		
	}
	
	CustomMouseListener(JPanel viewShow, JPanel viewHide, User user){
		this.user = user;
		this.viewShow=viewShow;
		this.viewHide=viewHide;
	}
	CustomMouseListener(Project project){
		this.project = project;
	}
    public void mouseClicked(MouseEvent e) {
<<<<<<< HEAD
    	if (user != null){
    		managementApp.setSessionUser(user.getUserID());
    	}
       		viewShow.setVisible(true);
    		viewHide.setVisible(false);
    	
    	
=======
    	managementApp.logInUser(user.getUserID());
    	System.out.println(managementApp.getSessionUser());
>>>>>>> origin/master
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
