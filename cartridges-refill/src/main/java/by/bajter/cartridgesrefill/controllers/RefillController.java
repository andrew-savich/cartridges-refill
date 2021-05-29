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
		
		@PostMapping(value = "/saveNew")
		public String saveNewRefill(@ModelAttribute("newRefill") Refill refill, 
								@RequestParam(value = "identify") String uniqIdentify,
								@RequestParam(value = "currentRefueller") String currentRefueller) {
			
			Cartridge cartridge = cartridgeService.findByUniqIdentify(uniqIdentify);
			Employee refueller = employeeService.findByLogin(currentRefueller);
			
			refill.setCartridge(cartridge);
			refill.setRefueller(refueller);
			
			refillService.save(refill);

			return "redirect:";
		}
		
		@RequestMapping("/edit/{id}")
		public String showEditRefillView(@PathVariable(name = "id") Long id, Model model) {
			Refill refill = refillService.findById(id);
			
			model.addAttribute("refill", refill);

			return "refillEdit";
		}
		
		@PostMapping(value = "saveEdits")
		public String saveRefillEdits(@ModelAttribute("refill") Refill refill) {
			refillService.save(refill);
			 
			return "redirect:";
		}
		
		@RequestMapping("/delete/{id}")
		public String deleteRefill(@PathVariable(value ="id") Long id) {
			refillService.deleteById(id);
			
			return "redirect:/refills";
		}
		
}
