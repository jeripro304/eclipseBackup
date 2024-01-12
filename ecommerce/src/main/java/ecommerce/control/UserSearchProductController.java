package ecommerce.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.model.Product;
import ecommerce.service.CustomerService;

/**
 * Servlet implementation class UserSearchProductController
 */
@WebServlet("/UserSearchProductController")
public class UserSearchProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String csearch=request.getParameter("custsearch");
		CustomerService cs=new CustomerService();
		List<Product> prolist=null;
		try {
			prolist = cs.custsearch(csearch);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html");
		request.setAttribute("prolist",prolist);
		request.getRequestDispatcher("userhome.jsp").include(request, response);
		request.getRequestDispatcher("userview.jsp").include(request, response);
	}



}
