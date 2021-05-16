package by.bajter.cartridgesrefill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/")
	public String showStartPage() {
		return "index";
	}
	
	@RequestMapping("/cartridges")
	public String showCartrigesPage() {
		return "cartridges";
	}
	
	@RequestMapping("/clients")
	public String showClientsPage() {
		return "clients";
	}
	
	@RequestMapping("/users")
	public String showUsersPage() {
		return "users";
	}
	
	
}
