package by.bajter.cartridgesrefill.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.bajter.cartridgesrefill.model.user.Employee;
import by.bajter.cartridgesrefill.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	public void saveEmployee(Employee employee) {
		repository.save(employee);
	}

	public void deleteEmployee(Employee employee) {
		repository.delete(employee);
	}

	public Employee findById(long id) {
		return repository.findById(id).get();
	}

}
