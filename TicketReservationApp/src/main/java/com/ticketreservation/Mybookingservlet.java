package com.ticketreservation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/mybookingsservlet")
public class Mybookingservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html"); 
		
		HttpSession session = request.getSession();  
		String str = session.getAttribute("email").toString();  
		
		try { 
			 
			String url = "jdbc:mysql:///ticketbooking";
			String uname = "root";
			String pw = "05122001";
			String query = "select username,stlocation,destination,transportation,comfort,traveldate,timing,seats from bookings where email = ?";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pw); 
			
			PreparedStatement pst = con.prepareStatement(query); 
			//System.out.println(str);
			pst.setString(1, str);  
			ResultSet rs = pst.executeQuery();   
			
			//if(!rs.next()){
				//out.println("<h4>Heyy Buddy you haven't made any Bookings yet.</h4>");
				//out.print("<h4>Go on book a seat. Take a journey</h4>");
				//out.print("<a href='ticketdetails.jsp'>Clich here to make a reservation</a><br>");
			//}else { 
				out.println("<table border = '1' align = 'center'>");
				out.println("<tr>");
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
					out.println("<td>"+rs.getString("stlocation")+"</td>"); 
					out.println("<td>"+rs.getString("destination")+"</td>");
					out.println("<td>"+rs.getString("transportation")+"</td>");
					out.println("<td>"+rs.getString("comfort")+"</td>");
					out.println("<td>"+rs.getString("traveldate")+"</td>");
					out.println("<td>"+rs.getString("timing")+"</td>");
					out.println("<td>"+rs.getString("seats")+"</td>");
					out.println("</tr>"); 
					/*
					System.out.println(rs.getString("stlocation")); 
					System.out.println(rs.getString("destination"));
					System.out.println(rs.getString("transportation"));
					System.out.println(rs.getString("comfort"));
					System.out.println(rs.getString("traveldate"));
					System.out.println(rs.getString("timing"));
					System.out.println(rs.getString("seats"));
					*/
				}
				out.println("</table>");
			}catch(Exception e) {
				System.out.println(e);
			} 
		out.println("<a href=\"home.jsp\">Home</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
