package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;

public class Video_DAO {
	Connection conn = null;
	
	public Video_DAO(Connection incon)
	{
		conn = incon;
	}
	
	public boolean ISANcheck (String searchText) throws SQLException
	{
		ResultSet rs = null;
		PreparedStatement ps = null;	
        try
        {
        	ps = conn.prepareStatement("select ISAN from Group3.Videos where ISAN = ?");
        	ps.setString(1, searchText);				
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
		return false;
	}
	
	public boolean titlecheck (String searchText) throws SQLException
	{
		ResultSet rs = null;
		PreparedStatement ps = null;	
        try
        {
        	ps = conn.prepareStatement("select Title from Group3.Videos where Title = ?");
        	ps.setString(1, searchText);				
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
		return false;
	}
	
	public Videos getVideobyISAN (String searchText) throws SQLException
	{
		Videos video = new Videos();
		ResultSet rs = null;
		PreparedStatement ps = null;	
		try
        {
        	ps = conn.prepareStatement("select ISAN, Title, Producer, Quantity, Section from Group3.Videos where ISAN = ?");
        	ps.setString(1, searchText);				
        	rs = ps.executeQuery();
        	
        	while(rs.next())									
        	{
        		video.setISAN(rs.getString(1));
        		video.setTitle(rs.getString(2));
        		video.setProducer(rs.getString(3));
        		video.setQuantity(rs.getInt(4));
        		video.setSection(rs.getString(5));
        	}
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
		return video;
	}
	
	public Videos getVideobyTitle (String searchText) throws SQLException
	{
		Videos video = new Videos();
		ResultSet rs = null;
		PreparedStatement ps = null;	
		try
        {
        	ps = conn.prepareStatement("select ISAN, Title, Producer, Quantity, Section from Group3.Videos where Title = ?");
        	ps.setString(1, searchText);				
        	rs = ps.executeQuery();
        	
        	while(rs.next())									
        	{
        		video.setISAN(rs.getString(1));
        		video.setTitle(rs.getString(2));
        		video.setProducer(rs.getString(3));
        		video.setQuantity(rs.getInt(4));
        		video.setSection(rs.getString(5));
        	}
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
		return video;
	}
}
