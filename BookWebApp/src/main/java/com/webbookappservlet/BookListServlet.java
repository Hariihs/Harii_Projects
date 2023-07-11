package com.webbookappservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/booklist")
public class BookListServlet extends HttpServlet {

	private  static final String query = "Select * from bookdata"; 
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get printwriter 
		PrintWriter out = resp.getWriter();  
		
		//set content type 
		resp.setContentType("text/html"); 
		
		//Load jdbc driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		//generate connection 
		try(Connection con = DriverManager.getConnection("jdbc:mysql:///book","root","05122001")){
			PreparedStatement ps = con.prepareStatement(query);  
			ResultSet rs = ps.executeQuery(query);  
			
			out.println("<table border = '1' align = 'center'>");
			out.println("<tr>");
			//out.println("<th>Book Id</th>");
			out.println("<th>Book Name</th>");
			out.println("<th>Book Edition</th>");
			out.println("<th>Book Price</th>"); 
			out.println("<th>Edit</th>");
			out.println("<th>Delete</th>"); 
			out.println("<tr>");
			while(rs.next()) {
				out.println("<tr>");
				//out.println("<td>"+rs.getInt(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getFloat(4)+"</td>"); 
				out.println("<td><a href='editScreen?id="+rs.getInt(1)+"'>Edit</a></td>"); 
				out.println("<td><a href='deleteurl?id="+rs.getInt(1)+"'>Delete</a></td>");
				out.println("<tr>");
			} 
			out.println("</table>");
			
		}catch(SQLException se) {
			se.printStackTrace(); 
			out.println("<h2>"+se.getMessage()+"</h2>");
		}catch(Exception e) {
			e.printStackTrace(); 
			out.println("<h2>"+e.getMessage()+"</h2>");
		} 
		out.println("<a href=\"index.html\">Home</a>"); 
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
