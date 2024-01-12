package edu.ems;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.http.*;


	public class JD_Servlet extends HttpServlet {
		Connection con=null;
		public void init(ServletConfig sc) {
			String driverclass=(String) sc.getInitParameter("dclass");
			String url=(String) sc.getInitParameter("url");
			String uname=(String) sc.getInitParameter("uname");
			String pass=(String) sc.getInitParameter("pass");
	
			
			try {
				Class.forName(driverclass);
				con=DriverManager.getConnection(url,uname,pass);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException
		{
		    
		        String fname=req.getParameter("fname");
		        String lname=req.getParameter("lname");
		        String email=req.getParameter("email");
		        String passwd=req.getParameter("password");
		        String ph=req.getParameter("phone");

//		        Class.forName("com.mysql.cj.jdbc.Driver");
//		        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","root");
		        PreparedStatement ps;
				try {
					ps = con.prepareStatement("INSERT INTO registration values(?,?,?,?,?)");
					 ps.setString(1, fname);
				        ps.setString(2, lname);
				        ps.setString(3, email);
				        ps.setString(4,ph);
				        ps.setString(5,passwd);
				        ps.executeUpdate();
				        PrintWriter out=res.getWriter();
				        
				        
				        out.println("<h1> Registration  Success</h1>");
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

		 


