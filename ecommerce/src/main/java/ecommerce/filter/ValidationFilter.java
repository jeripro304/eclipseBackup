//package ecommerce.filter;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//
///**
// * Servlet Filter implementation class ValidationFilter
// */
//@WebFilter("/ProductController")
//public class ValidationFilter extends HttpFilter implements Filter {
//       
//    /**
//     * @see HttpFilter#HttpFilter()
//     */
//    public ValidationFilter() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//		String id=request.getParameter("pid");
//		String name=request.getParameter("pname");
//		String desc=request.getParameter("pdesc");
//		String qty =request.getParameter("pqty");
//		String price=request.getParameter("price");
//		
//		int pid=Integer.parseInt(id);
//		int pqty=Integer.parseInt(qty);
//		Double pprice=Double.parseDouble(price);
//		
//		if(pid>0 && name.length()>4 && desc.length()>4 && pprice>1 && pqty>0)
//		
//		chain.doFilter(request, response);
//		
//		else {
//			response.setContentType("text/html");
//			response.getWriter().println("<h1><b style='color:Red'>Invalid Product details</b></h1>");
//			request.getRequestDispatcher("AddProduct.jsp").include(request, response);
//		}
//	}
//
//
//
//
//}
