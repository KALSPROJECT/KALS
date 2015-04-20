package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;

public class Book_DAO {
	Connection conn = null;
	
	public Book_DAO(Connection incon)
	{
		conn = incon;
	}
	
	public boolean ISBNcheck (String searchText) throws SQLException
	{
		ResultSet rs = null;
		PreparedStatement ps = null;	
        try
        {
        	ps = conn.prepareStatement("select ISBN from Group3.Books where ISBN = ?");
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
        	ps = conn.prepareStatement("select Title from Group3.Books where Title = ?");
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
	
	public Books getBookbyISBN (String searchText) throws SQLException
	{
		Books book = new Books();
		ResultSet rs = null;
		PreparedStatement ps = null;	
		try
        {
        	ps = conn.prepareStatement("select ISBN, Title, Author, Quantity, Section from Group3.Books where ISBN = ?");
        	ps.setString(1, searchText);				
        	rs = ps.executeQuery();
        	
        	while(rs.next())									
        	{
        		book.setISBN(rs.getString(1));
        		book.setTitle(rs.getString(2));
        		book.setAuthor(rs.getString(3));
        		book.setQuantity(rs.getInt(4));
        		book.setSection(rs.getString(5));
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
		return book;
	}
	
	public Books getBookbyTitle (String searchText) throws SQLException
	{
		Books book = new Books();
		ResultSet rs = null;
		PreparedStatement ps = null;	
		try
        {
        	ps = conn.prepareStatement("select ISBN, Title, Author, Quantity, Section from Group3.Books where Title = ?");
        	ps.setString(1, searchText);				
        	rs = ps.executeQuery();
        	
        	while(rs.next())									
        	{
        		book.setISBN(rs.getString(1));
        		book.setTitle(rs.getString(2));
        		book.setAuthor(rs.getString(3));
        		book.setQuantity(rs.getInt(4));
        		book.setSection(rs.getString(5));
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
		return book;
	}
	
}
