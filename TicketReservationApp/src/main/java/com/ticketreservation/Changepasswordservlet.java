package com.ticketreservation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/changepassword")
public class Changepasswordservlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = request.getParameter("newpass");
		
		HttpSession session = request.getSession();
		String email = session.getAttribute("email").toString(); 
		
		System.out.println(email); 
		
		String url = "jdbc:mysql:///ticketbooking";
		String uname = "root";
		String pw = "05122001";
		String query = "update customers set passwrd=? where email = ?;";
		try {
			Connection con = DriverManager.getConnection(url,uname,pw); 
			PreparedStatement pst = con.prepareStatement(query); 
			pst.setString(1,password); 
			pst.setString(2, email);
			int i = pst.executeUpdate();  
			
			if(i >= 1) {
				RequestDispatcher rd = request.getRequestDispatcher("signinpage.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}  
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
