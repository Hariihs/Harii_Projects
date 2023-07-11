package com.leavemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Resetpasswordservice {
	
	public int resetpassword(String newpassword, String email) {
		
		String url = "jdbc:mysql:///leavemanagement";
		String uname = "root";
		String pw = "05122001";
		String query = "update employees set passwrd=? where email=?;";
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pw); 
			PreparedStatement pst = con.prepareStatement(query); 
			pst.setString(1, newpassword); 
			pst.setString(2, email); 
			i = pst.executeUpdate();  
			
		}catch(Exception e) {
			e.printStackTrace();
		}  
		return i;
	}
}
