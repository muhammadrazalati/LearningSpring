package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

//  Local Authentication now not needed while using spring security so now authentication class and login jsp also not needed but
//	not deleting for future help:
	
//	private AuthenticationService authenticaionService;
//
//	public LoginController(AuthenticationService authenticaionService) {
//		super();
//		this.authenticaionService = authenticaionService;
//	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	
	
// not needed now because using spring security: 
	
//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String gotoWelcome(@RequestParam String name, @RequestParam String password, ModelMap model  ) {
//		
//		if(authenticaionService.aunthenticate(name, password)) {
//		model.put("name", name);
//		return "welcome";
//		}
//		
//		model.put("errorMessage", "Invalid Credentials Please try again");
//		return "login";
//	}

}
