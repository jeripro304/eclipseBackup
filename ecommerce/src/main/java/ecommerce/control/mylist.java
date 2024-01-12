package ecommerce.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.model.Product;
import ecommerce.model.UserCart;
import ecommerce.service.CustomerService;
import ecommerce.service.PorductService;

/**
 * Servlet implementation class mylist
 */
@WebServlet("/mylist")
public class mylist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 	List<Product> mylist;
		PorductService ps=new PorductService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		int id=Integer.parseInt(request.getParameter("id")) ;
		String pname=request.getParameter("name");
		String pdesc=request.getParameter("desc");
		String price=request.getParameter("price");
		int pqty=Integer.parseInt(request.getParameter("qty")) ;
		System.out.println(id);
		System.out.println(pname);
		System.out.println(pdesc);
		System.out.println(price);
		
	   
		CustomerService cs=new CustomerService();
		UserCart u=new UserCart(id,pname,pdesc,price,pqty);
		
	
		
		
		List<UserCart> wishlist=cs.userwishlist(u,id);
		
		
		session.setAttribute("mylist", wishlist);
		request.getRequestDispatcher("UserViewProductController").forward(request, response);
		
		
	}

}
