package edu.training.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FontController {
	@RequestMapping("/printname")
	public ModelAndView printname(String uname) {
		System.out.println(uname);
		ModelAndView mv=new ModelAndView();
		mv.addObject("uname",uname);
		mv.setViewName("display.jsp");
		return mv;
	}
}
