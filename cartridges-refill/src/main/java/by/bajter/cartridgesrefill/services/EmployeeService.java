package by.bajter.cartridgesrefill.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.bajter.cartridgesrefill.model.employee.Employee;
import by.bajter.cartridgesrefill.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	public void save(Employee employee) {
		repository.save(employee);
	}

	public void delete(Employee employee) {
		repository.delete(employee);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Employee findById(long id) {
		return repository.findById(id).get();
	}
	
	public Employee findByLogin(String login) {
		return repository.findByLogin(login);
	}

}
