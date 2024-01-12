package Session;

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
		HttpSession ses=req.getSession();
		String username= req.getParameter("name");
		ses.setAttribute("name", username);
		RequestDispatcher rd=req.getRequestDispatcher("/secondservlet");
		rd.forward(req, res);
	}

}
