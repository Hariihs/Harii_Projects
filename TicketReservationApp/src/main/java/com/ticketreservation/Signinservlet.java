package com.ticketreservation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/signin")
public class Signinservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email"); 
		String password = request.getParameter("password");  
		
		if(email.equalsIgnoreCase("admin@quicktravel.in") && password.equalsIgnoreCase("05122001")) {
			RequestDispatcher rd = request.getRequestDispatcher("adminpage.jsp");  
			rd.forward(request, response);
		}
		
		Signindao signin = new Signindao(email,password); 
		String check = signin.executeSignin();  
		
		
		if(check != ""){  
			HttpSession session = request.getSession();
			session.setAttribute("username", check); 
			session.setAttribute("email", email);
			
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");  
			rd.forward(request, response);
		} 
		else {
			RequestDispatcher rd = request.getRequestDispatcher("wrongsignin.jsp");  
			rd.forward(request, response);
		}
		
	}

}
