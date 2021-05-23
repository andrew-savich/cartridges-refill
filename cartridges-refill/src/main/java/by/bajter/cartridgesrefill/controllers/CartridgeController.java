package by.bajter.cartridgesrefill.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.bajter.cartridgesrefill.model.cartridges.Cartridge;
import by.bajter.cartridgesrefill.model.cartridges.CartridgeGroup;
import by.bajter.cartridgesrefill.model.client.Client;
import by.bajter.cartridgesrefill.services.CartridgeGroupService;
import by.bajter.cartridgesrefill.services.CartridgeService;
import by.bajter.cartridgesrefill.services.ClientService;

@Controller
@RequestMapping("/cartridges")
public class CartridgeController {

	@Autowired
	private CartridgeService cartridgeService;

	@Autowired
	private CartridgeGroupService cartridgeGroupService;
	
	@Autowired
	private ClientService clientService;
	
	
	@RequestMapping("")
	public String showCartridgesView(Model model) {
		List<Cartridge> cartridges = cartridgeService.getAllCartridges();
		
		model.addAttribute("cartridges", cartridges);
		
		return "cartridges";
	}
	
	@RequestMapping("/new")
	public String showAddCartridgeView(Model model) {
		Cartridge cartridge = new Cartridge(); 
		cartridge.setUniqIdentify(cartridgeService.getUniqIdentify());
		
		List<CartridgeGroup> cartridgeGroups = cartridgeGroupService.getAllCartridgeGroups();
		List<Client> clients = clientService.getAllClients();
		
		model.addAttribute("cartridge", cartridge);
		model.addAttribute("groups", cartridgeGroups);
		model.addAttribute("clients", clients);
		
		return "cartridgeAddEdit";
	}
	
	
}
