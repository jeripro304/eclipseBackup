package ecommerce.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.model.Product;
import ecommerce.service.CustomerService;

/**
 * Servlet implementation class remvovefromcart
 */
@WebServlet("/remvovefromcart")
public class remvovefromcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id")) ;
		CustomerService c=new CustomerService();
		try {
			c.removefromcart(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("cartcontroller").forward(request, response);
		
	}



}
