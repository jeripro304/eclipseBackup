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

import ecommerce.model.UserCart;
import ecommerce.service.CustomerService;

/**
 * Servlet implementation class movetocart
 */
@WebServlet("/movetocart")
public class movetocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		String uname=(String) session.getAttribute("uname");
		int id =Integer.parseInt(request.getParameter("id"));
		CustomerService c=new CustomerService();
		List<UserCart> mylist=(List<UserCart>) session.getAttribute("mylist");
		System.out.println(mylist);
		
		c.removewishlist(id);
		try {
			c.cartadd(id, uname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("mylist.jsp").forward(request, response);
	}

	


}
