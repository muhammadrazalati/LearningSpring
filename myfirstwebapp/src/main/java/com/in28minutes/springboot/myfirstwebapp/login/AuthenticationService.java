package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	boolean aunthenticate (String userName, String password) {
		boolean isValidUser = userName.equalsIgnoreCase("in28minutes");
		boolean isValidPassword = password.equalsIgnoreCase("demo");
		
		return isValidUser && isValidPassword;
	}
}
