package com.leavemanagement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/acceptleaveprincipal")
public class principalleaveapproveservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id")); 
	     
        String url = "jdbc:mysql:///leavemanagement";
		String uname = "root";
		String pw = "05122001";
		String query = "update leaveapply set leavestatus='Approved' where id = ?;";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pw); 
			PreparedStatement pst = con.prepareStatement(query); 
			pst.setInt(1, id); 
			pst.executeUpdate();  
			
		}catch(Exception e) {
			e.printStackTrace();
		} 
	
		RequestDispatcher rd = request.getRequestDispatcher("approvestaffleaveprincipal");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
