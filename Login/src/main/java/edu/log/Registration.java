package edu.log;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
	Connection con;
	ServletContext cont;
	public void init() {
		cont=getServletContext();
		String driverclass=(String) cont.getInitParameter("dclass");
		String url=(String) cont.getInitParameter("url");
		String uname=(String) cont.getInitParameter("uname");
		String pass=(String) cont.getInitParameter("pass");

		
		try {
			Class.forName(driverclass);
			con=DriverManager.getConnection(url,uname,pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
	{
	    
	        String fname=req.getParameter("fname");
	        String lname=req.getParameter("lname");
	        String email=req.getParameter("email");
	        String passwd=req.getParameter("password");
	        String ph=req.getParameter("phone");
	        PreparedStatement ps;
			try {
				ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
				 ps.setString(1, fname);
			        ps.setString(2, lname);
			        ps.setString(3, email);
			        ps.setString(4,passwd);
			        ps.setString(5,ph);
			        int count = ps.executeUpdate();
			        PrintWriter out=res.getWriter();
			        RequestDispatcher rd;
			        if(count>0) {
//			        	out.println("Registered successfully");
			        	rd=req.getRequestDispatcher("login.html");
			        	rd.forward(req, res);
			        }
			        else {
			        	out.println("Wrong info enter again");
			        }
			        
			       
			} catch (SQLException e) {
				e.printStackTrace();
			}
    }
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
