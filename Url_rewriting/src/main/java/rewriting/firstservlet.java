package rewriting;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class firstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	 
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname=req.getParameter("name");
		res.sendRedirect("SecondServlet?uname="+uname);


	}

}
