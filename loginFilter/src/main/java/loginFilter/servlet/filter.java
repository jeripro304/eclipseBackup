package loginFilter.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class filter extends HttpFilter{
	Connection con;

	public void init(FilterConfig cont) {
		
		
		String driverclass= cont.getInitParameter("dclass");
		String url= cont.getInitParameter("url");
		String uname= cont.getInitParameter("uname");
		String pass= cont.getInitParameter("pass");
		System.out.println("hello");
		
		try {
			Class.forName(driverclass);
			con=DriverManager.getConnection(url,uname,pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void doFilter(HttpServletRequest req,HttpServletResponse res,FilterChain chain) throws ServletException, IOException {
		String email=req.getParameter("usname");
        String passwd=req.getParameter("password");
        PreparedStatement ps;
        try {
			ps= con.prepareStatement("select fname from prodapt.register where email=? and password=?;");
			ps.setString(1, email);
			ps.setString(2, passwd);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				req.setAttribute("name",rs.getString(1));
				chain.doFilter(req, res);
				
				
			}
			else {
				PrintWriter pr = res.getWriter();
				res.setContentType("text/html");
//				pr.println("Illegal Entry");
//				rd = req.getRequestDispatcher("index.html");
//				rd.forward(req, res);
				pr.println(
						"<h4>Illegal Entry</h4>\r\n"
						);
	            res.setContentType("text/html");
                req.getRequestDispatcher("index.html").include(req, res);
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