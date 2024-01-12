package ecommerce.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.model.Customer;
import ecommerce.service.CustomerService;

/**
 * Servlet implementation class CustomerViewController
 */
@WebServlet("/CustomerViewController")
public class CustomerViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService s=new CustomerService();
		List<Customer> clist=null;
		try {
			clist = s.viewcustomerlist();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(clist);
		request.setAttribute("clist", clist);
		request.getRequestDispatcher("Customerview.jsp").forward(request, response);
		
	}


}
