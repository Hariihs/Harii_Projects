package com.leavemanagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Loginservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mail = request.getParameter("mail"); 
		String password = request.getParameter("password"); 
		String designation = request.getParameter("designation");
		
		List<String> list = new ArrayList<String>();
		
		if(designation.equalsIgnoreCase("professor")) {
			
			Loginservice login = new Loginservice();
			list = login.professorSignin(mail, password, designation);
			
			if(list.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("wronglogin.jsp");
				rd.forward(request, response);
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("name", list.get(0));
				session.setAttribute("email", list.get(1));
				session.setAttribute("phone", list.get(2));
				session.setAttribute("department", list.get(3));
				session.setAttribute("designation", list.get(4));
				
				RequestDispatcher rd = request.getRequestDispatcher("professorhomepage.jsp");
				rd.forward(request, response);
			}
		}
		else if(designation.equalsIgnoreCase("hod")) {
			
			Loginservice login = new Loginservice();
			list = login.hodSignin(mail, password, designation); 
			
			if(list.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("wronglogin.jsp");
				rd.forward(request, response);
			}else{
				HttpSession session = request.getSession(); 
				session.setAttribute("name", list.get(0)); 
				session.setAttribute("email", list.get(1)); 
				session.setAttribute("phone", list.get(2));
				session.setAttribute("department", list.get(3));
				session.setAttribute("designation", list.get(4));
				
				RequestDispatcher rd = request.getRequestDispatcher("hodhomepage.jsp");
				rd.forward(request, response);
			}
		} 
		else{
			
			Loginservice login = new Loginservice();
			list = login.principalSignin(mail, password, designation); 
			
			if(list.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("wronglogin.jsp");
				rd.forward(request, response);
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("name", list.get(0));
				session.setAttribute("email", list.get(1));
				session.setAttribute("phone", list.get(2));
				session.setAttribute("department", list.get(3));
				session.setAttribute("designation", list.get(4));
				
				RequestDispatcher rd = request.getRequestDispatcher("principalhomepage.jsp");
				rd.forward(request, response);
			}
		}
	}

}
