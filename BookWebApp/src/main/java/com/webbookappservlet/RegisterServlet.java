package com.webbookappservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	private  static final String query = "insert into bookdata(bookname,bookedition,price) values(?,?,?)"; 
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get printwriter 
		PrintWriter out = resp.getWriter();  
		
		//set content type 
		resp.setContentType("text/html"); 
		
		//Get the book data
		String bookName = req.getParameter("bookName");
		String bookEdition = req.getParameter("bookEdition");
		float bookPrice = Float.parseFloat(req.getParameter("bookPrice"));
		
		//Load jdbc driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		//generate connection 
		try(Connection con = DriverManager.getConnection("jdbc:mysql:///book","root","05122001")){
			PreparedStatement ps = con.prepareStatement(query); 
			ps.setString(1, bookName);
			ps.setString(2, bookEdition);
			ps.setFloat(3, bookPrice); 
			
			int count = ps.executeUpdate();
			if(count == 1) {
				out.println("<h2>Record Registered Successfully");
			}else {
				out.println("<h2>Record not Registered Successfully");
			}
		}catch(SQLException se) {
			se.printStackTrace(); 
			out.println("<h2>"+se.getMessage()+"</h2>");
		}catch(Exception e) {
			e.printStackTrace(); 
			out.println("<h2>"+e.getMessage()+"</h2>");
		} 
		
		out.println("<br>");
		out.println("<a href=\"index.html\">Home</a>"); 
		out.println("<br>");
		out.println("<a href=\"booklist\">Book List</a>");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
