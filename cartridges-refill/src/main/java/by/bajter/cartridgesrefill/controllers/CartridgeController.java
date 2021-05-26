package by.bajter.cartridgesrefill.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		cartridge.setAddedDate(new Date());

		System.out.println(cartridge.getAddedDate());

		List<CartridgeGroup> cartridgeGroups = cartridgeGroupService.getAllCartridgeGroups();
		List<Client> clients = clientService.getAllClients();

		model.addAttribute("cartridge", cartridge);
		model.addAttribute("groups", cartridgeGroups);
		model.addAttribute("clients", clients);

		return "cartridgeAddEdit";
	}

	@RequestMapping(value = "loadModelsByGroup/{id}")
	@ResponseBody
	public String loadModelsByGroup(@PathVariable("id") Long id) {
		System.out.println("got from page group.id: " + id);
		CartridgeGroup group = cartridgeGroupService.findById(id);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

		return gson.toJson(group.getCartridgeModels());
	}

	@PostMapping(value = "/save")
	public String saveCartridge(@ModelAttribute("cartridge") Cartridge cartridge) {
		System.out.println("We got cartridge: " + cartridge);
		cartridgeService.save(cartridge);

		return "redirect:";
	}

}
