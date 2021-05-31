package by.bajter.cartridgesrefill.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String showStartPage() {
		return "index";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		
		return "login";
	}

}
