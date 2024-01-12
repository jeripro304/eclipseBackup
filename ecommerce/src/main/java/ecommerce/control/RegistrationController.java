package ecommerce.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.text.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.model.Customer;
import ecommerce.service.CustomerService;
import ecommerce.service.PorductService;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/Register")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String phno=request.getParameter("phno");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		
		
		//date
		String dobStr=(String)request.getParameter("dob"); 
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date dt = null;
        try {
        	dt = dateFormat.parse(dobStr);
        } catch (ParseException e) {
        	e.printStackTrace();
        }
        System.out.println(dt);
        
        Customer c=new Customer(name, dt, email, pass, phno,"invalid");
        
        CustomerService cs=new CustomerService();
        
        try {
        	cs.addcustomer(c);
        	response.getWriter().println("Registerd Successfully");
        	response.setContentType("text/html");
        	request.getRequestDispatcher("login.jsp").include(request, response);
        	
        }
        catch(Exception e){
        	response.getWriter().println("Not registered properly try again!!");
        	response.setContentType("text/html");
        	request.getRequestDispatcher("Register.jsp").include(request, response);
        }

		
	}


}
