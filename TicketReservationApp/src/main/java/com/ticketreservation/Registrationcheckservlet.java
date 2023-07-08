package com.ticketreservation;

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

@WebServlet("/checknow")
public class Registrationcheckservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email").toString();
		PrintWriter out = response.getWriter(); 
		
		response.setContentType("text/html"); 
		
		Registrationcheckdao registrationcheck = new Registrationcheckdao();
		int check = registrationcheck.checkRegistration(email); 
		
		if(check == 1) {
			
			out.println("<h4>You have already Registered buddy. Sign in again without any mistake.</h4>");
			out.println("<a href='signinpage.jsp'>Click Here for Sign in</a>");
		}else {
			
			out.println("<h4>Oops you haven't Registered yet. Go on buddy sign up first.</h4>");
			out.println("<a href='signuppage.jsp'>Click Here for Sign up</a>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
