package model;

import java.sql.*;

public class DBconnect {
	private final static String driver_name = "oracle.jdbc.OracleDriver";
	private final static String url = "jdbc:oracle:thin:@localhost:1521:Group3";
	private static String user_name = "Group3";
	private static String password = "password";
	private static Connection conn = null;
	private static boolean driverloaded = false;
	private static boolean connected = false;
	
	private DBconnect(){
		return;
	}
	
	public static void load_driver()
	{	
		try
			{Class.forName(driver_name);}
		
		catch(Exception e)
			{System.out.println("Driver could not be loaded");
			 System.out.println("/nMessage: " + e.getMessage());
			 e.printStackTrace();}
		
		return;
	}
	
	public static Connection getConnection(String user_name, String password)
	{
		if(conn != null)
		return conn;
		
		try
			{
				if(!driverloaded)
					{load_driver();
					driverloaded = true;}

				conn = DriverManager.getConnection(url, user_name, password);
				System.out.println("Connection to Database Established");
				conn.setAutoCommit(false);
				connected = true;
			}
		
		catch(SQLException e)
			{System.out.println("Database URL = " + getUrl());
			 System.out.println("User Name = " + getUser_name());
			 System.out.println("Password = " + getPassword());
			 System.out.println("Error Creating Connection: " + e.getSQLState());
			 System.out.println("/nError Code: " + e.getErrorCode());
			 System.out.println("/nMessage: " + e.getMessage());}
		
		catch(Exception e)
			{System.out.println("Not Connected");
			 e.printStackTrace();}
		
		return conn;
	}
	
	public static Connection getConnection()
	{
		try
		{
			boolean check = conn.isValid(5);
			
			if((check) && (conn != null))
			{System.out.println("Already Connected");
			 return conn;}
		}
		
		catch(SQLException e)
			{System.out.println("Error Creating Connection: " + e.getSQLState());
			 System.out.println("/nError Code: " + e.getErrorCode());
			 System.out.println("/nMessage: " + e.getMessage());}
		
		catch(Exception e)
			{System.out.println("Not Connected");
			 e.printStackTrace();}
		
		return conn;
	}
	
	public static String getUser_name() {
		return user_name;
	}

	public static void setUser_name(String user_name) {
		DBconnect.user_name = user_name;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		DBconnect.password = password;
	}

	public static String getDriverName() {
		return driver_name;
	}

	public static String getUrl() {
		return url;
	}
}
