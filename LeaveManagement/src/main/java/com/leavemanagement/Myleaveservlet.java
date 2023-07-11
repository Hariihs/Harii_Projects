package com.leavemanagement;

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
import jakarta.servlet.http.HttpSession;

@WebServlet("/myleave")
public class Myleaveservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
		
		HttpSession session = request.getSession();
		String email = session.getAttribute("email").toString();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql:///leavemanagement";
			String uname = "root";
			String pw = "05122001";
			String query = "select * from leaveapply where email = ?;";
			
			Connection con = DriverManager.getConnection(url,uname,pw); 
			PreparedStatement pst = con.prepareStatement(query); 
			pst.setString(1, email);  
			
			out.println("<table border = '1' align = 'center'>");
			out.println("<tr>");
			//out.println("<th>Id</th>");
			out.println("<th>Name</th>");
			out.println("<th>Email</th>");
			out.println("<th>Department</th>"); 
			out.println("<th>Designation</th>");
			out.println("<th>From Date</th>");  
			out.println("<th>To Date</th>"); 
			out.println("<th>Reason</th>"); 
			out.println("<th>Status</th>"); 
			out.println("</tr>"); 
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				out.println("<tr>");
				//out.println("<td>"+rs.getInt(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(6)+"</td>");
				out.println("<td>"+rs.getString(7)+"</td>");
				out.println("<td>"+rs.getString(8)+"</td>"); 
				out.println("<td>"+rs.getString(9)+"</td>");
				out.println("</tr>");
			} 
			out.println("</table>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}   
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
