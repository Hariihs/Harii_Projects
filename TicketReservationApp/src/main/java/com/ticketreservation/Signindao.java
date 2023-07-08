package com.ticketreservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Signindao { 
	
	String email;
	String password;
	
	public Signindao(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	} 
	
	public String executeSignin(){
		
		String url = "jdbc:mysql:///ticketbooking";
		String uname = "root";
		String pw = "05122001";
		String query = "select username from customers where email = ? and passwrd = ?;";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,uname,pw); 
			PreparedStatement pst = con.prepareStatement(query); 
			pst.setString(1, email); 
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();  
			
			if(rs.next()) {
				String s = rs.getString("username"); 
				return s; 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}  
		return "";
	}
	
}
