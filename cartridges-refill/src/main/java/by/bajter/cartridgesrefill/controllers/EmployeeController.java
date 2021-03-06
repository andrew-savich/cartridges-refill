package by.bajter.cartridgesrefill.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.bajter.cartridgesrefill.model.employee.Employee;
import by.bajter.cartridgesrefill.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("")
	public String showEmployeeList(Model model) {
		List<Employee> employees = service.getAllEmployees();
		model.addAttribute("employees", employees);

		return "employees";
	}

	@GetMapping("/new")
	public String showViewNewEmployee(Model model) {
		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "employeeAddEdit";
	}

	@PostMapping(value = "/save")
	public String saveNewEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult) {
		Employee existEmployee = service.findByLogin(employee.getLogin());
		
		if (employee.getId() == null && existEmployee != null) {
			bindingResult.addError(new FieldError("Employee", "login", "Login exists!"));
		}
		
		if (employee.getId() != null && existEmployee != null && existEmployee.getId() != employee.getId()) {
			bindingResult.addError(new FieldError("Employee", "login", "Login exists!"));
		}
		
		if (bindingResult.hasErrors()) {
			return "employeeAddEdit";
		}
		
		String hashedPassword = passwordEncoder.encode(employee.getPassword());
		employee.setPassword(hashedPassword);

		service.save(employee);

		return "redirect:";
	}

	@GetMapping("/edit/{id}")
	public String showEditEmployeeView(@PathVariable(name = "id") Long id, Model model) {
		Employee employee = service.findById(id);
		
		model.addAttribute("employee", employee);

		return "employeeAddEdit";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") Long id) {
		service.deleteById(id);

		return "redirect:/employees";
	}
	
	@PostMapping("/changePassword/{id}")
	public String changePasswordView(@PathVariable(name = "id") Long id, @RequestParam String newPassword) {
		System.out.println("We got new password: " + newPassword);
		
		return "redirect:/employees";
	}

}
