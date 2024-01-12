package ecommerce.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.service.CustomerService;
import ecommerce.service.PorductService;

/**
 * Servlet implementation class UserPageController
 */
@WebServlet("/userhome")
public class UserPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uh=request.getParameter("uh");
		if (uh.equals("VIEW PRODUCT")) {
			request.getRequestDispatcher("/UserViewProductController").forward(request, response);
		}
		else if(uh.equals("SEARCH PRODUCT")) {
			request.getRequestDispatcher("userhome.jsp").include(request, response);
			request.getRequestDispatcher("usersearch.jsp").include(request, response);
		}
		else if(uh.equals("MYLIST")) {
			request.getRequestDispatcher("mylist.jsp").forward(request, response);
		}
		else if(uh.equals("MYCART")) {
			request.getRequestDispatcher("/cartcontroller").forward(request, response);
		}
		else if(uh.equals("LOG OUT")) {
			PorductService ps=new PorductService();
			HttpSession session= request.getSession();
			session.invalidate();
			CustomerService.wishlist.clear();
			
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		
	}

	

}
