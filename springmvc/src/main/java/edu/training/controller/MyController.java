package edu.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/printname")
	public ModelAndView printname(String uname) {
		System.out.println(uname);
		int sum=0;
		ModelAndView mv=new ModelAndView();
		mv.addObject("Myname",uname );
//		if (opr=="add") {
//			sum=num1+num2;
//		}
//		else if (opr=="sub") {
//			sum=num1-num2;
//		}
//		else if(opr=="mul") {
//			sum=num1*num2;Y
//		}
//		else if(opr=="div")
//		{
//			sum=num1/num2;
//		}
//		mv.addObject("cal",sum);
		mv.setViewName("display.jsp");
		return mv;
		
	}
	

}
