package by.bajter.cartridgesrefill.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import by.bajter.cartridgesrefill.model.client.Client;
import by.bajter.cartridgesrefill.services.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	private ClientService service;

	@RequestMapping("")
	public String showClientList(Model model) {
		List<Client> clients = service.getAllClients();
		model.addAttribute("clients", clients);

		return "/clients";
	}

	@RequestMapping("/new")
	public String showViewNewClient(Model model) {
		Client client = new Client();

		model.addAttribute("client", client);

		return "clientAddEdit";
	}

	@PostMapping(value = "/save")
	public String saveNewClient(@ModelAttribute("client") Client client) {
		service.save(client);

		return "redirect:";
	}

	@RequestMapping("/edit/{id}")
	public String showEditClientView(@PathVariable(name = "id") Long id, Model model) {
		Client client = service.findById(id);

		model.addAttribute("client", client);

		return "clientAddEdit";
	}

	@RequestMapping("/delete/{id}")
	public String deleteClient(@PathVariable(name = "id") Long id) {
		service.deleteById(id);

		return "redirect:/clients";
	}
}
