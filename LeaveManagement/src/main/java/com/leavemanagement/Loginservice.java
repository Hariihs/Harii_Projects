package com.leavemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Loginservice {
	
	public List<String> professorSignin(String email, String password, String designation){
			
			String url = "jdbc:mysql:///leavemanagement";
			String uname = "root";
			String pw = "05122001";
			String query = "select empname,email,phone,department,designation from employees where email = ? and passwrd = ? and designation=?;";
			List<String> list = new ArrayList<String>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,uname,pw); 
				PreparedStatement pst = con.prepareStatement(query); 
				pst.setString(1, email); 
				pst.setString(2, password); 
				pst.setString(3, designation);
				ResultSet rs = pst.executeQuery();  
				
				if(rs.next()) { 
					
					list.add(0, rs.getString("empname"));
					list.add(1, rs.getString("email"));
					list.add(2, rs.getString("phone"));
					list.add(3, rs.getString("department"));
					list.add(4, rs.getString("designation"));
					return list;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}  
			return list;
		} 
	
	public List<String> hodSignin(String email, String password, String designation){
		
		String url = "jdbc:mysql:///leavemanagement";
		String uname = "root";
		String pw = "05122001";
		String query = "select empname,email,phone,department,designation from employees where email = ? and passwrd = ? and designation=?;";
		List<String> list = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pw); 
			PreparedStatement pst = con.prepareStatement(query); 
			pst.setString(1, email); 
			pst.setString(2, password); 
			pst.setString(3, designation);
			ResultSet rs = pst.executeQuery();  
			
			if(rs.next()) {
				list.add(0, rs.getString("empname"));
				list.add(1, rs.getString("email"));
				list.add(2, rs.getString("phone"));
				list.add(3, rs.getString("department"));
				list.add(4, rs.getString("designation"));
				return list;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}  
		return list;
	} 
	
	public List<String> principalSignin(String email, String password, String designation){
		
		String url = "jdbc:mysql:///leavemanagement";
		String uname = "root";
		String pw = "05122001";
		String query = "select empname,email,phone,department,designation from employees where email = ? and passwrd = ? and designation=?;";
		List<String> list = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pw); 
			PreparedStatement pst = con.prepareStatement(query); 
			pst.setString(1, email); 
			pst.setString(2, password); 
			pst.setString(3, designation);
			ResultSet rs = pst.executeQuery();  
			
			if(rs.next()) {
				list.add(0, rs.getString("empname"));
				list.add(1, rs.getString("email"));
				list.add(2, rs.getString("phone"));
				list.add(3, rs.getString("department"));
				list.add(4, rs.getString("designation"));
				return list;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}  
		return list;
	}
}
