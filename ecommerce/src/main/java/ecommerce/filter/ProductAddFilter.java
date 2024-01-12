package ecommerce.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class ProductAddFilter
 */
@WebFilter("/ProductController")
public class ProductAddFilter extends HttpFilter implements Filter {
       

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String id=request.getParameter("pid");
		String name=request.getParameter("pname");
		String desc=request.getParameter("pdesc");
		String qty =request.getParameter("pqty");
		String price=request.getParameter("price");
		
		int pid=Integer.parseInt(id);
		int pqty=Integer.parseInt(qty);
		Double pprice=Double.parseDouble(price);

		ArrayList<String> arrpro = new ArrayList<String>(5);
		
		
			boolean proid=true;
			if (pid<0){
				proid=false;
				arrpro.add("Please give a valid Product id");
			}
			boolean proname=true;
			if (name.length()<3) {
				proname=false;
				arrpro.add("please give a valid name char greater than 3");
			}
			boolean prodesc=true;
			if (desc.length()<0) {
				prodesc=false;
				arrpro.add("please give a valid description");
			}
			boolean proqty=true;
			if(pqty==0 ||pqty<0) {
				proqty=false;
				arrpro.add("Product qty cannot be 0 or lesser");
			}
			boolean proprice=true;
			if(pprice==0 || pprice <0 ) {
				proprice=false;
				arrpro.add("product qty should be greater than 0 or lesser ");
			}
			
			if (proid==true && proname==true && prodesc==true&& proprice==true && proqty==true) {
				chain.doFilter(request, response);
			}
			else {
				for (int i = 0; i < arrpro.size(); i++) {
					response.setContentType("text/html");
					response.getWriter().println(arrpro.get(i)+" | ");				
					}
				request.getRequestDispatcher("AddProduct.jsp").include(request, response);
			}
		
		
		
		
	}



}
