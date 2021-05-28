package by.bajter.cartridgesrefill.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.bajter.cartridgesrefill.model.Refill;
import by.bajter.cartridgesrefill.model.cartridges.Cartridge;
import by.bajter.cartridgesrefill.services.CartridgeService;
import by.bajter.cartridgesrefill.services.RefillService;

@Controller
@RequestMapping("/refills")
public class RefillController {
		@Autowired 
		private RefillService refillService;
		
		@Autowired
		private CartridgeService cartridgeService;
		
		@RequestMapping(value = "")
		public String showRefillsView(Model model) {
			List<Refill> refills = refillService.getAllReffils();
			Cartridge cartridge = new Cartridge();
			
			model.addAttribute("refills", refills);
			model.addAttribute("cartridge", cartridge);
			
			
			return "refills";
		}
		
		@RequestMapping("/new")
		public String showAddRefillView(Model model) {
			Refill refill = new Refill();
			
			refill.setRefillDate(new Date());
			
			

			model.addAttribute("refill", refill);

			return "refillAddEdit";
		}
}