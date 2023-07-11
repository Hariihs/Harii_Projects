package com.leavemanagement;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/resetpassword")
public class Resetpasswordservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newpassword = request.getParameter("password"); 
		HttpSession session = request.getSession();
		String email = session.getAttribute("email").toString();
		
		Resetpasswordservice resetpasswordservice = new Resetpasswordservice(); 
		int i = resetpasswordservice.resetpassword(newpassword, email);
		
		if(i >= 1) {
			RequestDispatcher rd = request.getRequestDispatcher("resetpasswordlogin.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("resetpassword.jsp");
			rd.forward(request, response);
		}
	}

}
