package com.spring51.jstl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController22 {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController22.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/jstl/jstl22", method = RequestMethod.GET)
	public String jstl22(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		/*String 배열 */
		String[] arr = {"순두부" , "된장찌개", "제육덮밥"};
		model.addAttribute("array", arr);
		/* Arraylist 배열 */
		List<String> arr1 = new ArrayList<String>();
		arr1.add("두부");
		arr1.add("찌개");
		arr1.add("덮밥");
		
		model.addAttribute("list", arr1); 
		
		return "jstl/jstl22";
	}
	
}
