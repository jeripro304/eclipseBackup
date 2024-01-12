package ecommerce.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.service.PorductService;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pid=(String) request.getParameter("deleteid");
		int id=Integer.parseInt(pid);
		
		System.out.println(id);
		PorductService ps=new PorductService();
		
		ps.delete(id);
		System.out.println("deleted succesfully");
		
		response.setContentType("text/html");
		response.getWriter().println("<h3>Product Deleted successfully</h3>");
		RequestDispatcher rd=request.getRequestDispatcher("/ProductViewController");
		rd.include(request, response);
	}



}
