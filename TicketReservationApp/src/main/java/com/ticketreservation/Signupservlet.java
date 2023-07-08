package com.ticketreservation;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class Signupservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String email = request.getParameter("email"); 
		String password = request.getParameter("password"); 
		
		Signupdao sud = new Signupdao(username,email,password); 
		sud.signup(username,email,password); 
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);  
		session.setAttribute("email", email);
		
		RequestDispatcher rd = request.getRequestDispatcher("aftersignup.jsp");  
		rd.forward(request, response);
		
	}

}
