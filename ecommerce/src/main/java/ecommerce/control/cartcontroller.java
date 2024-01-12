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


@WebServlet("/cartcontroller")
public class cartcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService c= new CustomerService();
		HttpSession session =request.getSession();
		String sname=(String) session.getAttribute("uname");
		System.out.println(sname);
		List<Product> plist=null;
		try {
			 plist=c.cartviewproduct(sname);
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		request.setAttribute("cartlist", plist);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
		
		
//		try {
////			c.cartviewproduct(getServletName(), 0);
//		} catch (SQLException e) {
//			System.out.println("into the catch block of cart controller");
//			e.printStackTrace();
//		}
		
		
		
	}



}
