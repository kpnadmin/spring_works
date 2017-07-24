package com.spring64.rest.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring64.rest.model.ModelPerson;
import com.spring64.rest.service.IServicePerson;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	
	@Autowired
	@Qualifier("servicePerson")
	IServicePerson svr;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/rest/currentversion", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public int currentversion(Model model) {
		logger.info("Welcome home! The client locale is {}.");
	
		return 1;
	}
	   @RequestMapping(value = "/rest/Login", method = {RequestMethod.GET, RequestMethod.POST})
	    @ResponseBody
	    public int Login(Model model
	            , @RequestParam(value="id", defaultValue="") String id
	            , @RequestParam(value="pw", defaultValue="") String pw
	            ) {
	        logger.info("Welcome home! The client locale is {}.");
	        ModelPerson person = new ModelPerson(id, pw);
	        int result = svr.Login(person);
	        return result;
	    }
	
	
	
	@RequestMapping(value = "/rest/personlist", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<ModelPerson> personlist(Model model
	        , @RequestParam(value="name", defaultValue="") String name
	        ){
	    logger.info("/rest/peronlist");
	    ModelPerson person = new ModelPerson();
	    person.setName(name);
	    List<ModelPerson> result = svr.getPersonList(person); 
	    
	    
	    return result;
	}
	@RequestMapping(value = "/rest/insertPerson", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public int insertPerson(Model model
            , @ModelAttribute ModelPerson person
            ){
        logger.info("/rest/insertPerson");
        
        int result = -1;
        
        result = svr.insertPerson(person);
      
        return result;
    }
}
