package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private AuthenticationService authenticaionService;

	public LoginController(AuthenticationService authenticaionService) {
		super();
		this.authenticaionService = authenticaionService;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String gotoLogin() {

		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String gotoWelcome(@RequestParam String name, @RequestParam String password, ModelMap model  ) {
		
		if(authenticaionService.aunthenticate(name, password)) {
		model.put("name", name);
		return "welcome";
		}
		
		model.put("errorMessage", "Invalid Credentials Please try again");
		return "login";
	}

}
