package com.webbookappservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/editScreen")
public class EditScreenServlet extends HttpServlet {
    private static final String query = "SELECT BOOKNAME,BOOKEDITION,PRICE FROM BOOKDATA where id=?";
    
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
            ResultSet rs = ps.executeQuery();
            rs.next();
            out.println("<form action='editurl?id=" + id + "' method='post' autocomplete='off'>");
            out.println("<table align='center'>");
            out.println("<tr>");
            out.println("<td>Book Name</td>");
            out.println("<td><input type='text' name='bookName' value='" + rs.getString(1) + "'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Book Edition</td>");
            out.println("<td><input type='text' name='bookEdition' value='" + rs.getString(2) + "'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Book Price</td>");
            out.println("<td><input type='text' name='bookPrice' value='" + rs.getFloat(3) + "'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input type='submit' value='Edit'></td>");
            out.println("<td><input type='reset' value='cancel'></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
        } catch (SQLException se) {
            se.printStackTrace();
            out.println("<h1>" + se.getMessage() + "</h2>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1>" + e.getMessage() + "</h2>");
        }
        out.println("<a href='home.html'>Home</a>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}