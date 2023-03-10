package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age) {};
record Address (String firstLine, String city) {};


@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Muhammad";
	}
	
	@Bean
	public int age() {
		return 27;
	}
	
	@Bean
	public Person person() {
		return new Person("Raza", 15);
	}
	
	@Bean(name = "address2")
	public Address address() {
		return new Address("H#103-A", "Lahore");
	}




}
