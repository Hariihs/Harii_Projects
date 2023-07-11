package com.leavemanagement;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addstaff")
public class Addstaffservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("staffname");
		String phone = request.getParameter("staffphone");
		String department = request.getParameter("staffdepartment");
		String designation = request.getParameter("staffdesignation");
		String email = request.getParameter("staffemail");
		String password = request.getParameter("staffpassword");
		
		Addstaffservice addstaffservice = new Addstaffservice();
		int i = addstaffservice.addstaff(name, phone, department, designation, email, password);
	
		if(i >= 0) {
			RequestDispatcher rd = request.getRequestDispatcher("principalhomepage.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("addnewstaff.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
