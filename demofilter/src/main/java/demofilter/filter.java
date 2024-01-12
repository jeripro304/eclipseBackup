package demofilter;

import javax.servlet.http.HttpFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class filter extends HttpFilter{
	public void doFilter(HttpServletRequest req,HttpServletResponse res,FilterChain chain) throws IOException, ServletException {
		System.out.println("via filter");
		chain.doFilter(req, res);
	}

}
