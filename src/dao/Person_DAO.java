package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;

public class Person_DAO {
	Connection conn = null;
	
	public Person_DAO(Connection incon)
	{
		conn = incon;
	}
	
	public int maxPersonId() throws SQLException
	{
        PreparedStatement ps= null;
        ResultSet rs=null;
	    int id = 0;
	 
	    try
	    {
	    	ps = conn.prepareStatement("select max(Person_ID) from Group3.Person");
	        rs = ps.executeQuery();
	        
	        while(rs.next())
	        {
	            id = rs.getInt(1);
	            System.out.println("Get Max Person_ID Successful ");
	        }
	    }
	    catch(SQLException e)
	    {
	        System.out.println("Error In Accessing Person Table" + e.getSQLState());
	        System.out.println("Error Code: " + e.getErrorCode());
	        System.out.println("Message: " + e.getMessage());
	        System.exit( 1 );
	    }
	    catch(Exception e)
	    {
	        System.out.println("Unknown Error In Fetching Max ID");
	        System.out.println("Message: " + e.getMessage());
	        System.exit( 1 );
	    }
	    finally
		{
			if (conn != null)
				rs.close();
				ps.close();
		}
	    return id;
	}
	
	public boolean checkUser (String inname, String inpassword, String intype) throws SQLException
	{
		ResultSet rs = null;
		PreparedStatement ps = null;	
        try
        {
        	ps = conn.prepareStatement("select User_Name, Password_, User_Type from Group3.Users" 
        							 + " where User_Name = ? and Password_ = ? and User_Type = ?");
        	ps.setString(1, inname);						//pass in username
        	ps.setString(2, inpassword);					//pass in password
        	ps.setString(3, intype);						//pass in usertype
        	rs = ps.executeQuery();
        	
        	if(rs.next())									//if database gets a hit
        		return true;								//return a true
        }
        catch(SQLException e)
	    {
	        System.out.println("Error In Accessing Users Table" + e.getSQLState());
	        System.out.println("Error Code: " + e.getErrorCode());
	        System.out.println("Message: " + e.getMessage());
	        System.exit( 1 );
	    }
	    catch(Exception e)
	    {
	        System.out.println("Unknown Error in User Validation");
	        System.out.println("Message: " + e.getMessage());
	        System.exit( 1 );
	    }
	    finally
		{
			if (conn != null)								
				ps.close();									//close out ps
				rs.close();									//close out rs
		}
        return false;   									//return a false if database did not get a hit
	}
	
	
}
