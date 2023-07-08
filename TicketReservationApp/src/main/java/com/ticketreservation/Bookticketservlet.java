package com.ticketreservation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bookseat")
public class Bookticketservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int i = Integer.parseInt(request.getParameter("noofseats")); 
		
		HttpSession session = request.getSession();
		
		String username = session.getAttribute("username").toString(); 
		String email = session.getAttribute("email").toString(); 
		String stlocation = session.getAttribute("stlocation").toString();
		String destination = session.getAttribute("destination").toString();  
		String transportation = session.getAttribute("transportation").toString(); 
		String comfort = session.getAttribute("comfort").toString();
		String traveldate = session.getAttribute("traveldate").toString(); 
		String timing = session.getAttribute("timing").toString(); 
		int noofseats = Integer.parseInt(request.getParameter("noofseats"));  
		session.setAttribute("noofseats", noofseats);
		
		if(timing == "10:30 am") {
			timing = "morning";
		}else {
			timing = "night";
		} 
		
		System.out.println("At servlet");
		System.out.println(username); 
		System.out.println(email);
		System.out.println(stlocation);
		System.out.println(destination);
		System.out.println(transportation);
		System.out.println(comfort);
		System.out.println(traveldate);
		System.out.println(timing);
		System.out.println(noofseats);
		
		Bookticketdao bookticketdao= new Bookticketdao(username, email, stlocation, destination, transportation, comfort,
				traveldate, timing, noofseats);
	
		int j = bookticketdao.bookticket(); 
		
		PrintWriter out = response.getWriter();
		if(j >= 1) {
			if(timing == "morning") {
				timing = "10:30 am";
			}else {
				timing = "10:30 pm";
			} 
			RequestDispatcher rd = request.getRequestDispatcher("ticketconfirmation.jsp"); 
			rd.forward(request, response);
		}else {
			out.println("failed");
		}
	}

}
