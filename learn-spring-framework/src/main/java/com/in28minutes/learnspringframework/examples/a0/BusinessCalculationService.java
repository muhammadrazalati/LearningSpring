package com.in28minutes.learnspringframework.examples.a0;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {
	
	private DataService dataService;
	
	
	@Autowired
	public BusinessCalculationService(DataService dataService) {
		super();
		this.dataService = dataService;
	}



	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}

}
