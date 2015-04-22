package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.border.*;

import dao.*;
import model.*;

public class User_View implements ActionListener {
	String space = "                                                                                                     ";
	JFrame baseFrame = new JFrame("KALS - User");
	JPanel basePanel = new JPanel();
	JPanel listPanel = new JPanel();
	JLabel kalsLabel = new JLabel("Welcome to KALS, ");
	JLabel userLabel = new JLabel("your life sucks"); 
	JLabel headLabel = new JLabel(
				     "  ISBN/ISAN                      "
				  + "|  TITLE" + space
			      + "|  AUTHOR          "
				  + "|  QUANTITY  "
			      + "|  SECTION  ");
	JLabel ISBNLabel = new JLabel();
	JLabel titleLabel= new JLabel();
	JLabel authorLabel= new JLabel();
	JLabel quantityLabel = new JLabel();
	JLabel sectionLabel = new JLabel();
	JMenuBar menuBar = new JMenuBar();
	JMenu userMenu = new JMenu("KALS");
	JMenu helpMenu = new JMenu("Help");
	JMenuItem accountItem = new JMenuItem("Account", new ImageIcon("account.png"));
	JMenuItem exitItem = new JMenuItem("Exit", new ImageIcon("exit.png"));
	JMenuItem aboutItem = new JMenuItem("About", new ImageIcon("about.png"));
	JMenuItem finesItem = new JMenuItem("Fines", new ImageIcon("fines.png"));
	JComboBox<String> searchCombo = new JComboBox<String>();
	JTextField searchField = new JTextField();
	JButton searchButton = new JButton("Search");	
	JButton checkButton = new JButton();
	Connection conn = null;
	Border black = BorderFactory.createLineBorder(Color.black, 1);
	
	public User_View(Connection incon)
	{
		conn = incon;
		
		//listeners
		accountItem.addActionListener(this);
		finesItem.addActionListener(this);
		exitItem.addActionListener(this);
		aboutItem.addActionListener(this);
		searchButton.addActionListener(this);
		searchCombo.addActionListener(this);
		
		//menu
		userMenu.add(accountItem);
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
		basePanel.add(kalsLabel);
		basePanel.add(userLabel);
		basePanel.add(searchCombo);
		basePanel.add(searchButton);
		basePanel.add(searchField);
		basePanel.add(listPanel);
		
		//labels
		kalsLabel.setBounds(280, 100, 275, 50);
		kalsLabel.setFont(new Font("Arial", Font.BOLD, 30));
		userLabel.setBounds(560, 100, 200, 50);
		userLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		//combo box
		searchCombo.setBounds(250, 160, 100, 40);
		searchCombo.addItem("ISBN");
		searchCombo.addItem("ISAN");
		searchCombo.addItem("Title");
		
		//field
		searchField.setBounds(350, 160, 280, 41);
		
		//button
		searchButton.setBounds(630, 160, 100, 40);
		
//--------------------------------------------------------------------//		
		// LIST PANEL SETTINGS
		listPanel.setLayout(null);
		listPanel.setBounds(100, 220, 800, 200);
		listPanel.setBorder(black);
		listPanel.add(headLabel);
		listPanel.add(ISBNLabel);
		listPanel.add(titleLabel);
		listPanel.add(authorLabel);
		listPanel.add(quantityLabel);
		listPanel.add(sectionLabel);
		listPanel.add(checkButton);
		
		//labels
		headLabel.setBorder(black);
		headLabel.setBounds(50, 10, 700, 25);
		ISBNLabel.setBounds(50, 40, 100, 25);
		titleLabel.setBounds(180, 40, 320, 25);
		authorLabel.setBounds(520, 40, 90, 25);
		quantityLabel.setBounds(640, 40, 30, 25);
		sectionLabel.setBounds(700, 40, 40, 25);
		
		
		//buttons
		checkButton.setBounds(760, 40, 25, 25);
		checkButton.setIcon(new ImageIcon("check.png"));
		checkButton.setVisible(false);
	}
	
	public void clearFields()
	{
		titleLabel.setText("The Media You Requested Cannot Be Found");
		ISBNLabel.setText("");
		authorLabel.setText("");
		quantityLabel.setText("");
		sectionLabel.setText("");
		checkButton.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		 Object Click_Source = e.getSource();
			if (Click_Source == searchButton) {
		 		String item = (String)searchCombo.getSelectedItem();
				if(item == "ISBN")
				{
					try
					{
						Book_DAO bDAO = new Book_DAO(conn);
						if(bDAO.ISBNcheck(searchField.getText()))
						{
							try
							{
								Books b = new Books();
								b = bDAO.getBookbyISBN(searchField.getText());
								ISBNLabel.setText(b.getISBN());
								titleLabel.setText(b.getTitle());
								authorLabel.setText(b.getAuthor());
								quantityLabel.setText(Integer.toString(b.getQuantity()));
								sectionLabel.setText(b.getSection());
								checkButton.setVisible(true);
							}
							catch(Exception c)
							{
								System.out.println("Error" + c.getMessage());
							}
						}
						else
						{	
							clearFields();
						}
					}
					catch(Exception c)
					{
						System.out.println("Error" + c.getMessage());
					}
				}
				if(item == "ISAN")
				{
					try
					{
						Video_DAO vDAO = new Video_DAO(conn);
						if(vDAO.ISANcheck(searchField.getText()))
						{
							try
							{
								Videos v = new Videos();
								v = vDAO.getVideobyISAN(searchField.getText());
								ISBNLabel.setText(v.getISAN());
								titleLabel.setText(v.getTitle());
								authorLabel.setText(v.getProducer());
								quantityLabel.setText(Integer.toString(v.getQuantity()));
								sectionLabel.setText(v.getSection());
								checkButton.setVisible(true);
							}
							catch(Exception c)
							{
								System.out.println("Error" + c.getMessage());
							}
						}
						else
						{	
							clearFields();
						}
					}
					catch(Exception c)
					{
						System.out.println("Error" + c.getMessage());
					}
				}
				if(item == "Title")
				{
					try
					{
						Book_DAO bDAO = new Book_DAO(conn);
						Video_DAO vDAO = new Video_DAO(conn);
						boolean booktitle = bDAO.titlecheck(searchField.getText());
						boolean videotitle = vDAO.titlecheck(searchField.getText());
						
						if(booktitle)
						{
							try
							{
								Books b = new Books();
								b = bDAO.getBookbyTitle(searchField.getText());
								ISBNLabel.setText(b.getISBN());
								titleLabel.setText(b.getTitle());
								authorLabel.setText(b.getAuthor());
								quantityLabel.setText(Integer.toString(b.getQuantity()));
								sectionLabel.setText(b.getSection());
								checkButton.setVisible(true);
							}
							catch(Exception c)
							{
								System.out.println("Error" + c.getMessage());
							}
						}
						else if(videotitle)
						{
							try
							{
								Videos v = new Videos();
								v = vDAO.getVideobyTitle(searchField.getText());
								ISBNLabel.setText(v.getISAN());
								titleLabel.setText(v.getTitle());
								authorLabel.setText(v.getProducer());
								quantityLabel.setText(Integer.toString(v.getQuantity()));
								sectionLabel.setText(v.getSection());
								checkButton.setVisible(true);
							}
							catch(Exception c)
							{
								System.out.println("Error" + c.getMessage());
							}
						}
						else
						{	
							clearFields();
						}
					}
					catch(Exception c)
					{
						System.out.println("Error" + c.getMessage());
					}
				}
		 		
			}
		 	if (Click_Source == exitItem)
		 	{
		 		baseFrame.dispose();
		 		new Login(conn);
		 	}
		 	
	}
}
