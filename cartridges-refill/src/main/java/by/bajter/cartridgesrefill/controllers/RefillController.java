package by.bajter.cartridgesrefill.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.bajter.cartridgesrefill.model.Refill;
import by.bajter.cartridgesrefill.services.RefillService;

@Controller
@RequestMapping("/refills")
public class RefillController {
		@Autowired 
		private RefillService refillService;
		
		@RequestMapping(value = "")
		public String showRefillsView(Model model) {
			List<Refill> refills = refillService.getAllReffils();
			model.addAttribute("refills", refills);
					
			return "refills";
		}
}
