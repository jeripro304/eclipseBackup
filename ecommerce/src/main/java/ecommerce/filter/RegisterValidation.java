package ecommerce.filter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/Register")
public class RegisterValidation extends HttpFilter implements Filter {
       


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		String phno=request.getParameter("phno");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		ArrayList<String> arr = new ArrayList<String>(5);
		
		
		//Name check
		boolean nam=false;
		if (name.length()>3) {
			nam=true;
		}
		else {
			arr.add("Name length should be greater than 3 characters");
		}
		
//	    Date check year lesser than 2000
		LocalDate currentDate = LocalDate.parse(dob);
		int year = currentDate.getYear();
		boolean yeaar =false;
		if(year<2000) {
			yeaar=true;
		}
		else {
			arr.add("The year should be lesser than 31-12-1999");
		}
		
		//mobile number check
		Pattern p = Pattern.compile("[6-9][0-9]{9}");
	    Matcher m = p.matcher(phno);
	    boolean phn=false;
	    if ((m.find() && m.group().equals(phno))) {
	    	phn=true;
	    }
	    else {
	    	arr.add("Please recheck your mobile number");
	    }
	    
	    //email id check
	    String sep[]=email.split("@");
    	String tld=sep[1];
    	String s[]=tld.split("[.]");
    	String stld=s[1];
	    boolean mail=false;
	    if(email.matches("[a-z][a-zA-Z0-9._]+@[a-z]+\\.[a-z]{2,4}" )&&stld.equals("com")|| stld.equals("org")||stld.equals("in")) {
	    	mail=true;
	    }
	    else {
	    	arr.add("Invalid Email Please check your TLD");
	    }
	    

		
		
		//password check
		boolean passcode=false;
		if (pass.matches("[a-zA-Z0-9]*$")&& pass.length()>8) {
			passcode =true;
		}else {
			arr.add("please rechek your password");
		}
		
		if (nam==true && yeaar==true && phn==true && mail==true && passcode==true ) {
			chain.doFilter(request, response);
		}
		else {
//			response.setContentType("text/html");
//			response.getWriter().println(arr);
//			request.getRequestDispatcher("Register.jsp").include(request, response);
			for (int i = 0; i < arr.size(); i++) {
				response.setContentType("text/html");
				response.getWriter().println(arr.get(i)+" | ");				
				}
			request.getRequestDispatcher("Register.jsp").include(request, response);
			
		}
		
		
			
	}
}
