package com.leavemanagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/stafflist")
public class Stafflistservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql:///leavemanagement";
			String uname = "root";
			String pw = "05122001";
			String query = "select * from employees where not designation='Principal';";
			
			Connection con = DriverManager.getConnection(url,uname,pw); 
			PreparedStatement pst = con.prepareStatement(query); 
			
			out.println("<table border = '1' align = 'center'>");
			out.println("<tr>");
			out.println("<th>Employee ID</th>");
			out.println("<th>Name</th>");
			out.println("<th>Email</th>");
			out.println("<th>Phone</th>");
			out.println("<th>Department</th>"); 
			out.println("<th>Designation</th>"); 
			out.println("</tr>"); 
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+rs.getInt(1)+"</td>");
				out.println("<td>"+rs.getString("empname")+"</td>");
				out.println("<td>"+rs.getString("email")+"</td>"); 
				out.println("<td>"+rs.getString("phone")+"</td>");
				out.println("<td>"+rs.getString("department")+"</td>");
				out.println("<td>"+rs.getString("designation")+"</td>");
				out.println("</tr>");
			} 
			out.println("</table>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
		out.println("<a href=\"principalhomepage.jsp\">Home</a>"); 
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
