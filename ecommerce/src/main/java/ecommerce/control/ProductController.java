package ecommerce.control;

import java.io.IOException;
import java.sql.SQLException;

import ecommerce.model.Product;
import ecommerce.service.PorductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("pid");
		String name=request.getParameter("pname");
		String desc=request.getParameter("pdesc");
		String qty =request.getParameter("pqty");
		String price=request.getParameter("price");
		
		int pid=Integer.parseInt(id);
		int pqty=Integer.parseInt(qty);
		Double pprice=Double.parseDouble(price);
		
		Product p=new Product(pid, name, desc, pqty, pprice);
		PorductService ps=new PorductService();


		try {
			ps.addProduct(p);
			response.setContentType("text/html");
			response.getWriter().println("<h1><b style='color:green' >Product Created</b></h1>");
			request.getRequestDispatcher("AddProduct.jsp").include(request, response);
		} catch (SQLException e) {
			response.setContentType("text/html");
			response.getWriter().println("<h1><b style='color:Red'>Product Not Created Someting went wrong </b></h1>");
			request.getRequestDispatcher("AddProduct.jsp").include(request, response);
			
		}
	}

	
}
