package com.ticketreservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Signupdao {
	
	String username;
	String email;
	String password;
	
	public Signupdao(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password; 
	} 
	
	void signup(String name, String mail, String ps) {   
		String url = "jdbc:mysql:///ticketbooking";
		String uname = "root";
		String pw = "05122001";
		String query = "insert into customers(username,email,passwrd) values(?,?,?);";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,uname,pw); 
			PreparedStatement pst = con.prepareStatement(query); 
			pst.setString(1, name); 
			pst.setString(2, mail);
			pst.setString(3, ps);
			pst.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}  
	}
}
