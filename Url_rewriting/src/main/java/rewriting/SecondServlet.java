package rewriting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname=req.getParameter("name");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("Hi"+uname);
	}

}
