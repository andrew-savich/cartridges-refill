package by.bajter.cartridgesrefill.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.bajter.cartridgesrefill.model.Refill;
import by.bajter.cartridgesrefill.model.cartridges.Cartridge;
import by.bajter.cartridgesrefill.model.employee.Employee;
import by.bajter.cartridgesrefill.services.CartridgeService;
import by.bajter.cartridgesrefill.services.EmployeeService;
import by.bajter.cartridgesrefill.services.RefillService;

@Controller
@RequestMapping("/refills")
public class RefillController {
		@Autowired 
		private RefillService refillService;
		
		@Autowired
		private CartridgeService cartridgeService;
		
		@Autowired
		private EmployeeService employeeService;
		
		@RequestMapping(value = "")
		public String showRefillsView(Model model) {
			List<Refill> refills = refillService.getAllReffils();
			Refill newRefill = new Refill();
			newRefill.setRefillDate(new Date());
			
			model.addAttribute("refills", refills);
			model.addAttribute("newRefill", newRefill);
			
			return "refills";
		}
		
		@PostMapping(value = "/save")
		public String saveRefill(@ModelAttribute("newRefill") Refill refill, 
								@RequestParam(value = "identify") String uniqIdentify,
								@RequestParam(value = "currentRefueller") String currentRefueller) {
			
			Cartridge cartridge = cartridgeService.findByUniqIdentify(uniqIdentify);
			Employee refueller = employeeService.findByLogin(currentRefueller);
			
			refill.setCartridge(cartridge);
			refill.setRefueller(refueller);
			
			refillService.save(refill);

			return "redirect:";
		}
		
}
