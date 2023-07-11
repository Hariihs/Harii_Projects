package com.leavemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Addstaffservice {

	public int addstaff(String name, String phone, String department, String designation, String email, String password){
		
		String url = "jdbc:mysql:///leavemanagement";
		String uname = "root";
		String pw = "05122001";
		String query = "insert into employees(empname,email,phone,department,designation,passwrd) values(?,?,?,?,?,?);";
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pw); 
			PreparedStatement pst = con.prepareStatement(query); 
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, phone);
			pst.setString(4, department);
			pst.setString(5, designation);
			pst.setString(6, password); 
			
			i = pst.executeUpdate();  
			
		}catch(Exception e) {
			e.printStackTrace();
		}  
		return i;
	}
}
