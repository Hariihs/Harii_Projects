package com.leavemanagement;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/applyleave")
public class Applyleaveservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		
		String name = session.getAttribute("name").toString();
		String email = session.getAttribute("email").toString();
		String department = session.getAttribute("department").toString();
		String designation = session.getAttribute("designation").toString();
		String fromdate = request.getParameter("fromdate"); 
		String todate = request.getParameter("todate");
		String reason = request.getParameter("reason"); 
		
		Applyleaveservice applyleaveservice = new Applyleaveservice();
		int i = applyleaveservice.applyleave(name,email,department,designation,fromdate,todate,reason);
		
		if(i >= 1) {
			if(designation.equalsIgnoreCase("professor")) {
				RequestDispatcher rd = request.getRequestDispatcher("professorhomepage.jsp");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("hodhomepage.jsp");
				rd.forward(request, response);
			}
			
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("applyleave.jsp");
			rd.forward(request, response);
		}
	}

}
