package by.bajter.cartridgesrefill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.bajter.cartridgesrefill.model.cartridges.CartridgeGroup;
import by.bajter.cartridgesrefill.model.cartridges.CartridgeModel;
import by.bajter.cartridgesrefill.services.CartridgeGroupService;
import by.bajter.cartridgesrefill.services.CartrigeModelService;

@Controller
@RequestMapping("/modelsAndGroups")
public class CartridgeModelsAndGroupsController {
	@Autowired
	private CartridgeGroupService groupService;
	@Autowired
	private CartrigeModelService modelService;
	
	@RequestMapping("")
	public String showGroupList(Model model) {
		List<CartridgeGroup> cartridgeGroups = groupService.getAllCartridgeGroups();
		List<CartridgeModel> cartridgeModels = modelService.getAllCartridgeModels(); 
		
		model.addAttribute("groups", cartridgeGroups);
		model.addAttribute("models", cartridgeModels);
		
		return "/modelsAndGroups";
	}
	
}
