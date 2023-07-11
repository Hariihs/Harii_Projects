package com.webbookappservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteurl")
public class DeleteServlet extends HttpServlet {
	
private static final String query = "delete from bookdata where id=?";
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
    	//get PrintWriter
        PrintWriter out = res.getWriter();
        
        //set content type
        res.setContentType("text/html");
        
        //get the id of record
        int id = Integer.parseInt(req.getParameter("id"));
        
        //LOAD jdbc driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }
        //generate the connection
        try (Connection con = DriverManager.getConnection("jdbc:mysql:///book", "root", "05122001")){
        	
        	PreparedStatement ps = con.prepareStatement(query);
    
            ps.setInt(1, id);
            int count = ps.executeUpdate();
			if(count == 1) {
				out.println("<h2>Record Deleted Successfully");
			}else {
				out.println("<h2>Deleting Failed");
			}
           
        } catch (SQLException se) {
            se.printStackTrace();
            out.println("<h1>" + se.getMessage() + "</h2>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1>" + e.getMessage() + "</h2>");
        }
        out.println("<br>");
        out.println("<a href='index.html'>Home</a>"); 
        out.println("<br>");
		out.println("<a href=\"booklist\">Book List</a>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
