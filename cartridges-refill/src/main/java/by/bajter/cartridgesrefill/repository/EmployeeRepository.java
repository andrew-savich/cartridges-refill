package by.bajter.cartridgesrefill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.bajter.cartridgesrefill.model.employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	public Employee findByLogin(String login);
	
}
