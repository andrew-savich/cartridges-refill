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

import by.bajter.cartridgesrefill.model.employee.Employee;
import by.bajter.cartridgesrefill.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping("/employees")
	public String showEmployeeList(Model model) {
		List<Employee> employees = service.getAllEmployees();
		model.addAttribute("employees", employees);

		return "employees";
	}

	@RequestMapping("/employees/new")
	public String showViewNewEmployee(Model model) {
		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "new_employee";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveNewEmployee(@ModelAttribute("employee") Employee employee) {
		service.saveEmployee(employee);

		return "redirect:/employees";
	}
	
	@RequestMapping("/employees/edit/{id}")
	public ModelAndView showEditEmployeeView(@PathVariable(name = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("edit_employee");
		Employee employee = service.findById(id);
		
		modelAndView.addObject("employee", employee);
		
		return modelAndView;
	}
	
	@RequestMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") Long id) {
		service.deleteById(id);
		
		return "redirect:/employees";
	}
	
}
