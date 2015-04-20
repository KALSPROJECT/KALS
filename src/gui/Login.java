package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import dao.Person_DAO;
import model.*;

public class Login implements ActionListener
{
	JFrame loginFrame = new JFrame("WELCOME TO KALS");
	JLabel titleLabel = new JLabel("KALS");
	JLabel nameLabel = new JLabel("USERNAME");
	JLabel passLabel = new JLabel("PASSWORD");
	JLabel adminLabel = new JLabel("Log in as Administrator");
	JButton submitButton = new JButton("SUBMIT");
	JButton registerButton = new JButton("REGISTER");
	public JTextField nameField = new JTextField();
	public JTextField passField = new JTextField();
	JPanel loginPanel = new JPanel();
	public JCheckBox adminCheck = new JCheckBox();
	Connection conn = null;
	
	public Login(Connection incon)
	{
		conn = incon;
		
		//listeners
		submitButton.addActionListener(this);
		registerButton.addActionListener(this);
		
		//frame
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setSize(1000, 500);
		loginFrame.setVisible(true);
		loginFrame.setResizable(false);
		loginFrame.add(loginPanel);
		
		//panel
		loginPanel.setLayout(null);
		loginPanel.add(titleLabel);
		loginPanel.add(nameLabel);
		loginPanel.add(passLabel);
		loginPanel.add(submitButton);
		loginPanel.add(registerButton);
		loginPanel.add(nameField);
		loginPanel.add(passField);
		loginPanel.add(adminCheck);
		loginPanel.add(adminLabel);
		
		//buttons
		submitButton.setBounds(375, 340, 100, 50);
		registerButton.setBounds(525, 340, 100, 50);
		
		//labels
		titleLabel.setBounds(370, 70, 340, 100);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 100));
		nameLabel.setBounds(275, 200, 100, 40);
		nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
		passLabel.setBounds(275, 250, 100, 40);
		passLabel.setFont(new Font("Arial", Font.BOLD, 15));
		adminLabel.setBounds(400, 300, 150, 25);
		adminLabel.setForeground(Color.RED);
		
		//fields
		nameField.setBounds(375, 200, 250, 40);
		passField.setBounds(375, 250, 250, 40);
		
		//check box
		adminCheck.setBounds(375, 300, 25, 25);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		Object Click_Source = e.getSource();
			if (Click_Source == submitButton) {
				String usertype = null;
				
				if(adminCheck.isSelected())		//set to admin if checked
					usertype = "Admin";			//set to user if not checked
				else
					usertype = "User";
				
				try
				{
					Person_DAO pDAO = new Person_DAO(conn);	//instantiate a Person_DAO
					
					//if checkUser comes back true, means a valid user
					if(pDAO.checkUser(nameField.getText(), passField.getText(), usertype))
					{
						System.out.println("Valid Credentials");
						System.out.println("Log In: Successful");
						if(usertype == "Admin")
						{	loginFrame.dispose();
							new Admin_View(conn); }
						if(usertype == "User")
						{	loginFrame.dispose();
							new User_View(conn);  }
					}
					//if not then invalid
					else
					{	
						System.out.println("Invalid Credentials");
						System.out.println("Log In: Failed");
					}
					
				}
				catch(Exception c)
				{
					System.out.println("Error" + c.getMessage());
				}
			}
			if (Click_Source == registerButton) {
			{	loginFrame.dispose();
				new New_User(conn);  }
			}
	}
	
}
