package com.spring52.el;

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
public class ELController {
	
	private static final Logger logger = LoggerFactory.getLogger(ELController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/el/el01", method = RequestMethod.GET)
	public String el01(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		/*Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );*/
		
		return "el/el01";
	}
	
	   /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/el/el02", method = RequestMethod.GET)
    public String el02(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        
      
        
        return "el/el02";
    }
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/el/el02sub", method = RequestMethod.GET)
    public String el02sub(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        
    
        
        return "el/el02sub";
    }
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/el/el03", method = RequestMethod.GET)
    public String el03(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        
    
        
        return "el/el03";
    }
	
}
