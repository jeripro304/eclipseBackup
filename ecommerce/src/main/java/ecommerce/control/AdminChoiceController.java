package ecommerce.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdminChoiceController")
public class AdminChoiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("opr").equals("ADD PRODUCT")) {
			RequestDispatcher rd=request.getRequestDispatcher("AddProduct.jsp");
			rd.forward(request, response);
		}
		else if(request.getParameter("opr").equals("VIEW PRODUCT")) {
			RequestDispatcher rd=request.getRequestDispatcher("/ProductViewController");
			rd.forward(request, response);
		}
		else {
			request.getRequestDispatcher("/CustomerViewController").forward(request, response);
			
		}
	}

	
	
	


}
