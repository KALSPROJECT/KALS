package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.border.*;

public class New_User implements ActionListener {
	JFrame baseFrame = new JFrame("KALS - REGISTER");
	JPanel basePanel = new JPanel();
	JLabel firstLabel = new JLabel("First Name");	
	JLabel lastLabel = new JLabel("Last Name");
	JLabel streetLabel = new JLabel("Street Address");
	JLabel cityLabel = new JLabel("City");
	JLabel postLabel = new JLabel("Zip Code");
	JLabel mailLabel = new JLabel("Email");
	JLabel phoneLabel = new JLabel("Phone Number");
	JLabel userLabel = new JLabel("Choose Username");
	JLabel passLabel = new JLabel("Password");
	JLabel cpassLabel = new JLabel("Confirm Password");
	JLabel termsLabel = new JLabel("Yes, I accept the Terms & Conditions " + "\n" + "and the Privacy Policy of KALS.");
	JTextField firstField = new JTextField();
	JTextField lastField = new JTextField();
	JTextField streetField = new JTextField();
	JTextField cityField = new JTextField();
	JTextField postField = new JTextField();
	JTextField phoneField = new JTextField();
	JTextField userField = new JTextField();
	JTextField passField = new JTextField();
	JTextField cpassField = new JTextField();
	JTextField mailField = new JTextField();
	JButton registerButton = new JButton("Register");
	JButton cancelButton = new JButton("Cancel");
	JCheckBox termsCheck = new JCheckBox();
	Connection conn = null;
	Border black = BorderFactory.createLineBorder(Color.black, 1);
	
	public New_User(Connection incon)
	{
		conn = incon;
		
		//listeners
		registerButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		//frame
		baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		baseFrame.setSize(1000, 500);
		baseFrame.setVisible(true);
		baseFrame.setResizable(false);
		baseFrame.add(basePanel);
		
//--------------------------------------------------------------------//	
		//BASE PANEL SETTINGS
		basePanel.setLayout(null);
		basePanel.add(firstLabel);
		basePanel.add(lastLabel);
		basePanel.add(streetLabel);
		basePanel.add(cityLabel);
		basePanel.add(postLabel);
		basePanel.add(mailLabel);
		basePanel.add(phoneLabel);
		basePanel.add(userLabel);
		basePanel.add(passLabel);
		basePanel.add(cpassLabel);
		basePanel.add(termsLabel);
		basePanel.add(firstField);
		basePanel.add(lastField);
		basePanel.add(streetField);
		basePanel.add(cityField);
		basePanel.add(postField);
		basePanel.add(phoneField);
		basePanel.add(userField);
		basePanel.add(passField);
		basePanel.add(cpassField);
		basePanel.add(mailField);
		basePanel.add(registerButton);
		basePanel.add(cancelButton);
		basePanel.add(termsLabel);
		basePanel.add(termsCheck);
		
		//labels
		firstLabel.setBounds(150, 80, 100, 25);
		lastLabel.setBounds(150, 110, 100, 25);
		streetLabel.setBounds(150, 140, 100, 25);
		cityLabel.setBounds(150, 170, 100, 25);
		postLabel.setBounds(150, 200, 100, 25);
		mailLabel.setBounds(150, 230, 100, 25);
		phoneLabel.setBounds(150, 260, 100, 25);
		userLabel.setBounds(500, 80, 110, 25);
		passLabel.setBounds(500, 110, 100, 25);
		cpassLabel.setBounds(500, 140, 110, 25);
		termsLabel.setBounds(520, 170, 390, 25);
		
		//fields
		firstField.setBounds(250, 80, 220, 25);
		lastField.setBounds(250, 110, 220, 25);
		streetField.setBounds(250, 140, 220, 25);
		cityField.setBounds(250, 170, 220, 25);
		postField.setBounds(250, 200, 220, 25);
		mailField.setBounds(250, 230, 220, 25);
		phoneField.setBounds(250, 260, 220, 25);
		userField.setBounds(630, 80, 220, 25);
		passField.setBounds(630, 110, 220, 25);
		cpassField.setBounds(630, 140, 220, 25);
		
		//check box
		termsCheck.setBounds(490, 170, 25, 25);
		
		//buttons
		registerButton.setBounds(570, 230, 100, 50);
		cancelButton.setBounds(700, 230, 100, 50);
//--------------------------------------------------------------------//	
	}	
	
	public void actionPerformed(ActionEvent e) 
	{
		Object Click_Source = e.getSource();
			if (Click_Source == cancelButton) 
			{
				baseFrame.dispose();
				new Login(conn);
			}
	}
}
