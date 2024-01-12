package ecommerce.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.model.Product;
import ecommerce.service.PorductService;

/**
 * Servlet implementation class UserViewProductController
 */
@WebServlet("/UserViewProductController")
public class UserViewProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PorductService ps=new PorductService();
		List<Product> plist=ps.viewproduct();

		request.setAttribute("pList", plist);
		response.setContentType("text/html");
		request.getRequestDispatcher("userhome.jsp").include(request, response);
		request.getRequestDispatcher("userproductview.jsp").include(request, response);
		
	}


}
