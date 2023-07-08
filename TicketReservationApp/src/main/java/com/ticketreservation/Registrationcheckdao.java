package com.ticketreservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Registrationcheckdao {
	
	public int checkRegistration(String email) {
		
		String url = "jdbc:mysql:///ticketbooking";
		String username = "root";
		String password = "05122001";
		String query = "select id from customers where email=?;";
		
		try{
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(query); 
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();  
			
			while(rs.next()) {
				return 1;
			}
		}catch(Exception e) {
			e.printStackTrace(); 
		} 
		
		return 0;
	}
}
