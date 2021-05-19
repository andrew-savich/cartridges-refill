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

		return "employee_new";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveNewEmployee(@ModelAttribute("employee") Employee employee) {
		service.save(employee);

		return "redirect:";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditEmployeeView(@PathVariable(name = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("employee_edit");
		Employee employee = service.findById(id);
		
		modelAndView.addObject("employee", employee);
		
		return modelAndView;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") Long id) {
		System.out.println("deleting employee with id: " + id);
		service.deleteById(id);
		System.out.println("deletied employee with id: " + id);
		
		return "redirect:/employees";
	}
	
}
