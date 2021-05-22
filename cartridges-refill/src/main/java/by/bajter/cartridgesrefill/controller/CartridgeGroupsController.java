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
import by.bajter.cartridgesrefill.model.cartridges.CartridgeModel;
import by.bajter.cartridgesrefill.services.CartridgeGroupService;
import by.bajter.cartridgesrefill.services.CartrigeModelService;

@Controller
@RequestMapping("/cartridgeGroups")
public class CartridgeGroupsController {
	@Autowired
	private CartridgeGroupService groupService;

	@Autowired
	private CartrigeModelService modelService;

	@RequestMapping("")
	public String showGroupList(Model model) {
		List<CartridgeGroup> cartridgeGroups = groupService.getAllCartridgeGroups();

		model.addAttribute("groups", cartridgeGroups);

		return "/cartridgeGroups";
	}

	@RequestMapping("/new")
	public String showViewNewGroup(Model model) {
		CartridgeGroup group = new CartridgeGroup();

		model.addAttribute("group", group);

		return "groupAddEdit";
	}

	@RequestMapping(value = "/saveGroup", method = RequestMethod.POST)
	public String saveNewGroup(@ModelAttribute("group") CartridgeGroup group) {

		groupService.save(group);

		return "redirect:";
	}

	@RequestMapping("/editGroup/{id}")
	public ModelAndView showEditGroupView(@PathVariable(name = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("groupAddEdit");
		CartridgeGroup group = groupService.findById(id);

		modelAndView.addObject("group", group);

		return modelAndView;
	}

	@RequestMapping("/delete/{id}")
	public String deleteGroup(@PathVariable(name = "id") Long id) {
		groupService.deleteById(id);

		return "redirect:/cartridgeGroups";
	}

	@RequestMapping("/{id}/newModel")
	public String showNewCartridgeModelView(Model model, @PathVariable(name = "id") Long id) {
		CartridgeModel cartridgeModel = new CartridgeModel();
		CartridgeGroup cartridgeGroup = groupService.findById(id);

		model.addAttribute("cartridgeModel", cartridgeModel);
		model.addAttribute("cartridgeGroup", cartridgeGroup);

		return "modelAddEdit";
	}

	@RequestMapping(value = "/{cartridgeGroupId}/saveModel", method = RequestMethod.POST)
	public String saveCartidgeModel(@ModelAttribute("cartridgeModel") CartridgeModel cartridgeModel,
			@PathVariable(name = "cartridgeGroupId") Long cartridgeGroupId) {
		System.out.println("we got cartridge: " + cartridgeModel);

		if (cartridgeModel.getGroup() != null) {
			System.out.println("cartridge group isn't null");
			modelService.save(cartridgeModel);

			return "redirect:/cartridgeGroups";
		}

		System.out.println("cartridge group is null");

		CartridgeGroup cartridgeGroup = groupService.findById(cartridgeGroupId);

		cartridgeGroup.addCartridgeModel(cartridgeModel);
		cartridgeModel.setGroup(cartridgeGroup);

		modelService.save(cartridgeModel);
		groupService.save(cartridgeGroup);

		return "redirect:/cartridgeGroups";
	}

	@RequestMapping(value = "/editModel/{id}")
	public String showEditModelView(Model model, @PathVariable(name = "id") Long id) {
		CartridgeModel cartridgeModel = modelService.findById(id);

		model.addAttribute("cartridgeModel", cartridgeModel);
		model.addAttribute("cartridgeGroup", cartridgeModel.getGroup());

		return "modelAddEdit";
	}

}
