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
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("id");
		int id=Integer.parseInt(pid);
		System.out.println(id);
		HttpSession sesname=request.getSession();
		String sname=(String) sesname.getAttribute("uname");
		System.out.println(sname);
		
		CustomerService cs=new CustomerService();
		
		try {
			cs.cartadd(id, sname);
			request.getRequestDispatcher("/UserViewProductController").forward(request, response);
		} catch (SQLException e) {
			response.getWriter().println("not in the cart loop");
			e.printStackTrace();
		}
		
//		try {
//			List<Product> p=cs.cartviewproduct(sname,id);
//		} catch (SQLException e) {
//			System.out.println("not int the loop");
//			e.printStackTrace();
//		}
		
	}
	
}
