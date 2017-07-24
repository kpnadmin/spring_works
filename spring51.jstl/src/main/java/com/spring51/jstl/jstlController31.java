package com.spring51.jstl;

import java.text.DateFormat;
import java.util.Date;
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
public class jstlController31 {
	
	private static final Logger logger = LoggerFactory.getLogger(jstlController31.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/jstl/jstl31includefile", method = RequestMethod.GET)
	 public String jstl31includefile(Model model) {

	 return "jstl/jstl31includefile";
	
	 }
	}