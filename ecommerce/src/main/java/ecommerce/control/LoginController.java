package ecommerce.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.repo.DAOclass;
import ecommerce.service.CustomerService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usname=request.getParameter("usname");
		String passcode =request.getParameter("passcode");
		PrintWriter pw=response.getWriter();
		
		if(usname.equals("Admin")) {
			if(passcode.equals("Reset@123")) {
				request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
			}
			else {
				response.setContentType("text/html");
				
	            pw.println("<h3>Invalid Admin Recheck your Password </h3>");
	            request.getRequestDispatcher("login.jsp").include(request, response);
			}
		
		}
		else {
			
//			CustomerService c=new CustomerService();
			Connection con=DAOclass.getConnection();
			PreparedStatement ps;
			try {
				
				ps = con.prepareStatement("select * from customer where email=?");
				ps.setString(1, usname);
				ResultSet rs=ps.executeQuery();
				if (rs.next()) {
					if (usname.equals(rs.getString(4))) {
						HttpSession sesname=request.getSession();
						sesname.setAttribute("uname", usname);
						if (passcode.equals(rs.getString(5))&& rs.getString(6).equals("valid")) {
							request.getRequestDispatcher("userhome.jsp").forward(request, response);
							System.out.println("he has access");
						}
						else if(passcode.equals(rs.getString(5)) && rs.getString(6).equals("invalid"))  {
							response.setContentType("text/html");
							response.getWriter().println("Your are not authorized to enter please wait");
							request.getRequestDispatcher("login.jsp").include(request, response);
							System.out.println("he does not have access");
						}
						else {
							response.setContentType("text/html");
							response.getWriter().println("Wrong password try again");
							request.getRequestDispatcher("login.jsp").include(request, response);
							System.out.println("he does not have access");
						}
					}
					
				}
				else {
					System.out.println("you have to register");
					response.setContentType("text/html");
					response.getWriter().println("Your Doesnt have a account here Please Register");
					request.getRequestDispatcher("Register.jsp").include(request, response);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			
				
		}	
	}
}
