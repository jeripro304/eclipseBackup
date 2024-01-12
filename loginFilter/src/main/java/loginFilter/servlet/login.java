package loginFilter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class login extends HttpServlet{
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String s= (String) req.getAttribute("name");
        resp.getWriter().println("Welcome "+s);

    }

}
