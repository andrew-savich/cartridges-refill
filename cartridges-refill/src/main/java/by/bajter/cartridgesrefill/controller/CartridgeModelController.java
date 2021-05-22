package by.bajter.cartridgesrefill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.bajter.cartridgesrefill.model.cartridges.CartridgeModel;
import by.bajter.cartridgesrefill.services.CartrigeModelService;


public class CartridgeModelController {
	@Autowired
	private CartrigeModelService service;


	@RequestMapping("/cartridgeGroups/{name}/newModel")
	public String showNewCartridgeModelView(Model model, @PathVariable(name = "name") String groupName) {
		System.out.println("we got groupe name: " + groupName);
		CartridgeModel cartridgeModel = new CartridgeModel();

		model.addAttribute("cartridgeModel", cartridgeModel);
		model.addAttribute("groupName", groupName);

		return "modelAddEdit";
	}

	@RequestMapping(value = "/cartridgeGroups/saveModel", method = RequestMethod.POST)
	public String saveCartidgeModel(@ModelAttribute("cartridgeModel") CartridgeModel cartridgeModel) {
		service.save(cartridgeModel);

		return "redirect:/cartridgeGroups";
	}

	@RequestMapping("/cartridgeGroups/editModel/{id}")
	public ModelAndView showEditCartridgeModelView(@PathVariable(name = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("modelAddEdit");
		CartridgeModel cartridgeModel = service.findById(id);

		modelAndView.addObject("cartridgeModel", cartridgeModel);

		return modelAndView;
	}

	@RequestMapping("/delete/{id}")
	public String deleteCartridgeModel(@PathVariable(name = "id") Long id) {
		service.deleteById(id);

		return "redirect:/cartridgeGroups";
	}
}
