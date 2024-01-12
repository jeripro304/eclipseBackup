package ecommerce.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageController
 */
@WebServlet("/PageController")
public class PageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("page").equals("Home")) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else if(request.getParameter("page").equals("Register")) {
			request.getRequestDispatcher("Register.jsp").forward(request, response);;
		}
		else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}


}
