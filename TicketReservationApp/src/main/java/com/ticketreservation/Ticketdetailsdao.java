package com.ticketreservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ticketdetailsdao {

	String stlocation;
	String destination;
	String transportation; 
	String comfort;
	String traveldate;  
	String timing;
	
	public Ticketdetailsdao(String stlocation, String destination, String transportation, String comfort,
			String traveldate, String timing) {
		super();
		this.stlocation = stlocation;
		this.destination = destination;
		this.transportation = transportation;
		this.comfort = comfort;
		this.traveldate = traveldate;
		this.timing = timing;
	}  
	
	public int checkSeats() {  
		String url = "jdbc:mysql:///ticketbooking";
		String uname = "root";
		String pw = "05122001";
		String query = "select sum(seats) as remainingseats from bookings where stlocation = ? and destination = ? and transportation = ? and comfort = ? and traveldate = ? and timing = ?;";
		int sum = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,uname,pw); 
			PreparedStatement pst = con.prepareStatement(query); 
			pst.setString(1, stlocation); 
			pst.setString(2, destination);
			pst.setString(3, transportation); 
			pst.setString(4, comfort); 
			pst.setString(5, traveldate); 
			pst.setString(6, timing);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
			      int c = rs.getInt(1);
			      sum = sum + c;  
			} 
			
		}catch(Exception e) {
			e.printStackTrace();
		}  
		return sum; 
	}  
	
	public int remainingSeats(int seatscount){ 
		
		int busac = 10;
		int busnonac = 20;
		int trainac = 20;
		int trainnonac = 40;  
		
		if(transportation.equalsIgnoreCase("bus") && comfort.equalsIgnoreCase("ac")) {
			if(seatscount >= busac)
				return 0; 
			else 
				return busac - seatscount;
		}
		if(transportation.equalsIgnoreCase("bus") &&  comfort.equalsIgnoreCase("nonac")) {
			if(seatscount >= busnonac)
				return 0; 
			else 
				return busnonac - seatscount;		
		} 
		if(transportation.equalsIgnoreCase("train") && comfort.equalsIgnoreCase("ac")) {
			if(seatscount >= trainac)
				return 0; 
			else 
				return trainac - seatscount;		
		} 
		if(transportation.equalsIgnoreCase("train") && comfort.equalsIgnoreCase("nonac")) {
			if(seatscount >= trainnonac)
				return 0; 
			else 
				return trainnonac - seatscount;		
		} 
		return 0;
	}
	
}
