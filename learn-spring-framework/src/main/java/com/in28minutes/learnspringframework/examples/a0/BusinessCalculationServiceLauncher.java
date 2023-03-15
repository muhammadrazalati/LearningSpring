package com.in28minutes.learnspringframework.examples.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan
public class BusinessCalculationServiceLauncher {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(BusinessCalculationServiceLauncher.class)){
			
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
			
		}

	}

}
