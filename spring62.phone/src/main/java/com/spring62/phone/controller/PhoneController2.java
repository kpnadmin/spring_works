package com.spring62.phone.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring62.phone.model.ModelPhone;
import com.spring62.phone.service.IServicePhone;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PhoneController2 {
	
	private static final Logger logger = LoggerFactory.getLogger(PhoneController2.class);
	
	@Autowired
	IServicePhone svr;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/phone/writelist", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	    logger.info("writeListForm :: get", locale);
		return "phone/writeListForm";
	}
	
	@RequestMapping(value="/phone/writelist", method = RequestMethod.POST)
    public String writelist1(Locale locale, Model model, @ModelAttribute List<ModelPhone> phones){
        logger.info("writelist1 :: post", locale);
        
        svr.insertPhoneList(phones);
        
        List<ModelPhone> result = svr.getPhoneList();
    
        model.addAttribute("list",result);
        
        
        return "phone/writeListResult";
    }
	
	
	
}
