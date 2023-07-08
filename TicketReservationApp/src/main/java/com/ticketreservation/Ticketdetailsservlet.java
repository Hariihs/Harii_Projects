package com.ticketreservation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException; 

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;  
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/ticketdetails")
public class Ticketdetailsservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String stlocation = request.getParameter("start");
		String destination = request.getParameter("destination");
		String transportation = request.getParameter("transportation"); 
		String comfort = request.getParameter("comfort");
		String traveldate = request.getParameter("inputdate");  
		String timing = request.getParameter("timing");  
		
		if(stlocation.equals(destination)) {
			RequestDispatcher rd = request.getRequestDispatcher("samelocation.jsp");  
			rd.forward(request, response);
		} 
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = formatter.format(date).toString();  
		
		LocalTime time = LocalTime.now();
		String s = time.toString();  
		String ss = s.substring(0, 5); 
		
		String currenttime = ss.replace(":", ""); 
		int c_time = Integer.parseInt(currenttime); 
		
		String booktime = timing.replace(":", ""); 
		int b_time = Integer.parseInt(booktime); 
		
		
		if(today.equalsIgnoreCase(traveldate) && c_time > b_time) {
			RequestDispatcher rd = request.getRequestDispatcher("wrongdatetime.jsp");  
			rd.forward(request, response);
		}
			
		
		
		if(timing.equalsIgnoreCase("10:30")) {
			timing = "morning";
		}else {
			timing = "night";
		}
		Ticketdetailsdao ticketdetails = new Ticketdetailsdao(stlocation,destination,transportation,comfort,traveldate,timing);
		int seatscount = ticketdetails.checkSeats(); 
		int seatsremaining = ticketdetails.remainingSeats(seatscount);
		
		
		
		if(timing.equalsIgnoreCase("morning")) {
			timing = "10:30 am";
		}else {
			timing = "10:30 pm";
		}
		if(seatsremaining > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("seatsremaining", seatsremaining); 
			session.setAttribute("stlocation", stlocation);
			session.setAttribute("destination", destination);
			session.setAttribute("transportation", transportation);
			session.setAttribute("comfort", comfort); 
			session.setAttribute("traveldate", traveldate); 
			session.setAttribute("timing", timing);
			
			RequestDispatcher rd = request.getRequestDispatcher("bookticket.jsp");  
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("noseatsavailable.jsp");  
			rd.forward(request, response);
		}
	}

}
