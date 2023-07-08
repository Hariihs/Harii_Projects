package com.ticketreservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getdetails")
public class Adminservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date = request.getParameter("date"); 
		PrintWriter out = response.getWriter();

		try { 
			 
			String url = "jdbc:mysql:///ticketbooking";
			String uname = "root";
			String pw = "05122001";
			String query = "select username,email,stlocation,destination,transportation,comfort,traveldate,timing,seats from bookings where traveldate = ?";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pw); 
			
			PreparedStatement pst = con.prepareStatement(query); 
			pst.setString(1, date);  
			ResultSet rs = pst.executeQuery();   
			 
				out.println("<table border = '1' align = 'center'>");
				out.println("<tr>");
				out.println("<th>Username</th>");
				out.println("<th>Email</th>");
				out.println("<th>Start Location</th>");
				out.println("<th>Destination</th>");
				out.println("<th>Transportation</th>"); 
				out.println("<th>Comfort</th>");
				out.println("<th>Travel Date</th>");  
				out.println("<th>Timing</th>");
				out.println("<th>Seats</th>");
				out.println("</tr>");
				 
				while(rs.next()) {  

					out.println("<tr>");  
					out.println("<td>"+rs.getString("username")+"</td>"); 
					out.println("<td>"+rs.getString("email")+"</td>"); 
					out.println("<td>"+rs.getString("stlocation")+"</td>"); 
					out.println("<td>"+rs.getString("destination")+"</td>");
					out.println("<td>"+rs.getString("transportation")+"</td>");
					out.println("<td>"+rs.getString("comfort")+"</td>");
					out.println("<td>"+rs.getString("traveldate")+"</td>");
					out.println("<td>"+rs.getString("timing")+"</td>");
					out.println("<td>"+rs.getString("seats")+"</td>");
					out.println("</tr>"); 
					
				}
				out.println("</table>");
			}catch(Exception e) {
				System.out.println(e);
			} 
		out.println("<a href=\"adminpage.jsp\">Back</a>");
		out.println("<a href=\"signinpage.jsp\">Sign out</a>");
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
