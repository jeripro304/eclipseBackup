package Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class secondservlet
 */
@WebServlet("/secondservlet")
public class secondservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses=req.getSession();
		String uname=(String) ses.getAttribute("name");
		ses.setAttribute("uname",uname);
		PrintWriter out=res.getWriter();
//		out.println("Your username is "+uname);
		RequestDispatcher rd=req.getRequestDispatcher("/thirdservlet");
		rd.forward(req,res);
		
		
		
	}

}
