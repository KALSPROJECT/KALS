package dao;

import java.sql.Connection;
import java.sql.SQLException;

import gui.*;
import model.*;

public class test {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		String user_name = "Group3";
		String password = "password";
		conn = DBconnect.getConnection(user_name, password);
		
		new Login(conn);
	}

}
