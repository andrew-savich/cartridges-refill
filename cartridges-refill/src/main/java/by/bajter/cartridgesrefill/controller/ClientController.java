package by.bajter.cartridgesrefill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.bajter.cartridgesrefill.model.client.Client;
import by.bajter.cartridgesrefill.services.ClientService;

@Controller
public class ClientController {
	@Autowired
	private ClientService service;
	
	@RequestMapping("/clients")
	public String showClientList(Model model) {
		List<Client> clients = service.getAllClients();
		model.addAttribute("clients", clients);

		return "clients";
	}
}
