package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Account implements ActionListener{
	String space = "                                                                                            ";
	JFrame baseFrame = new JFrame("KALS - Account");
	JPanel basePanel = new JPanel();
	JPanel listPanel = new JPanel();
	JLabel headingLabel = new JLabel("Account Summary");
	JLabel checkLabel = new JLabel("Items Currently Checked Out: ");
	JLabel headLabel = new JLabel("  ISBN/ISAN            | TITLE " + space
								+"| DUE DATE      ");
	JLabel ISBNLabel = new JLabel("ISBN/ISAN");
	JLabel titleLabel= new JLabel("Title");
	JLabel dueLabel= new JLabel("Due Date");
	JMenuBar menuBar = new JMenuBar();
	JMenu userMenu = new JMenu("KALS");
	JMenu helpMenu = new JMenu("Help");
	JMenuItem searchItem = new JMenuItem("Search", new ImageIcon("account.png"));
	JMenuItem exitItem = new JMenuItem("Log Out", new ImageIcon("exit.png"));
	JMenuItem aboutItem = new JMenuItem("About", new ImageIcon("about.png"));
	JMenuItem finesItem = new JMenuItem("Fines", new ImageIcon("fines.png"));

	Connection conn = null;
	Border black = BorderFactory.createLineBorder(Color.black, 1);
	
	
	public Account(Connection incon)
	{
		conn = incon;
		
		userMenu.add(searchItem);
		userMenu.add(finesItem);
		userMenu.add(exitItem);
		helpMenu.add(aboutItem);
		
		//menu Bar
		menuBar.add(userMenu);
		menuBar.add(helpMenu);
		
		//frame
		baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		baseFrame.setSize(1000, 500);
		baseFrame.setVisible(true);
		baseFrame.setResizable(false);
		baseFrame.setJMenuBar(menuBar);
		baseFrame.add(basePanel);
//--------------------------------------------------------------------//	
		
		//BASE PANEL SETTINGS
		basePanel.setLayout(null);
		basePanel.add(headingLabel);
		basePanel.add(checkLabel);
		basePanel.add(listPanel);
		
		//labels
		headingLabel.setBounds(368, 50, 265, 50);
		headingLabel.setFont(new Font("Arial", Font.BOLD, 30));
//		headingLabel.setBorder(black);
		
		checkLabel.setBounds(50, 120, 200, 25);
//		checkLabel.setBorder(black);
//--------------------------------------------------------------------//	
		//LIST PANEL SETTINGS
		listPanel.setLayout(null);
		listPanel.setBounds(50, 150, 500, 270);
		listPanel.setBorder(black);
		listPanel.add(headLabel);
		listPanel.add(ISBNLabel);
		listPanel.add(titleLabel);
		listPanel.add(dueLabel);
		
		//labels
		headLabel.setBounds(0, 0, 500, 25);
		headLabel.setBorder(black);
		ISBNLabel.setBounds(5, 25, 95, 25);
//		ISBNLabel.setBorder(black);
		titleLabel.setBounds(100, 25, 320, 25);
//		titleLabel.setBorder(black);
		dueLabel.setBounds(420, 25, 80, 25);
//		dueLabel.setBorder(black);

	}
	
	public void actionPerformed(ActionEvent e) 
	{
		 Object Click_Source = e.getSource();
	}
}	
