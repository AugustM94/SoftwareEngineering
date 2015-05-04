package soen.management.app;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private ManagementApp managementApp = new ManagementApp();
	JPanel leftPanel = new JPanel();
	JPanel middlePanel = new JPanel();
	JPanel rightPanel = new JPanel();

	GUI(){
	    super("Project Management"); 
	    
	    setBounds(200,200,600,400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(null);
	    Container con = this.getContentPane(); 
	    
	    setLeftPanel();
	    setMiddlePanel();
	    setRightPanel();
	    
	    con.add(leftPanel); 
	    con.add(middlePanel);
	    con.add(rightPanel);
	    
	    
	
	    setVisible(true); // make frame visible
	}
	
	public void setLeftPanel(){
		JLabel userHeader = new JLabel("Select a user");
		
		ArrayList<User> users = managementApp.getUserArray();
		JLabel[] userLabels = new JLabel[users.size()];
		
		leftPanel.setBackground(new Color(0xb2b2b2));
		leftPanel.setSize(200, 400);
		leftPanel.setLocation(0, 0);
		leftPanel.setLayout(null);
		
		userHeader.setSize(200,50);
		userHeader.setLocation(0, 0);
		userHeader.setHorizontalAlignment(SwingConstants.CENTER);
		userHeader.setOpaque(true);
		
		for (int i = 0; i < users.size(); i++){
			userLabels[i] = new JLabel(users.get(i).getName());
			userLabels[i].setSize(190,50);
			userLabels[i].setLocation(5, (i+1)*55);
			userLabels[i].setBackground(new Color(0xEFEFEF));
			userLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			userLabels[i].setOpaque(true);
			userLabels[i].addMouseListener(new CustomMouseListener(users.get(i)));
			
			leftPanel.add(userLabels[i]);
		}
		
	    leftPanel.add(userHeader); 
	}
	
	public void setMiddlePanel(){
		middlePanel.setBackground(new Color(0xEFEFEF));
		middlePanel.setSize(200, 400);
		middlePanel.setLocation(200, 0);
		middlePanel.setLayout(null);
		
	}
	
	public void setRightPanel(){
		rightPanel.setBackground(new Color(0xEFEFEF));
		rightPanel.setSize(200, 400);
		rightPanel.setLocation(400, 0);
		rightPanel.setLayout(null);
		
	}
}

class CustomMouseListener implements MouseListener{
	private ManagementApp managementApp = new ManagementApp();
	User user;
	
	CustomMouseListener(User user){
		this.user = user;
	}
    public void mouseClicked(MouseEvent e) {
    	if (managementApp.getSessionUser() == 0){
    		managementApp.setSessionUser(user.getUserID());
    	}
    	else{
    		System.out.println("session user already set");
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