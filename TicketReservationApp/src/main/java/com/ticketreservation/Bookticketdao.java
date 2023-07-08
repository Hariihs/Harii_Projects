package com.ticketreservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Bookticketdao {
	
	String username; 
	String email; 
	String stlocation;
	String destination;  
	String transportation;
	String comfort;
	String traveldate; 
	String timing; 
	int noofseats;
	
	public Bookticketdao(String username, String email, String stlocation, String destination, String transportation, String comfort,
			String traveldate, String timing, int noofseats) {
		super();
		this.username = username;
		this.email = email;
		this.stlocation = stlocation;
		this.destination = destination; 
		this.transportation = transportation;
		this.comfort = comfort;
		this.traveldate = traveldate;
		this.timing = timing;
		this.noofseats = noofseats;
	}  
	
	public int bookticket(){
		
		
		int j = 0;
		String url = "jdbc:mysql:///ticketbooking";
		String uname = "root";
		String pw = "05122001";
		String query = "insert into bookings(username,email,stlocation,destination,transportation,comfort,traveldate,timing,seats) values(?,?,?,?,?,?,?,?,?);";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,uname,pw); 
			PreparedStatement pst = con.prepareStatement(query); 
			pst.setString(1, username); 
			pst.setString(2, email);
			pst.setString(3, stlocation);
			pst.setString(4, destination); 
			pst.setString(5, transportation);
			pst.setString(6, comfort);  
			pst.setString(7, traveldate); 
			pst.setString(8, timing);
			pst.setInt(9, noofseats);
			int i = pst.executeUpdate(); 
						
			j = 1;
			return i ;

		}catch(Exception e) {
			e.printStackTrace();
		} 
		return j;
	}
	
	
}
