package by.bajter.cartridgesrefill.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import by.bajter.cartridgesrefill.model.employee.Employee;
import by.bajter.cartridgesrefill.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping("")
	public String showEmployeeList(Model model) {
		List<Employee> employees = service.getAllEmployees();
		model.addAttribute("employees", employees);

		return "employees";
	}

	@RequestMapping("/new")
	public String showViewNewEmployee(Model model) {
		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "employeeAddEdit";
	}

	@PostMapping(value = "/save")
	public String saveNewEmployee(@ModelAttribute("employee") Employee employee) {
		service.save(employee);

		return "redirect:";
	}
	
	@RequestMapping("/edit/{id}")
	public String showEditEmployeeView(@PathVariable(name = "id") Long id, Model model) {
		Employee employee = service.findById(id);
		
		model.addAttribute("employee", employee);
		
		return "employeeAddEdit";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") Long id) {
		service.deleteById(id);
		
		return "redirect:/employees";
	}
	
}
