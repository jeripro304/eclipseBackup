package ecommerce.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.service.CustomerService;

/**
 * Servlet implementation class AdminCustomerController
 */
@WebServlet("/AdminCustomerController")
public class AdminCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String validate=request.getParameter("name");
		
		CustomerService cs=new CustomerService();
		try {
			cs.status(validate);
			response.setContentType("text/html");
			response.getWriter().println("Changes done");
			request.getRequestDispatcher("/CustomerViewController").include(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
	}



}
