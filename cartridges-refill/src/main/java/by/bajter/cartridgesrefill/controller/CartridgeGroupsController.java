package by.bajter.cartridgesrefill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.bajter.cartridgesrefill.model.cartridges.CartridgeGroup;
import by.bajter.cartridgesrefill.services.CartridgeGroupService;

@Controller
@RequestMapping("/cartridgeGroups")
public class CartridgeGroupsController {
	@Autowired
	private CartridgeGroupService service;

	@RequestMapping("")
	public String showGroupList(Model model) {
		List<CartridgeGroup> cartridgeGroups = service.getAllCartridgeGroups();

		model.addAttribute("groups", cartridgeGroups);

		return "/cartridgeGroups";
	}

	@RequestMapping("/new")
	public String showViewNewGroup(Model model) {
		CartridgeGroup group = new CartridgeGroup();

		model.addAttribute("group", group);

		return "groupAddEdit";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveNewGroup(@ModelAttribute("group") CartridgeGroup group) {
		service.save(group);

		return "redirect:";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditGroupView(@PathVariable(name = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("groupAddEdit");
		CartridgeGroup group = service.findById(id);

		modelAndView.addObject("group", group);

		return modelAndView;
	}

	@RequestMapping("/delete/{id}")
	public String deleteGroup(@PathVariable(name = "id") Long id) {
		service.deleteById(id);

		return "redirect:/cartridgeGroups";
	}

}
