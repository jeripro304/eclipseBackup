package demofilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet extends HttpServlet{
public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String uname=req.getParameter("uname");
		PrintWriter out=res.getWriter();
		out.println("hola   " +uname);
		
	}

}
