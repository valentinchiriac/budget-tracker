package com.valentin.wantsome.budget;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BudgetTrackerApplication {

	@GetMapping("/helloworld")
	public String sayHello() {
		return "Hello World!";
	}
}
