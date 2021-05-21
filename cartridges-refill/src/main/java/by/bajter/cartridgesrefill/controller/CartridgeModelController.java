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

import by.bajter.cartridgesrefill.model.cartridges.CartridgeModel;
import by.bajter.cartridgesrefill.services.CartrigeModelService;

@Controller
@RequestMapping("/cartridgeModels")
public class CartridgeModelController {
	@Autowired
	private CartrigeModelService service;

	@RequestMapping("")
	public String showCartridgeModelsView(Model model) {
		List<CartridgeModel> cartidgeModels = service.getAllCartridgeModels();
		model.addAttribute("cartidgeModels", cartidgeModels);

		return "/cartridgeModels";
	}

	@RequestMapping("/new")
	public String showNewCartridgeModelView(Model model) {
		CartridgeModel cartridgeModel = new CartridgeModel();

		model.addAttribute("cartridgeModel", cartridgeModel);

		return "cartridgeModelAddEdit";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCartidgeModel(@ModelAttribute("cartridgeModel") CartridgeModel cartridgeModel) {
		service.save(cartridgeModel);

		return "redirect:";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCartridgeModelView(@PathVariable(name = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cartridgeModelAddEdit");
		CartridgeModel cartridgeModel = service.findById(id);

		modelAndView.addObject("cartridgeModel", cartridgeModel);

		return modelAndView;
	}

	@RequestMapping("/delete/{id}")
	public String deleteCartridgeModel(@PathVariable(name = "id") Long id) {
		service.deleteById(id);

		return "redirect:/cartridgeModels";
	}
}
