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
 * Servlet implementation class DeleteCustomerController
 */
@WebServlet("/DeleteCustomerController")
public class DeleteCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delcustomer=request.getParameter("delete");
		
		CustomerService cs=new CustomerService();
		try {
			cs.deletecustomer(delcustomer);
			request.getRequestDispatcher("/CustomerViewController").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
