package ecommerce.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.model.UserCart;


@WebServlet("/remvovefromlist")
public class remvovefromlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		List<UserCart>  ls=(List<UserCart>) session.getAttribute("mylist");
		int id =Integer.parseInt(request.getParameter("id")) ;
		System.out.println("into the romve list");
		System.out.println(id);
		System.out.println(ls);
		
		for (UserCart i:ls) {
			if (i.getPid()==id){
				ls.remove(i);
				request.getRequestDispatcher("mylist.jsp").forward(request, response);
				
			}
			else {
				continue;
			}
			
		}
//		request.getRequestDispatcher("mylist.jsp").forward(request, response);
	}

	

}
