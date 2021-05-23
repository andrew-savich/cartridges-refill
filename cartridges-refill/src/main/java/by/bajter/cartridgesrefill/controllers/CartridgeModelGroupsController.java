package by.bajter.cartridgesrefill.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import by.bajter.cartridgesrefill.model.cartridges.CartridgeGroup;
import by.bajter.cartridgesrefill.model.cartridges.CartridgeModel;
import by.bajter.cartridgesrefill.services.CartridgeGroupService;
import by.bajter.cartridgesrefill.services.CartrigeModelService;

@Controller
@RequestMapping("/cartridgeModelGroups")
public class CartridgeModelGroupsController {
	@Autowired
	private CartridgeGroupService groupService;

	@Autowired
	private CartrigeModelService modelService;

	@RequestMapping("")
	public String showGroupList(Model model) {
		List<CartridgeGroup> cartridgeGroups = groupService.getAllCartridgeGroups();

		model.addAttribute("groups", cartridgeGroups);

		return "/cartridgeModelGroups";
	}

	@RequestMapping("/new")
	public String showViewNewGroup(Model model) {
		CartridgeGroup group = new CartridgeGroup();

		model.addAttribute("group", group);

		return "groupAddEdit";
	}

	@PostMapping(value = "/saveGroup")
	public String saveNewGroup(@ModelAttribute("group") CartridgeGroup group) {

		groupService.save(group);

		return "redirect:";
	}

	@RequestMapping("/editGroup/{id}")
	public String showEditGroupView(@PathVariable(name = "id") Long id, Model model) {
		CartridgeGroup group = groupService.findById(id);

		model.addAttribute("group", group);

		return "groupAddEdit";
	}

	@RequestMapping("/delete/{id}")
	public String deleteGroup(@PathVariable(name = "id") Long id) {
		groupService.deleteById(id);

		return "redirect:/cartridgeModelGroups";
	}

	@RequestMapping("/{id}/newModel")
	public String showNewCartridgeModelView(Model model, @PathVariable(name = "id") Long id) {
		CartridgeModel cartridgeModel = new CartridgeModel();
		CartridgeGroup cartridgeGroup = groupService.findById(id);

		model.addAttribute("cartridgeModel", cartridgeModel);
		model.addAttribute("cartridgeGroup", cartridgeGroup);

		return "modelAddEdit";
	}

	@PostMapping(value = "/{cartridgeGroupId}/saveModel")
	public String saveCartidgeModel(@ModelAttribute("cartridgeModel") CartridgeModel cartridgeModel,
			@PathVariable(name = "cartridgeGroupId") Long cartridgeGroupId) {

		if (cartridgeModel.getGroup() != null) {
			modelService.save(cartridgeModel);

			return "redirect:/cartridgeModelGroups";
		}

		CartridgeGroup cartridgeGroup = groupService.findById(cartridgeGroupId);

		cartridgeGroup.addCartridgeModel(cartridgeModel);
		cartridgeModel.setGroup(cartridgeGroup);

		modelService.save(cartridgeModel);
		groupService.save(cartridgeGroup);

		return "redirect:/cartridgeModelGroups";
	}

	@RequestMapping(value = "/editModel/{id}")
	public String showEditModelView(Model model, @PathVariable(name = "id") Long id) {
		CartridgeModel cartridgeModel = modelService.findById(id);

		model.addAttribute("cartridgeModel", cartridgeModel);
		model.addAttribute("cartridgeGroup", cartridgeModel.getGroup());

		return "modelAddEdit";
	}
	
	@RequestMapping(value = "/deleteModel/{id}")
	public String deleteModel(Model model, @PathVariable(name = "id") Long id) {
		CartridgeModel cartridgeModel = modelService.findById(id);
		CartridgeGroup cartridgeGroup = cartridgeModel.getGroup();

		cartridgeGroup.removeCartridgeModel(cartridgeModel);
		modelService.delete(cartridgeModel);

		return "redirect:/cartridgeModelGroups";
	}

}
