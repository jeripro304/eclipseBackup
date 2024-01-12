package ecommerce.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.repo.DAOclass;
import ecommerce.service.CustomerService;

/**
 * Servlet implementation class purchase
 */
@WebServlet("/purchase")
public class purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService cs=new CustomerService();
		HttpSession ses=request.getSession();
		String id =(String) ses.getAttribute("pid");
		String qty=(String) ses.getAttribute("qty");
		String qtycar=(String) ses.getAttribute("cqty");
		int pid =Integer.parseInt(id);
		int pqty=Integer.parseInt(qty);
//		int qtycart=Integer.parseInt(qtycar);
//		System.out.println(qtycart);
//		String id=(String) request.getAttribute("pid");
		System.out.println(pid+"  "+pqty);
		
		Connection con=DAOclass.getConnection();
		try {
			PreparedStatement ps =con.prepareStatement("select qtycart from cart where pid=?");
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				if (pqty<rs.getInt(1)) {
					response.setContentType("text/html");
					response.getWriter().println("Only limited Number of stocks available of  "+pqty+"  but in your cart there id of "+rs.getInt(1)+"  quantity"  );
					request.getRequestDispatcher("UserViewProductController").include(request, response);
				}
				else if (pqty==0) {
					response.getWriter().println("<h2>Product out of stock We have many other products related to this Please do consider that</h2>");
					request.getRequestDispatcher("UserViewProductController").include(request, response);
				}
				else {
					try {
						cs.purchase(pid, pqty,rs.getInt(1));
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					response.setContentType("text/html");
					response.getWriter().println("<h2>Product purchased successfully of Total qty  "+rs.getInt(1)+"</h2>");
					request.getRequestDispatcher("UserViewProductController").include(request, response);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}


}
