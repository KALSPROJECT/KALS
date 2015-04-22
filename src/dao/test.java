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
		
		Login admin = new Login(conn);
		admin.nameField.setText("Jroberts61");
		admin.passField.setText("qOzdl28");
		admin.adminCheck.setSelected(true);
		
		Login user = new Login(conn);
		user.nameField.setText("srobinson0");
		user.passField.setText("Jzj5lX");
		
		new Account(conn);
	}
}
