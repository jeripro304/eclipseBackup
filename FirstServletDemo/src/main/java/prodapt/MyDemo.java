package prodapt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

public class MyDemo extends HttpServlet {
	
	public void process(HttpServletRequest req,HttpServletResponse res) throws IOException{
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		int num01=Integer.parseInt(num1);
		int num02=Integer.parseInt(num2);
		String opr=req.getParameter("opr");
		PrintWriter out=res.getWriter();
		String result=null;
		
//		System.out.println("Hi Hello "+uName+" welcome to to J2EE world");
//		res.getWriter();
//		res.getWriter().println("<h1>Hi Hello "+uName+" welcome to to J2EE world<h1>");
		
//		out.println("<h1>Hi Hello "+uName+" welcome to to J2EE world<h1>");
		
		switch(opr) {
		case "add":
			result= "<center>The sum is : "+(num01+num02);
			break;
		case "sub":
			result= "<center>The sum is : "+(num01-num02);
			break;
		case "mul":
			result= "<center>The sum is : "+(num01*num02);
			break;
		case "div":
			result= "<center>The sum is : "+(num01/num02);
			break;
		}
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<center>\r\n"
				+ "<form action=\"./Name\" method=\"post\">\r\n"
				+ "	<h1>Hi hello Welcome to Basic Calculator</h1>\r\n"
				+ "<label>Number 1</label><input type=\"text\" name=\"num1\" value=\"\" placeholder=\"Type any integer\"><br><br>\r\n"
				+ "<label>Number 2</label><input type=\"text\" name=\"num2\" value=\"\" placeholder=\"Type any integer\"><br><br>\r\n"
				+ "<input type=\"radio\" name=\"opr\" value=\"add\">ADD\r\n"
				+ "<input type=\"radio\" name=\"opr\" value=\"sub\">SUB\r\n"
				+ "<input type=\"radio\" name=\"opr\" value=\"mul\">MUL\r\n"
				+ "<input type=\"radio\" name=\"opr\" value=\"div\">DIV<br>\r\n"
				+ "<input padding=\"10px\" type=\"submit\" value=\"Calculate\"><input type=\"reset\" value=\"Reset\"><br>\r\n"
				+ "</form>\r\n"
				+ "</center>\r\n"
				+ "</body>\r\n"
				+ "</html>"+result);
//		
//		out.println("<html>");
//		out.println("<body>");
//		out.println("<b><i>Sum is "+(num01+num02)+"</i></b><br>");
//		out.println("<b><i>Differnce is "+(num01-num02)+"</i></b><br>");
//		out.println("<b><i>Product is "+(num01*num02)+"</i></b><br>");
//		out.println("<b><i>Divide is "+(num01/num02)+"</i></b><br>");
//		out.println("</body>");
//		out.println("</html>");
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		process(req,res);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		process(req,res);
	}
}
