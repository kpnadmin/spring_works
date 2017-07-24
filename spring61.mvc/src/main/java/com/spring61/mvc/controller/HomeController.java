package com.spring61.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring61.mvc.model.ModelLogin;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	/**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/spring/helloworld", method = RequestMethod.GET)
    public String helloworld(Locale locale, Model model) {
        logger.info("/spring/helloworld");
        
        model.addAttribute("serverTime","helloworld");
        
        
        return "spring/helloworld";
    }
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/spring/sayHello", method = RequestMethod.GET)
    public ModelAndView sayHello(Locale locale, Model model) {
        logger.info("/spring/sayHello");
       
        Map<String, String> modelMap = new HashMap<String, String>();
        modelMap.put("serverTime", "sayHello");
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("spring/sayHello"); //view 설정 , jsp파일
        mv.addAllObjects(modelMap);     // model 설정 
        
        return mv;
    }
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/spring/redirect", method = RequestMethod.GET)
    public String redirect(Locale locale, Model model) {
        logger.info("/spring/redirect");
       
        model.addAttribute("serverTime", "Hello. World!");
        
        return "redirect:/spring/helloworld";
    }
    @RequestMapping(value = "/spring/forward", method = RequestMethod.GET)
    public String forward(Locale locale, Model model) {
        logger.info("/spring/forward");
       
        model.addAttribute("serverTime", "Hello. World!");
        
        return "forward:/spring/helloworld";
    }
    @RequestMapping(value = "/spring/querystring", method = RequestMethod.GET)
    public String querystring(Locale locale, Model model,
            @RequestParam(value = "name", defaultValue="") String name1
            , @RequestParam(value = "phone", defaultValue="1") String phone1
            , HttpServletRequest request) {
        logger.info("/spring/querystring");
       
        String name2 = request.getParameter("name");
        String phone2 = request.getParameter("phone");
        model.addAttribute("name1", name1);
        model.addAttribute("name2", name2);
        model.addAttribute("phone1", phone2);
        model.addAttribute("phone2", phone2);
        
        
        return "/spring/querystring";
    }
    
    @RequestMapping(value = "/spring/pathvalue/{name}", method = RequestMethod.GET)
    public String pathvalue(Locale locale
            
            , Model model
            , @PathVariable(value="name") String name
            ) {
        logger.info("/spring/pathvalue");
        
        model.addAttribute("name", name);
        
        return "spring/pathvalue";
    }
    @RequestMapping(value = "/spring/pathvalue/{name}/{phone}", method = RequestMethod.GET)
    public String pathvalue(Locale locale
            
            , Model model
            , @PathVariable(value="name") String name
            , @PathVariable(value="phone") String phone
            ) {
        logger.info("/spring/pathvalue");
        
        model.addAttribute("name", name);
        model.addAttribute("phone",phone);
        return "spring/pathvalue";
    }
    @RequestMapping(value = "/spring/login", method = RequestMethod.GET)
    public String login(Locale locale
            , Model model
            ) {
        logger.info("/spring/loginget");
        
        model.addAttribute("id","aaa");
       
        return "spring/loginget";
    }
    @RequestMapping(value = "/spring/login", method = RequestMethod.POST)
    public String login(Locale locale
            , Model model
            , @RequestParam(value="id") String id
            , @RequestParam(value="pw") String pw
            ) {
        logger.info("/spring/login :: post");
        
        model.addAttribute("id",id);
        model.addAttribute("pw",pw);
        return "spring/loginpost";
    }
    @RequestMapping(value = "/spring/loginmodel", method = RequestMethod.GET)
    public String loginmodel(Locale locale
            , Model model
            ,@ModelAttribute ModelLogin login
            ) {
        logger.info("/spring/login :: post");
        
        model.addAttribute("info", login); 
        
        return "spring/loginmodelpost";
    }
   
}
