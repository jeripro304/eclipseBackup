package ecommerce.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.service.PorductService;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		String pid=(String) session.getAttribute("editid");
		int id=Integer.parseInt(pid);
		
		Double eprice=Double.parseDouble(request.getParameter("editprice"));
		int  eqty =Integer.parseInt(request.getParameter("editqty"));
		
		PorductService ps=new PorductService();
		
		ps.edit(id,eprice,eqty);
		
		
		response.setContentType("text/html");
		response.getWriter().println("<h1>Product edited successfully</h1>");
		RequestDispatcher rd=request.getRequestDispatcher("/ProductViewController");
		rd.include(request, response);
		
		
	}


}
