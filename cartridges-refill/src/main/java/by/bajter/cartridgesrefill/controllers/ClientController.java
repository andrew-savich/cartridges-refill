package by.bajter.cartridgesrefill.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("")
	public String showClientList(Model model) {
		List<Client> clients = service.getAllClients();

		model.addAttribute("clients", clients);

		return "clients";
	}

	@PostMapping(value = "/save")
	public String saveClient(@ModelAttribute("client") @Valid Client client, BindingResult bindingResult) {
		Client existClient = service.findByName(client.getName());
		
		if (client.getId() == null && existClient != null) {
			bindingResult.addError(new FieldError("Client", "name", "Client with this name exists!"));
		}
		
		if (client.getId() != null && existClient != null && existClient.getId() != client.getId()) {
			bindingResult.addError(new FieldError("Client", "name", "Client with this name exists!"));
		}
		
		if (bindingResult.hasErrors()) {
			return "clientAddEdit";
		}

		service.save(client);

		return "redirect:";
	}
	

	@GetMapping("/edit/{id}")
	public String showEditClientView(@PathVariable(name = "id") Long id, Model model) {
		Client client = service.findById(id);

		model.addAttribute("client", client);

		return "clientAddEdit";
	}
	
	@GetMapping("/new")
	public String showAddClientView(Model model) {
		Client client = new Client();

		model.addAttribute("client", client);

		return "clientAddEdit";
	}

	@GetMapping("/delete/{id}")
	public String deleteClient(@PathVariable(name = "id") Long id) {
		service.deleteById(id);

		return "redirect:/clients";
	}
}
