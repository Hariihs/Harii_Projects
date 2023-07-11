package com.leavemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Applyleaveservice {
	
	public int applyleave(String name,String email,String department, String designation,String fromdate,String todate,String reason){
		
		String url = "jdbc:mysql:///leavemanagement";
		String uname = "root";
		String pw = "05122001";
		String query = "insert into leaveapply(empname,email,department,designation,fromdate,todate,reason) \r\n"
				+ "values(?,?,?,?,?,?,?);";
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pw); 
			PreparedStatement pst = con.prepareStatement(query); 
			pst.setString(1, name); 
			pst.setString(2, email);  
			pst.setString(3, department);
			pst.setString(4, designation);
			pst.setString(5, fromdate);
			pst.setString(6, todate);
			pst.setString(7, reason);
			i = pst.executeUpdate();  
			
		}catch(Exception e) {
			e.printStackTrace();
		}  
		return i;
	}
}
